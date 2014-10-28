package us.fok.lenzenslijper.persistence.transactions.published;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.ConceptSetReader;
import us.fok.lenzenslijper.persistence.transactions.data.DocumentDetailData;
import us.fok.lenzenslijper.views.ConceptNestableView;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class DocumentDetailReader implements TransactionCallback<DocumentDetailData> {

    private final JooqContext context; // is it ok to pass a DSLContext constructed before tx started?
    private final UUID linkableDocumentId;
    private final UUID revisionId;

    public DocumentDetailReader(JooqContext context, UUID linkableDocumentId, UUID revisionId) {
        this.context = context;
        this.linkableDocumentId = linkableDocumentId;
        this.revisionId = revisionId;
    }

    @Override
    public DocumentDetailData doInTransaction(TransactionStatus status) {
        return fetchDocumentData(context.jooq(), linkableDocumentId, revisionId);
    }

    private DocumentDetailData fetchDocumentData(DSLContext jooq, UUID documentLinkableId, UUID revisionId) {
        DocumentDetailData datum = null;
        ProjectUserDocumentSummary summary = fetchPublishedEnrichedDocumentSummary(jooq, documentLinkableId, revisionId);
        if (summary != null) {

            datum = new DocumentDetailData();
            datum.setPublicationSummary(summary);

            revisionId = summary.getRevisionId();
            datum.setEnrolledAssets(fetchAssets(jooq, revisionId));

            UUID entityId = summary.getEntityId();
            if (entityId != null) {
                datum.setEntityLink(fetchEntityLink(jooq, entityId));
            }

            UUID documentId = summary.getDocumentId();
            datum.setLinks(fetchPublishedOutgoingLinks(jooq, revisionId));
            datum.setIncomingLinks(fetchPublishedIncomingLinks(jooq, documentId));

            if (summary.getDocumentTypeId() == SystemSchemaConstants.DOCUMENT_TYPE_ID_COLLECTION) {
                UUID conceptSetId = fetchConceptSetId(jooq, summary.getDocumentId());
                if (conceptSetId != null) {
                    datum.setConceptSet(fetchConceptSet(conceptSetId));
                }
            }

        }
        return datum;
    }

    private ProjectUserDocumentSummary fetchPublishedEnrichedDocumentSummary(DSLContext jooq, UUID documentLinkableId, UUID revisionId) {
        SelectConditionStep<Record10<UUID, UUID, Integer, UUID, String, UUID, UUID,Timestamp, String, String>> relation =
            ProjectUserDocumentSummary.publishedRelation(jooq).
                where(LINKABLES.LINKABLE_ID.eq(documentLinkableId));
        if (revisionId != null) {
            relation = relation.and(PUBLISHED_DEFINITION_SUMMARIES.REVISION_ID.eq(revisionId));
        }
        Record rec = relation.fetchAny();
        return rec == null ? null : rec.into(ProjectUserDocumentSummary.class);
    }

    private List<EnrolledAsset> fetchAssets(DSLContext jooq, UUID revisionId) {
        return jooq.
            select(REVISION_ASSET_ROLES.ASSET_ROLE_ID, REVISION_ASSET_ROLES.TITLE, ASSETS.ASSET_TYPE_ID, ASSETS.CONTENT).
            from(REVISION_ASSET_ROLES).
            join(ASSETS).
            on(ASSETS.ASSET_ID.eq(REVISION_ASSET_ROLES.ASSET_ID)).
            where(REVISION_ASSET_ROLES.REVISION_ID.eq(revisionId)).
            fetch().
            into(EnrolledAsset.class);
    }

    private UUID fetchEntityLink(DSLContext jooq, UUID entityId) {
        return jooq.
            select(LINKABLES.LINKABLE_ID).
            from(LINKABLES).
            where(LINKABLES.ENTITY_ID.eq(entityId)).
            fetchOne(LINKABLES.LINKABLE_ID);
    }

    private List<ReleasedLinkSummary> fetchPublishedOutgoingLinks(DSLContext jooq, UUID revisionId) {
        return jooq.select(PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID,
                           PUBLISHED_LINK_SUMMARIES.TARGET_TITLE,
                           PUBLISHED_LINK_SUMMARIES.TARGET_VALUE,
                           PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID,
                           PUBLISHED_LINK_SUMMARIES.RANK,
                           PUBLISHED_LINK_SUMMARIES.TIME_RANGE,
                           PUBLISHED_LINK_SUMMARIES.BEGINNING,
                           PUBLISHED_LINK_SUMMARIES.ENDING,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.PROTOTYPE_CONCEPT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID).
            from(PUBLISHED_LINK_SUMMARIES).
            leftOuterJoin(LINKABLES).
                on(LINKABLES.LINKABLE_ID.eq(PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID)).
            leftOuterJoin(PUBLISHED_DEFINITION_SUMMARIES).
                on(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID.
                    eq(LINKABLES.DOCUMENT_ID)).
            where(PUBLISHED_LINK_SUMMARIES.REVISION_ID.eq(revisionId)).
            orderBy(PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID, PUBLISHED_LINK_SUMMARIES.RANK).
            fetchInto(ReleasedLinkSummary.class);
    }

    private List<ReleasedLinkSummary> fetchPublishedIncomingLinks(DSLContext jooq, UUID documentId) {
        return jooq.select(PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID,
                           PUBLISHED_LINK_SUMMARIES.TIME_RANGE,
                           PUBLISHED_LINK_SUMMARIES.BEGINNING,
                           PUBLISHED_LINK_SUMMARIES.ENDING,
                           PUBLISHED_DEFINITION_SUMMARIES.TITLE,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.PROTOTYPE_CONCEPT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID,
                           DSL.fieldByName(UUID.class, "linkables2", "linkable_id").as("origin_linkable_id")).
            from(LINKABLES).
            join(PUBLISHED_LINK_SUMMARIES).
                on(PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID.
                    eq(LINKABLES.LINKABLE_ID)).
            join(PUBLISHED_DEFINITION_SUMMARIES).
                on(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID.
                    eq(PUBLISHED_LINK_SUMMARIES.DOCUMENT_ID)).
            join(LINKABLES.as("linkables2")).
                on(DSL.fieldByName(UUID.class, "linkables2", "document_id").eq(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID)).
            where(LINKABLES.DOCUMENT_ID.eq(documentId)).
            fetchInto(ReleasedLinkSummary.class);
    }

    private UUID fetchConceptSetId(DSLContext jooq, UUID documentId) {
        return jooq.
            select(DOCUMENTS.CONCEPT_SET_ID).
            from(DOCUMENTS).
            where(DOCUMENTS.DOCUMENT_ID.eq(documentId)).
            fetchOne(DOCUMENTS.CONCEPT_SET_ID);
    }

    private ConceptNestableView fetchConceptSet(UUID conceptSetId) {
        return new ConceptSetReader(context, conceptSetId).fetchConceptNestable();
    }

}
