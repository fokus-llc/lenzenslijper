package us.fok.lenzenslijper.persistence.transactions;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.views.ConceptNestableView;

import java.util.*;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class ConceptSetReader implements TransactionCallback<ConceptNestableView> {

    private final JooqContext context;
    private final UUID topConceptSetId;

    public ConceptSetReader(JooqContext context, UUID topConceptSetId) {
        this.context = context;
        this.topConceptSetId = topConceptSetId;
    }

    @Override
    public ConceptNestableView doInTransaction(TransactionStatus transactionStatus) {
        return fetchConceptNestable();
    }

    public ConceptNestableView fetchConceptNestable() {
        DSLContext jooq = context.jooq();
        Map<UUID, ? extends Result<? extends Record>> setsByParent = fetchSetsRecursively(jooq);
        List<UUID> conceptSetIds = extractConceptSetIds(setsByParent);
        Map<UUID, ? extends Result<? extends Record>> conceptsByParent = fetchConceptsBySet(jooq, conceptSetIds);
        return buildConceptNestable(setsByParent.get(null).get(0), setsByParent, conceptsByParent);
    }

    private Map<UUID, ? extends Result<? extends Record>> fetchSetsRecursively(DSLContext jooq) {
        SelectSelectStep<? extends Record> projection =
            jooq.select(DSL.fieldByName(UUID.class, "rcs", "concept_set_id"),
                        DSL.fieldByName(UUID.class, "rcs", "parent_concept_set_id"),
                        DSL.fieldByName(Integer.class, "rcs", "rank"),
                        DSL.fieldByName(UUID.class, "rcs", "project_id"),
                        DSL.fieldByName(String.class, "rcs", "name"),
                        DSL.fieldByName(String.class, "rcs", "short_name"));

        SelectJoinStep<? extends Record> relation =
            projection.from("recursive_concept_sets('" + topConceptSetId + "') rcs");

         return relation.fetchGroups(DSL.fieldByName(UUID.class, "rcs", "parent_concept_set_id"));
    }

    private List<UUID> extractConceptSetIds(Map<UUID, ? extends Result<? extends Record>> setsByParent) {
        List<UUID> conceptSetIds = new ArrayList<UUID>();
        Field<UUID> field = DSL.fieldByName(UUID.class, "rcs", "concept_set_id");
        for(Map.Entry<UUID, ? extends Result<? extends Record>> entry : setsByParent.entrySet()) {
            Result<? extends Record> records = entry.getValue();
            for (Record record : records) {
                conceptSetIds.add(record.getValue(field));
            }
        }
        return conceptSetIds;
    }

    private Map<UUID,? extends Result<? extends Record>> fetchConceptsBySet(DSLContext jooq, List<UUID> conceptSetIds) {
        return jooq.select(CONCEPT_SET_MEMBERSHIPS.CONCEPT_SET_ID.as("parent_concept_set_id"),
                           CONCEPT_SET_MEMBERSHIPS.MEMBER_CONCEPT_ID.as("concept_id"),
                           CONCEPT_SET_MEMBERSHIPS.RANK,
                           CONCEPTS.PROJECT_ID,
                           CONCEPTS.NAME,
                           CONCEPTS.SHORT_NAME,
                           CONCEPTS.SLUG).
            from(CONCEPT_SET_MEMBERSHIPS).
            join(CONCEPTS).
                on(CONCEPTS.CONCEPT_ID.eq(CONCEPT_SET_MEMBERSHIPS.MEMBER_CONCEPT_ID)).
            where(CONCEPT_SET_MEMBERSHIPS.CONCEPT_SET_ID.in(conceptSetIds)).
            fetchGroups(DSL.fieldByName(UUID.class, "parent_concept_set_id"));
    }

    private ConceptNestableView buildConceptNestable(Record topResult, Map<UUID, ? extends Result<? extends Record>> setsByParent, Map<UUID, ? extends Result<? extends Record>> conceptsByParent) {
        ConceptNestableView topSet = topResult.into(ConceptNestableView.class);
        nestSetsAndConcepts(topSet, setsByParent, conceptsByParent);
        return topSet;
    }

    private void nestSetsAndConcepts(ConceptNestableView top, Map<UUID, ? extends Result<? extends Record>> setsByParent, Map<UUID, ? extends Result<? extends Record>> conceptsByParent) {
        UUID topConceptSetId = top.getConceptSetId();
        List<ConceptNestableView> childSets = nestSets(setsByParent, conceptsByParent, topConceptSetId);
        List<ConceptNestableView> childConcepts = nestConcepts(conceptsByParent, topConceptSetId);
        List<ConceptNestableView> childNestables = concatenateAndSort(childSets, childConcepts);
        top.setChildren(childNestables);
    }

    private List<ConceptNestableView> nestSets(Map<UUID, ? extends Result<? extends Record>> setsByParent, Map<UUID, ? extends Result<? extends Record>> conceptsByParent, UUID topConceptSetId) {
        List<ConceptNestableView> childSets = null;
        Result<? extends Record> childSetResults = setsByParent.get(topConceptSetId);
        if (childSetResults != null) {
            childSets = childSetResults.into(ConceptNestableView.class);
            for (ConceptNestableView childSet : childSets) {
                nestSetsAndConcepts(childSet, setsByParent, conceptsByParent);
            }
        }
        return childSets;
    }

    private List<ConceptNestableView> nestConcepts(Map<UUID, ? extends Result<? extends Record>> conceptsByParent, UUID conceptSetId) {
        List<ConceptNestableView> childConcepts = null;
        Result<? extends Record> childConceptResults = conceptsByParent.get(conceptSetId);
        if (childConceptResults != null) {
            childConcepts = childConceptResults.into(ConceptNestableView.class);
        }
        return childConcepts;
    }

    private List<ConceptNestableView> concatenateAndSort(List<ConceptNestableView> childSets, List<ConceptNestableView> childConcepts) {
        List<ConceptNestableView> childNestables;
        if (childSets != null) {
            childNestables = childSets;
            if (childConcepts != null) { childNestables.addAll(childConcepts); }
            Collections.sort(childNestables);
        }
        else if (childConcepts != null) {
            childNestables = childConcepts;
            Collections.sort(childNestables);
        }
        else {
            childNestables = Collections.emptyList();
        }
        return childNestables;
    }

}
