package us.fok.lenzenslijper.persistence.transactions.published;

import org.jooq.DSLContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.EntityDetailData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class EntityDetailReader implements TransactionCallback<EntityDetailData> {

    private final JooqContext context;
    private final UUID entityId;

    public EntityDetailReader(JooqContext context, UUID entityId) {
        this.context = context;
        this.entityId = entityId;
    }

    @Override
    public EntityDetailData doInTransaction(TransactionStatus transactionStatus) {
        return fetchEntityData(context.jooq(), entityId);
    }

    private EntityDetailData fetchEntityData(DSLContext jooq, UUID entityId) {
        EntityDetailData datum = null;

        List<ProjectUserDocumentSummary> summaries = fetchPublishedSummaries(jooq, entityId);
        if (! summaries.isEmpty()) {
            datum = new EntityDetailData();
            datum.setEntityId(entityId);

            datum.setPrototypeConceptId(summaries.get(0).getPrototypeConceptId());
            datum.setDocumentSummaries(summaries);

            List<UUID> documentIds = pluckDocumentIds(summaries);

            List<ReleasedLinkSummary> outgoingLinks = fetchOutgoingLinks(jooq, documentIds);
            datum.setOutgoingLinks(outgoingLinks);

            List<ReleasedLinkSummary> incomingLinks = fetchIncomingLinks(jooq, documentIds);
            datum.setIncomingLinks(incomingLinks);
        }

        return datum;
    }

    // NOTE: not paging
    private List<ProjectUserDocumentSummary> fetchPublishedSummaries(DSLContext jooq, UUID entityId) {
        return ProjectUserDocumentSummary.publishedRelation(jooq).
            where(PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID.eq(entityId)).
            orderBy(PUBLISHED_DEFINITION_SUMMARIES.ASSESSED.desc()).
            fetchInto(ProjectUserDocumentSummary.class);
    }

    private List<ReleasedLinkSummary> fetchOutgoingLinks(DSLContext jooq, List<UUID> documentIds) {
        return jooq.select(PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID,
                           PUBLISHED_LINK_SUMMARIES.TARGET_TITLE,
                           PUBLISHED_LINK_SUMMARIES.TARGET_VALUE,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.PROTOTYPE_CONCEPT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID).
            from(PUBLISHED_LINK_SUMMARIES).
            leftOuterJoin(LINKABLES).
                on(LINKABLES.LINKABLE_ID.
                    eq(PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID)).
            leftOuterJoin(PUBLISHED_DEFINITION_SUMMARIES).
                on(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID.
                    eq(LINKABLES.DOCUMENT_ID)).
            where(PUBLISHED_LINK_SUMMARIES.DOCUMENT_ID.in(documentIds)).
            fetchInto(ReleasedLinkSummary.class);
    }

    private List<ReleasedLinkSummary> fetchIncomingLinks(DSLContext jooq, List<UUID> documentIds) {
        return jooq.select(PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.TITLE,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.PROTOTYPE_CONCEPT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID).
            from(LINKABLES).
            join(PUBLISHED_LINK_SUMMARIES).
                on(PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID.eq(LINKABLES.LINKABLE_ID)).
            join(PUBLISHED_DEFINITION_SUMMARIES).
                on(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID.
                    eq(PUBLISHED_LINK_SUMMARIES.DOCUMENT_ID)).
            where(LINKABLES.DOCUMENT_ID.in(documentIds)).
            fetchInto(ReleasedLinkSummary.class);
    }

    private List<UUID> pluckDocumentIds(List<ProjectUserDocumentSummary> summaries) {
        List<UUID> documentIds = new ArrayList<UUID>(summaries.size());
        for (ProjectUserDocumentSummary summary : summaries) {
            documentIds.add(summary.getDocumentId());
        }
        return documentIds;
    }

}
