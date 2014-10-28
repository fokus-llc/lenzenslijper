package us.fok.lenzenslijper.persistence.repositories.impl;

import org.jooq.*;
import org.springframework.transaction.support.TransactionTemplate;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;
import us.fok.lenzenslijper.models.pagination.ListPaginator;
import us.fok.lenzenslijper.models.pagination.PaginatedList;
import us.fok.lenzenslijper.persistence.transactions.VisibleProjectsPageReader;
import us.fok.lenzenslijper.persistence.transactions.WritableProjectsPageReader;
import us.fok.lenzenslijper.persistence.transactions.data.ProjectPageData;
import us.fok.lenzenslijper.selectors.ProjectsSelector;
import us.fok.lenzenslijper.persistence.mappers.ProjectWithModeMapper;

import javax.sql.DataSource;
import java.util.*;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class JooqProjectsRepository extends AbstractJooqRepository {

    public JooqProjectsRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public PaginatedList<ProjectWithMode> fetchVisibleProjectsPaginated(ProjectsSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch visible projects");
        ProjectPageData data = tx.execute(new VisibleProjectsPageReader(this, selector));
        ListPaginator<ProjectWithMode> paginator = new ListPaginator<ProjectWithMode>(data.getProjects());
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

    public PaginatedList<ProjectWithMode> fetchWritableProjectsPaginated(ProjectsSelector selector) {
        TransactionTemplate tx = buildReadOnlyTransactionTemplate("fetch writable projects");
        ProjectPageData data = tx.execute(new WritableProjectsPageReader(this, selector));
        ListPaginator<ProjectWithMode> paginator = new ListPaginator<ProjectWithMode>(data.getProjects());
        return selector.isSelectAll() ?
            paginator.paginateAll() :
            paginator.paginate(data.getCount(), selector.getOffset(), selector.getLimit());
    }

    public ProjectWithMode fetchVisibleProjectWithMode(String projectSlug) {
        Record5<UUID, String, String, Integer, String> rec =
            selectProjectsWithMode().
                where(PROJECTS.SLUG.equal(projectSlug)).
                limit(1).
                fetchOne();
        return rec == null ? null : new ProjectWithModeMapper().map(rec);
    }

    private SelectJoinStep<Record5<UUID, String, String, Integer, String>> selectProjectsWithMode() {
        return jooq().
            select(PROJECTS.PROJECT_ID, PROJECTS.SLUG, PROJECTS.NAME,
                PROJECTS.DEFAULT_MODE.as("mode"),
                USERS.USERNAME.as("creator")).
            from(PROJECTS).
            join(USERS).
                on(USERS.USER_ID.eq(PROJECTS.CREATOR_USER_ID));
    }

}
