package us.fok.lenzenslijper.persistence.transactions.published;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.DocumentPageData;
import us.fok.lenzenslijper.selectors.DocumentsSelector;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class DocumentsPageReader implements TransactionCallback<DocumentPageData> {

    private final JooqContext context;
    private final DocumentsSelector selector;

    public DocumentsPageReader(JooqContext context, DocumentsSelector selector) {
        this.context = context;
        this.selector = selector;
    }

    @Override
    public DocumentPageData doInTransaction(TransactionStatus transactionStatus) {
        return new DocumentPageData(fetchDocuments(), countDocuments());
    }

    private List<ProjectUserDocumentSummary> fetchDocuments() {
        SelectSelectStep<Record10<UUID, UUID, Integer, UUID, String, UUID, UUID, Timestamp, String, String>> projection =
            ProjectUserDocumentSummary.projection(context.jooq());
        return buildDocumentsSelection(projection).fetchInto(ProjectUserDocumentSummary.class);
    }

    private <T extends Record> SelectFinalStep<T> buildDocumentsSelection(SelectSelectStep<T> projection) {
        SelectJoinStep<T> joinedRelation = selectFromJoin(projection);
        SelectOrderByStep<T> orderableRelation = applySelectorConditions(joinedRelation);
        SelectLimitStep<T> limitableRelation = applySelectorOrder(orderableRelation);
        return applySelectorLimitAndOffset(limitableRelation);
    }

    private <T extends Record> SelectJoinStep<T> selectFromJoin(SelectSelectStep<T> projection) {
        return projection.
            from(PUBLISHED_DEFINITION_SUMMARIES).
            join(LINKABLES).
                on(LINKABLES.DOCUMENT_ID.eq(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID)).
            join(PROJECTS).
                on(PROJECTS.PROJECT_ID.eq(PUBLISHED_DEFINITION_SUMMARIES.PROJECT_ID)).
            leftOuterJoin(USERS).
                on(USERS.USER_ID.eq(PUBLISHED_DEFINITION_SUMMARIES.USER_ID));
    }

    private <T extends Record> SelectOrderByStep<T> applySelectorConditions(SelectJoinStep<T> relation) {

        UUID prototypeConceptId = selector.getPrototypeConceptId();
        if (prototypeConceptId != null) {
            relation = relation.
                join("recursively_narrowed_concepts('" + prototypeConceptId + "') rnc").
                    on("rnc.concept_id = published_definition_summaries.prototype_concept_id");
        }

        SelectConditionStep<T> conditions = null;

        UUID projectId = selector.getProjectId();
        if (projectId != null) {
            conditions = relation.
                where(PUBLISHED_DEFINITION_SUMMARIES.PROJECT_ID.eq(projectId));
        }

        // NOTE: only scanning primary titles, case folding may be expensive
        String prefix = selector.getPrefix();
        if (prefix != null) {
            conditions = conditions == null ?
                relation.where(PUBLISHED_DEFINITION_SUMMARIES.TITLE.likeIgnoreCase(prefix + '%')) :
                conditions.and(PUBLISHED_DEFINITION_SUMMARIES.TITLE.likeIgnoreCase(prefix + '%'));
        }

        Integer documentTypeId = selector.getDocumentTypeId();
        if (documentTypeId != null) {
            conditions = conditions == null ?
                relation.where(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID.eq(documentTypeId)) :
                conditions.and(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID.eq(documentTypeId));
        }

        // OPTIMIZE
        UUID relatedConceptLinkableId = selector.getRelatedConceptLinkableId();
        if (relatedConceptLinkableId != null) {
            SelectConditionStep<Record1<Integer>> existsClause = context.jooq().
                selectOne().
                from(REVISION_LINKS.as("links2")).
                where(DSL.fieldByName(UUID.class, "links2", "revision_id").eq(PUBLISHED_DEFINITION_SUMMARIES.REVISION_ID)).
                    and(DSL.fieldByName(Integer.class, "links2", "link_type_id").eq(SystemSchemaConstants.LINK_TYPE_ID_CONCEPT)).
                    and(DSL.fieldByName(UUID.class, "links2", "target_linkable_id").eq(relatedConceptLinkableId));
            conditions = conditions == null ? relation.whereExists(existsClause) : conditions.andExists(existsClause);
        }

        return conditions == null ? relation : conditions;
    }

    private <T extends Record> SelectLimitStep<T> applySelectorOrder(SelectOrderByStep<T> selection) {
        SelectLimitStep<T> limitStep;
        switch(selector.getSort()) {
            case RECENT:
                limitStep = selection.orderBy(PUBLISHED_DEFINITION_SUMMARIES.ASSESSED.desc());
                break;
            case NAME:
            default:
                limitStep = selection.orderBy(PUBLISHED_DEFINITION_SUMMARIES.TITLE.asc());
                break;
        }
        return limitStep;
    }

    private <T extends Record> SelectFinalStep<T> applySelectorLimitAndOffset(SelectLimitStep<T> selection) {
        return selector.isLimited() ?
            selection.limit(defaultZero(selector.getOffset()), selector.getLimit()) :
            selection;
    }

    private int countDocuments() {
        SelectSelectStep<Record1<Integer>> countProjection = context.jooq().selectCount();
        SelectJoinStep<Record1<Integer>> countRelation = countProjection.from(PUBLISHED_DEFINITION_SUMMARIES);
        SelectFinalStep<Record1<Integer>> fetchableRelation = applySelectorConditions(countRelation);
        return fetchableRelation.fetchOne(count());
    }

    private int defaultZero(Integer optional) {
        return optional == null ? 0 : optional.intValue();
    }

}
