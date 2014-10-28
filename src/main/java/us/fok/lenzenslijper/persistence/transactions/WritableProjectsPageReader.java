package us.fok.lenzenslijper.persistence.transactions;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.Privilege;
import us.fok.lenzenslijper.models.dto.MutableProjectWithMode;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.mappers.ProjectWithModeMapper;
import us.fok.lenzenslijper.persistence.transactions.data.ProjectPageData;
import us.fok.lenzenslijper.selectors.ProjectsSelector;
import us.fok.lenzenslijper.util.CollectionTransformations;

import java.util.*;

import static org.jooq.impl.DSL.bitAnd;
import static org.jooq.impl.DSL.bitOr;
import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class WritableProjectsPageReader implements TransactionCallback<ProjectPageData> {

    private final JooqContext context;
    private final ProjectsSelector selector;

    public WritableProjectsPageReader(JooqContext context, ProjectsSelector selector) {
        this.context = context;
        this.selector = selector;
    }

    @Override
    public ProjectPageData doInTransaction(TransactionStatus transactionStatus) {
        return selector.isUserPermissioned() ?
            fetchGloballyAndGrantedWritableProjectsWithCount() :
            fetchGloballyWritableProjectsWithCount();
    }

    private ProjectPageData fetchGloballyAndGrantedWritableProjectsWithCount() {
        UUID userId = selector.getPermissionsUserId();
        List<ProjectWithMode> projects = fetchGloballyAndGrantedWritableProjects(userId);
        int globalCount = countGloballyWritableProjects();
        int grantedCount = countGrantedGloballyNonWritableProjects(userId);
        return new ProjectPageData(projects, globalCount + grantedCount);
    }

    private ProjectPageData fetchGloballyWritableProjectsWithCount() {
        List<ProjectWithMode> projects = fetchGloballyWritableProjects();
        int count = countGloballyWritableProjects();
        return new ProjectPageData(projects, count);
    }

    private List<ProjectWithMode> fetchGloballyAndGrantedWritableProjects(UUID userId) {
        List<ProjectWithMode> globallyWritableProjects = fetchGloballyWritableProjects();
        List<ProjectWithMode> grantedWritableProjects = fetchGrantedWritableProjects(userId);
        return mergeProjects(globallyWritableProjects, grantedWritableProjects);
    }

    private List<ProjectWithMode> fetchGloballyWritableProjects() {
        SelectFinalStep<? extends Record> fetchableSelection = null;
        SelectConditionStep<? extends Record> orderableSelection = selectGloballyWritableSummaries();
        // ASSUME: ProjectsSelector.Sort.NAME
        SelectLimitStep<? extends Record> limitableStep = orderableSelection.orderBy(PROJECTS.NAME);
        fetchableSelection = applyLimit(limitableStep);
        return fetchableSelection.fetch(new ProjectWithModeMapper());
    }

    private List<UUID> fetchRecentlyRevisedGloballyWritableProjectIds(DSLContext jooq) {
        SelectLimitStep<? extends Record> projectIdRelation = jooq.
            select(DSL.field("DISTINCT ON(documents.project_id) documents.project_id", UUID.class).as("project_id")).
            from(REVISIONS).
            join(DOCUMENTS).
                on(DOCUMENTS.DOCUMENT_ID.eq(REVISIONS.DOCUMENT_ID)).
            join(PROJECTS).
                on(PROJECTS.PROJECT_ID.eq(DOCUMENTS.PROJECT_ID)).
            where(bitAnd(PROJECTS.DEFAULT_MODE, Privilege.UPDATE.getValue()).ne(0)).
            orderBy(DOCUMENTS.PROJECT_ID.asc(), REVISIONS.CREATED.desc());

        SelectFinalStep<? extends Record> fetchable = projectIdRelation;
        if (selector.isLimited()) {
            fetchable = projectIdRelation.limit(selector.getOffset(), selector.getLimit());
        }

        return fetchable.fetch(DSL.field("project_id", UUID.class));
    }

    private List<ProjectWithMode> fetchGrantedWritableProjects(UUID userId) {
        SelectOrderByStep<? extends Record> orderableSelection = selectGrantedProjectSummaries(userId);
        SelectLimitStep<? extends Record> limitableSelection = orderableSelection.orderBy(PROJECTS.NAME);
        SelectFinalStep<? extends Record> fetchableSelection = applyLimit(limitableSelection);
        return fetchableSelection.fetch(new ProjectWithModeMapper());
    }

    private SelectConditionStep<? extends Record> selectGloballyWritableSummaries() {
        SelectSelectStep<? extends Record> projection = context.jooq().
            select(PROJECTS.PROJECT_ID,
                   PROJECTS.SLUG,
                   PROJECTS.NAME,
                   USERS.USERNAME.as("creator"),
                   PROJECTS.DEFAULT_MODE.as("mode"));
        return selectGloballyWritableProjects(projection);
    }

    private <T extends Record> SelectConditionStep<T> selectGloballyWritableProjects(SelectSelectStep<T> projection) {
        return projection.
            from(PROJECTS).
            join(USERS).
                on(USERS.USER_ID.eq(PROJECTS.CREATOR_USER_ID)).
            where(bitAnd(PROJECTS.DEFAULT_MODE, Privilege.UPDATE.getValue()).ne(0));
    }

    private SelectOrderByStep<? extends Record> selectGrantedProjectSummaries(UUID userId) {
        Field<Integer> modeField = bitOr(PROJECTS.DEFAULT_MODE, VIRTUAL_AGGREGATE_GRANTS.MODE).as("mode");
        SelectSelectStep<? extends Record> projection = context.jooq().
            select(PROJECTS.PROJECT_ID, PROJECTS.SLUG, PROJECTS.NAME,
                   USERS.USERNAME.as("creator"),
                   modeField);
        return selectProjectsJoiningWritableGrants(projection, modeField, userId);
    }

    private <T extends Record> SelectConditionStep<T> selectProjectsJoiningWritableGrants(SelectSelectStep<T> projection, Field<Integer> modeField, UUID userId) {
        return projection.
            from(PROJECTS).
            join(USERS).
                on(USERS.USER_ID.eq(PROJECTS.CREATOR_USER_ID)).
            join(VIRTUAL_AGGREGATE_GRANTS).
                on(VIRTUAL_AGGREGATE_GRANTS.PROJECT_ID.eq(PROJECTS.PROJECT_ID)).
            where(VIRTUAL_AGGREGATE_GRANTS.USER_ID.equal(userId)).
                and(bitAnd(modeField, Privilege.UPDATE.getValue()).ne(0));
    }

    private <T extends Record> SelectFinalStep<T> applyLimit(SelectLimitStep<T> selection) {
        Integer limit = selector.getLimit();
        return (limit == null) ? selection : selection.limit(selector.getOffset(), limit);
    }

    private List<ProjectWithMode> mergeProjects(List<ProjectWithMode> alpha, List<ProjectWithMode> beta) {
        SortedMap<String, ProjectWithMode> projectsByName = new TreeMap<String, ProjectWithMode>();
        for(ProjectWithMode project : alpha) { projectsByName.put(project.getName(), project); }
        for(ProjectWithMode project : beta) { addOrMergeProject(project, projectsByName); }
        return applyOffsetAndLimitToCollection(projectsByName.values(), selector);
    }

    private void addOrMergeProject(ProjectWithMode project, Map<String, ProjectWithMode> projectsByName) {
        String projectName = project.getName();
        ProjectWithMode oldProject = projectsByName.get(projectName);
        if (oldProject == null) {
            projectsByName.put(projectName, project);
        }
        else {
            projectsByName.put(projectName, projectWithMergedMode(oldProject, project.getMode()));
        }
    }

    private ProjectWithMode projectWithMergedMode(ProjectWithMode oldProject, int mode) {
        MutableProjectWithMode project = new MutableProjectWithMode(oldProject);
        project.setMode(project.getMode() | mode);
        return project;
    }

    private <T> List<T> applyOffsetAndLimitToCollection(Collection<T> collection, ProjectsSelector selector) {
        return selector.isLimited() ?
            CollectionTransformations.sublist(collection, selector.getOffset(), selector.getLimit()) :
            new ArrayList<T>(collection);
    }

    private int countGloballyWritableProjects() {
        SelectSelectStep<Record1<Integer>> countProjection = context.jooq().selectCount();
        return selectGloballyWritableProjects(countProjection).fetchOne(count());
    }

    private int countGrantedGloballyNonWritableProjects(UUID userId) {
        Field<Integer> modeField = bitOr(PROJECTS.DEFAULT_MODE, VIRTUAL_AGGREGATE_GRANTS.MODE).as("mode");
        SelectSelectStep<Record1<Integer>> countProjection = context.jooq().selectCount();
        return selectProjectsJoiningWritableGrants(countProjection, modeField, userId).
            and(bitAnd(PROJECTS.DEFAULT_MODE, Privilege.UPDATE.getValue()).eq(0)).
            groupBy(PROJECTS.PROJECT_ID).
            fetchCount();
    }

}
