package us.fok.lenzenslijper.persistence.repositories.impl;

import org.jooq.*;
import org.jooq.impl.DSL;
import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.LinkTypeRecord;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class JooqOntologyRepository extends AbstractJooqRepository {

    public JooqOntologyRepository(DataSource dataSource, SchemaDictionary dictionary) {
        super(dataSource, dictionary);
    }

    public List<LinkTypeRecord> fetchLinkTypes(UUID domainPrototypeConceptId, UUID rangePrototypeConceptId, Integer targetTypeId) {
        DSLContext jooq = jooq();

        Field<String> converseTypeSlug = DSL.field("converse.slug", String.class);

        Field<UUID> domainPrototypeId = DSL.field("domain_concepts.concept_id", UUID.class);
        Field<String> domainPrototypeSlug = DSL.field("domain_concepts.slug", String.class);

        SelectJoinStep<? extends Record> projection = jooq.

            select(LINK_TYPES.SLUG,
                   LINK_TARGET_TYPES.SLUG.as("target_type_slug"), // NOTE: underscore -> camelCase mapping
                   domainPrototypeSlug.as("domain_prototype_slug"),
                   CONCEPTS.SLUG.as("range_prototype_slug"),
                   converseTypeSlug.as("converse_slug")).

            from(LINK_TYPES).
            join(LINK_TARGET_TYPES).
                on(LINK_TARGET_TYPES.LINK_TARGET_TYPE_ID.eq(LINK_TYPES.LINK_TARGET_TYPE_ID)).
            leftOuterJoin(LINK_TYPES.as("converse")).
                on("converse.link_type_id = link_types.converse_link_type_id").
            leftOuterJoin(CONCEPTS).
                on(CONCEPTS.CONCEPT_ID.eq(LINK_TYPES.RANGE_CONCEPT_ID)).
            leftOuterJoin(CONCEPTS.as("domain_concepts")).
                on(domainPrototypeId.eq(LINK_TYPES.DOMAIN_CONCEPT_ID));

        if (domainPrototypeConceptId != null) {
            projection = projection.
                join("recursively_broadened_concepts('" + domainPrototypeConceptId + "') drbc").
                on("drbc.concept_id = link_types.domain_concept_id");
        }

        if (rangePrototypeConceptId != null) {
            projection = projection.
                join("recursively_narrowed_concepts('" + rangePrototypeConceptId + "') rrnc").
                on("rrnc.concept_id = link_types.range_concept_id");
        }

        SelectConditionStep<? extends Record> conditionalRelation = null;
        if (targetTypeId != null) {
            conditionalRelation = projection.where(LINK_TYPES.LINK_TARGET_TYPE_ID.eq(targetTypeId));
        }

        /*
        if (domainPrototypeConceptId != null) {
            if (conditionalRelation == null) {
                conditionalRelation = projection.where(LINK_TYPES.DOMAIN_CONCEPT_ID.eq(domainPrototypeConceptId));
            }
            else {
                conditionalRelation = conditionalRelation.and(LINK_TYPES.DOMAIN_CONCEPT_ID.eq(domainPrototypeConceptId));
            }
        }
        */

        SelectFinalStep<? extends Record> fetchableRelation = conditionalRelation == null ? projection : conditionalRelation;
        return fetchableRelation.fetchInto(LinkTypeRecord.class);
    }

}
