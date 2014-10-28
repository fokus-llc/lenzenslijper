package us.fok.lenzenslijper.persistence.transactions;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.Privilege;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.ConceptsPageData;
import us.fok.lenzenslijper.selectors.ConceptsSelector;
import us.fok.lenzenslijper.views.ConceptSummaryView;

import java.util.List;
import java.util.UUID;

import static org.jooq.impl.DSL.bitOr;
import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class ConceptsPageReader implements TransactionCallback<ConceptsPageData> {

    protected final JooqContext context;
    protected final ConceptsSelector selector;

    public ConceptsPageReader(JooqContext context, ConceptsSelector selector) {
        this.context = context;
        this.selector = selector;
    }

    @Override
    public ConceptsPageData doInTransaction(TransactionStatus transactionStatus) {
        return fetchConceptsWithCount();
    }

    protected ConceptsPageData fetchConceptsWithCount() {
        List<ConceptSummaryView> concepts = fetchConcepts();
        int count = fetchConceptsCount();
        return new ConceptsPageData(concepts, count);
    }

    private List<ConceptSummaryView> fetchConcepts() {
        SelectJoinStep<? extends Record> relation =
            buildConceptsProjection(context.jooq()).from(CONCEPTS);

        SelectLimitStep<? extends Record> orderedRelation =
            buildConceptsRelation(relation).orderBy(CONCEPTS.NAME);

        SelectFinalStep<? extends Record> fetchableRelation = orderedRelation;
        if (selector.isLimited()) {
            fetchableRelation = orderedRelation.
                limit(selector.getLimit()).
                offset(selector.getOffset());
        }

        return fetchableRelation.fetchInto(ConceptSummaryView.class);
    }

    private SelectFromStep<? extends Record> buildConceptsProjection(DSLContext jooq) {
        return (selector.getParentConceptId() != null) ?
            jooq.select(CONCEPTS.CONCEPT_ID,
                        LINKABLES.LINKABLE_ID,
                        DSL.fieldByName(UUID.class, "rnc", "parent_concept_id"),
                        PROJECTS.SLUG.as("project_slug"), CONCEPTS.SLUG,
                        CONCEPTS.NAME, CONCEPTS.SHORT_NAME) :
            jooq.select(CONCEPTS.CONCEPT_ID,
                        LINKABLES.LINKABLE_ID,
                        PROJECTS.SLUG.as("project_slug"), CONCEPTS.SLUG,
                        CONCEPTS.NAME, CONCEPTS.SHORT_NAME);
    }

    private SelectOrderByStep<? extends Record> buildConceptsRelation(SelectJoinStep<? extends Record> relation) {
        SelectWhereStep<? extends Record> joinedRelation =
            relation.
                join(PROJECTS).
                    on(PROJECTS.PROJECT_ID.eq(CONCEPTS.PROJECT_ID)).
                join(LINKABLES).
                    on(LINKABLES.CONCEPT_ID.eq(CONCEPTS.CONCEPT_ID));
        if (selector.getParentConceptId() != null) {
            joinedRelation = joinNarrowingConcepts(relation, selector.getParentConceptId());
        }

        SelectConditionStep<? extends Record> conditionalRelation =
            joinedRelation.where(bitOr(PROJECTS.DEFAULT_MODE, Privilege.DIRECTORY.getValue()).ne(0));
        if (selector.getProjectId() != null) {
            conditionalRelation = conditionalRelation.and(CONCEPTS.PROJECT_ID.eq(selector.getProjectId()));
        }

        String prefix = selector.getPrefix();
        if (prefix != null) {
            String pattern = prefix + "%";
            conditionalRelation = conditionalRelation.and(CONCEPTS.NAME.likeIgnoreCase(pattern));
        }
        return conditionalRelation;
    }

    private SelectWhereStep<? extends Record> joinNarrowingConcepts(SelectJoinStep<? extends Record> relation, UUID parentConceptId) {
       return relation.
            join("recursively_narrowed_concepts('" + parentConceptId + "') rnc").
            on(DSL.fieldByName(UUID.class, "rnc", "concept_id").eq(CONCEPTS.CONCEPT_ID));
    }

    private int fetchConceptsCount() {
        return (selector.getParentConceptId() != null) ?
            countProjectNarrowingConcepts() : countProjectConcepts();
    }

    private int countProjectConcepts() {
        SelectJoinStep<? extends Record> projection = countProjection(context.jooq());

        SelectFinalStep<? extends Record> relation = projection;

        UUID projectId = selector.getProjectId();
        if (projectId != null) {
            relation = projection.where(CONCEPTS.PROJECT_ID.eq(selector.getProjectId()));
        }

        return relation.fetchOne(count());
    }

    private SelectJoinStep<? extends Record> countProjection(DSLContext jooq) {
        return jooq.selectCount().from(CONCEPTS);
    }

    private int countProjectNarrowingConcepts() {
        DSLContext jooq = context.jooq();
        SelectJoinStep<? extends Record> projection = countProjection(jooq);

        SelectConditionStep<? extends Record> relation = null;

        UUID projectId = selector.getProjectId();
        if (projectId != null) {
            relation = projection.
                where(CONCEPTS.PROJECT_ID.eq(projectId)).
                andExists(jooq.selectOne().
                from("recursively_narrowed_concepts('" + selector.getParentConceptId() + "') rnc").
                where(DSL.fieldByName(UUID.class, "rnc", "concept_id").eq(CONCEPTS.CONCEPT_ID)));
        }
        else {
            relation = projection.
                whereExists(
                    jooq.selectOne().
                    from("recursively_narrowed_concepts('" + selector.getParentConceptId() + "') rnc").
                    where(DSL.fieldByName(UUID.class, "rnc", "concept_id").eq(CONCEPTS.CONCEPT_ID)));
        }

        return relation.fetchOne(count());
    }

}
