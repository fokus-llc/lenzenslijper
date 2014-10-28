package us.fok.lenzenslijper.persistence.transactions.published;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.persistence.transactions.data.MemberDocumentsPageData;
import us.fok.lenzenslijper.selectors.MembersSelector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.jooq.impl.DSL.count;
import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class MemberDocumentsPageReader implements TransactionCallback<MemberDocumentsPageData> {

    private final JooqContext context; // is it ok to pass a DSLContext constructed before tx started?
    private final UUID documentLinkableId;
    private final UUID revisionId;
    private final MembersSelector selector;

    public MemberDocumentsPageReader(JooqContext context, UUID documentLinkableId, UUID revisionId, MembersSelector selector) {
        this.context = context;
        this.documentLinkableId = documentLinkableId;
        this.revisionId = revisionId;
        this.selector = selector;
    }

    @Override
    public MemberDocumentsPageData doInTransaction(TransactionStatus status) {
        return fetchMembersPageData(context.jooq(), documentLinkableId, revisionId, selector);
    }

    private MemberDocumentsPageData fetchMembersPageData(DSLContext jooq, UUID linkableDocumentId, UUID queryRevisionId, MembersSelector selector) {
        MemberDocumentsPageData datum = null;
        UUID confirmedRevisionId = fetchPublishedCollectionRevisionId(jooq, linkableDocumentId, queryRevisionId);
        if (confirmedRevisionId != null) {
            datum = fetchMembersPageData(jooq, confirmedRevisionId, selector);
        }
        return datum;
    }

    private UUID fetchPublishedCollectionRevisionId(DSLContext jooq, UUID documentLinkableId, UUID revisionId) {
        SelectConditionStep<Record1<UUID>> conditionalRelation = jooq.
            select(RELEASED_REVISION_SUMMARIES.REVISION_ID).
            from(LINKABLES).
            join(RELEASED_REVISION_SUMMARIES).
                on(RELEASED_REVISION_SUMMARIES.DOCUMENT_ID.eq(LINKABLES.DOCUMENT_ID)).
            join(DOCUMENTS).
                on(DOCUMENTS.DOCUMENT_ID.eq(RELEASED_REVISION_SUMMARIES.DOCUMENT_ID)).
            where(LINKABLES.LINKABLE_ID.eq(documentLinkableId)).
                and(RELEASED_REVISION_SUMMARIES.RELEASE_TAG_ID.eq(SystemSchemaConstants.RELEASE_TAG_ID_PUBLISHED)).
                and(DOCUMENTS.DOCUMENT_TYPE_ID.eq(SystemSchemaConstants.DOCUMENT_TYPE_ID_COLLECTION));

        SelectFinalStep<Record1<UUID>> fetchRelation = null;
        if (revisionId != null) {
            fetchRelation = conditionalRelation.and(RELEASED_REVISION_SUMMARIES.REVISION_ID.eq(revisionId));
        }
        else {
            fetchRelation = conditionalRelation.orderBy(RELEASED_REVISION_SUMMARIES.CREATED.desc()).limit(1);
        }
        return fetchRelation.fetchOne(RELEASED_REVISION_SUMMARIES.REVISION_ID);
    }

    private MemberDocumentsPageData fetchMembersPageData(DSLContext jooq, UUID revisionId, MembersSelector selector) {
        MemberDocumentsPageData datum = new MemberDocumentsPageData();

        List<ProjectUserDocumentSummary> memberPespectives = fetchMemberDocuments(jooq, revisionId, selector);
        if (! memberPespectives.isEmpty()) {
            datum.setPublicationSummaries(memberPespectives);

            List<UUID> memberRevisionIds = pluckRevisionIds(memberPespectives);
            datum.setOutgoingLinks(fetchOutgoingLinks(jooq, memberRevisionIds));
            datum.setEnrolledAssets(fetchAssets(jooq, memberRevisionIds));

            datum.setCount(fetchCount(jooq, revisionId));
        }
        else {
            datum.setCount(0);
        }

        return datum;
    }

    private List<ProjectUserDocumentSummary> fetchMemberDocuments(DSLContext jooq, UUID revisionId, MembersSelector selector) {
        SelectOnConditionStep<? extends Record> projection = ProjectUserDocumentSummary.publishedRelation(jooq);
        return buildPaginatedMemberRelation(projection, revisionId, selector).fetchInto(ProjectUserDocumentSummary.class);
    }

    private <T extends Record> SelectFinalStep<T> buildPaginatedMemberRelation(SelectOnConditionStep<T> projection, UUID revisionId, MembersSelector selector) {
        SelectLimitStep<T> relation = null;
        String conceptSlug = selector.getConceptSlug();
        if (conceptSlug == null) {
            relation = buildMemberRelation(projection, revisionId);
        }
        else {
            UUID conceptLinkableId = linkableConceptIdForSlug(conceptSlug);
            relation = buildMemberRelation(projection, revisionId, conceptLinkableId);
        }
        return selector.isSelectAll() ?
            relation : relation.limit(selector.getLimit()).offset(selector.getOffset());
    }

    private UUID linkableConceptIdForSlug(String conceptSlug) {
        return context.jooq().
            select(LINKABLES.LINKABLE_ID).
            from(LINKABLES).
            join(CONCEPTS).
                on(CONCEPTS.CONCEPT_ID.eq(LINKABLES.CONCEPT_ID)).
            where(CONCEPTS.SLUG.eq(conceptSlug)).
            limit(1).
            fetchOne(LINKABLES.LINKABLE_ID);
    }

    private <T extends Record> SelectLimitStep<T> buildMemberRelation(SelectOnConditionStep<T> projection, UUID revisionId, UUID conceptLinkableId) {
        return projection.

            join(REVISION_LINKS).
                on(REVISION_LINKS.TARGET_LINKABLE_ID.eq(LINKABLES.LINKABLE_ID)).

            where(REVISION_LINKS.REVISION_ID.eq(revisionId)).
                and(REVISION_LINKS.LINK_TYPE_ID.eq(SystemSchemaConstants.LINK_TYPE_ID_COMPRISES)).

            // OPTIMIZE: this looks awfully expensive
            andExists(context.jooq().
                selectOne().
                from(REVISION_LINKS.as("links2")).
                where(DSL.fieldByName(UUID.class, "links2", "revision_id").eq(PUBLISHED_DEFINITION_SUMMARIES.REVISION_ID)).
                and(DSL.fieldByName(Integer.class, "links2", "link_type_id").eq(SystemSchemaConstants.LINK_TYPE_ID_CONCEPT)).
                and(DSL.fieldByName(UUID.class, "links2", "target_linkable_id").eq(conceptLinkableId))).

            orderBy(REVISION_LINKS.RANK);
    }

    private <T extends Record> SelectLimitStep<T> buildMemberRelation(SelectOnConditionStep<T> projection, UUID revisionId) {
        return projection.
            join(REVISION_LINKS).
                on(REVISION_LINKS.TARGET_LINKABLE_ID.eq(LINKABLES.LINKABLE_ID)).
            where(REVISION_LINKS.REVISION_ID.eq(revisionId)).
                and(REVISION_LINKS.LINK_TYPE_ID.eq(SystemSchemaConstants.LINK_TYPE_ID_COMPRISES)).
            orderBy(REVISION_LINKS.RANK);
    }

    private List<UUID> pluckRevisionIds(List<ProjectUserDocumentSummary> summaries) {
        List<UUID> editionIds = new ArrayList<UUID>(summaries.size());
        for (ProjectUserDocumentSummary summary : summaries) {
            editionIds.add(summary.getRevisionId());
        }
        return editionIds;
    }

    private Map<UUID, List<ReleasedLinkSummary>> fetchOutgoingLinks(DSLContext jooq, List<UUID> revisionIds) {
        return jooq.select(PUBLISHED_LINK_SUMMARIES.REVISION_ID,
                           PUBLISHED_LINK_SUMMARIES.LINK_TYPE_ID,
                           PUBLISHED_LINK_SUMMARIES.TARGET_TITLE,
                           PUBLISHED_LINK_SUMMARIES.TARGET_VALUE,
                           PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID,
                           PUBLISHED_LINK_SUMMARIES.TIME_RANGE,
                           PUBLISHED_LINK_SUMMARIES.BEGINNING,
                           PUBLISHED_LINK_SUMMARIES.ENDING,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.PROTOTYPE_CONCEPT_ID,
                           PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID).
            from(PUBLISHED_LINK_SUMMARIES).
            leftOuterJoin(LINKABLES).
                on(LINKABLES.LINKABLE_ID.equal(PUBLISHED_LINK_SUMMARIES.TARGET_LINKABLE_ID)).
            leftOuterJoin(PUBLISHED_DEFINITION_SUMMARIES).
                on(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID.
                    eq(LINKABLES.LINKABLE_ID)).
            where(PUBLISHED_LINK_SUMMARIES.REVISION_ID.in(revisionIds)).
            fetchGroups(PUBLISHED_LINK_SUMMARIES.REVISION_ID, ReleasedLinkSummary.class);
    }

    private Map<UUID, List<EnrolledAsset>> fetchAssets(DSLContext jooq, List<UUID> memberEditionIds) {
        return EnrolledAsset.relation(jooq).
            where(REVISION_ASSET_ROLES.REVISION_ID.in(memberEditionIds)).
            fetchGroups(REVISION_ASSET_ROLES.REVISION_ID, EnrolledAsset.class);
    }

    private int fetchCount(DSLContext jooq, UUID revisionId) {
        return jooq.selectCount().
            from(REVISION_LINKS).
            where(REVISION_LINKS.REVISION_ID.eq(revisionId)).
                and(REVISION_LINKS.LINK_TYPE_ID.eq(SystemSchemaConstants.LINK_TYPE_ID_COMPRISES)).
            fetchOne(count());
    }

}
