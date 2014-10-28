package us.fok.lenzenslijper.persistence.transactions.content;

import org.jooq.DSLContext;
import org.jooq.Record2;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import us.fok.lenzenslijper.domain.Privilege;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.errors.ServiceInputError;
import us.fok.lenzenslijper.models.dto.*;
import us.fok.lenzenslijper.persistence.engines.JooqContext;
import us.fok.lenzenslijper.util.StringUtilities;
import us.fok.lenzenslijper.util.WebDigest;

import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;
import static us.fok.lenzenslijper.util.StringUtilities.stringIsPresent;

public class RevisionWriter implements TransactionCallback<RevisionReceipt> {

    private static Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    protected final JooqContext context;
    protected final TransferDocumentRevision spec;

    public RevisionWriter(JooqContext context, TransferDocumentRevision revision) {
        this.context = context;
        this.spec = revision;
    }

    @Override
    public RevisionReceipt doInTransaction(TransactionStatus transactionStatus) {
        return insertRevision(context.jooq(), spec);
    }

    protected RevisionReceipt insertRevision(DSLContext jooq, TransferDocumentRevision spec) {
        UUID parentRevisionId = spec.getParentRevisionId(); // implies project, document details

        Record2<UUID, UUID> projectDocument = fetchRevisionProjectDocument(jooq, parentRevisionId);
        UUID projectId = projectDocument.getValue(DOCUMENTS.PROJECT_ID);
        UUID documentId = projectDocument.getValue(REVISIONS.DOCUMENT_ID);

        UUID userId = fetchUserWithProjectWritePermissionsGuaranteed(jooq, spec.getUser(), projectId);
        ensureParentIsChildless(jooq, parentRevisionId);

        return createLinkedDocumentRevision(jooq, spec, parentRevisionId, documentId, projectId, userId);
    }

    private Record2<UUID, UUID> fetchRevisionProjectDocument(DSLContext jooq, UUID parentRevisionId) {
        return jooq.
            select(REVISIONS.DOCUMENT_ID, DOCUMENTS.PROJECT_ID).
            from(REVISIONS).
            join(DOCUMENTS).
            on(DOCUMENTS.DOCUMENT_ID.eq(REVISIONS.DOCUMENT_ID)).
            where(REVISIONS.REVISION_ID.eq(parentRevisionId)).
            fetchOne();
    }

    protected UUID fetchUserWithProjectWritePermissionsGuaranteed(DSLContext jooq, String user, UUID projectId) {
        if (! stringIsPresent(user)) {
            throw new ServiceInputError("No user specified");
        }
        UUID userId = jooq.
            selectDistinct(USERS.USER_ID).
            from(USERS).
            join(VIRTUAL_AGGREGATE_GRANTS).
            on(VIRTUAL_AGGREGATE_GRANTS.USER_ID.eq(USERS.USER_ID)).
            where(VIRTUAL_AGGREGATE_GRANTS.PROJECT_ID.eq(projectId)).
            and(VIRTUAL_AGGREGATE_GRANTS.MODE.bitAnd(Privilege.SUBMIT.getValue()).ne(0)).
            and(USERS.USERNAME.eq(user)).
            fetchOne(USERS.USER_ID);
        if (userId == null) {
            throw new ServiceInputError("User '" + user + "' may not write to the project");
        }
        return userId;
    }

    private void ensureParentIsChildless(DSLContext jooq, UUID parentRevisionId) {
        Integer parentExists = jooq.
            selectOne().
            from(REVISIONS).
            where(REVISIONS.PARENT_REVISION_ID.eq(parentRevisionId)).
            fetchOneInto(Integer.class);
        if (parentExists != null) {
            throw new ServiceInputError("Revision " + parentRevisionId + " already has a child");
        }
    }

    protected RevisionReceipt createLinkedDocumentRevision(DSLContext jooq, TransferDocumentRevision spec, UUID parentRevisionId, UUID documentId, UUID projectId, UUID userId) {
        UUID documentLink = fetchDocumentLink(jooq, documentId);

        LinkableConcept prototypeConcept = null;
        String prototypeSlug = spec.getEntityType();
        if (stringIsPresent(prototypeSlug)) {
            prototypeConcept = fetchLinkableConcept(jooq, prototypeSlug);
        }

        UUID entityLink = fetchOrInsertLinkableEntity(jooq, spec, prototypeConcept);

        UUID revisionId = insertRevisionRow(jooq, documentId, parentRevisionId, userId, spec.getComments());
        insertLinks(jooq, revisionId, spec.getTitle(), prototypeConcept, entityLink, spec.getLinks());
        insertAssets(jooq, revisionId, spec.getAssets());

        return new RevisionReceipt(projectId, userId, documentId, documentLink, revisionId);
    }

    private UUID fetchDocumentLink(DSLContext jooq, UUID documentId) {
        return jooq.
            select(LINKABLES.LINKABLE_ID).
            from(LINKABLES).
            where(LINKABLES.DOCUMENT_ID.eq(documentId)).
            fetchOne(LINKABLES.LINKABLE_ID);
    }

    protected LinkableConcept fetchLinkableConcept(DSLContext jooq, String slug) {
        return jooq.
            select(LINKABLES.LINKABLE_ID, CONCEPTS.NAME).
            from(CONCEPTS).
            join(LINKABLES).
                on(LINKABLES.CONCEPT_ID.eq(CONCEPTS.CONCEPT_ID)).
            where(CONCEPTS.SLUG.eq(slug)).
            fetchOneInto(LinkableConcept.class);
    }

    protected UUID fetchOrInsertLinkableEntity(DSLContext jooq, TransferDocumentRevision spec, LinkableConcept prototypeConcept) {
        UUID entityLink = spec.getEntityLink();
        if ((entityLink == null) && (prototypeConcept != null)) {
            UUID entityId = insertEntity(jooq);
            entityLink = fetchEntityLinkGuaranteed(jooq, entityId);
        }
        return entityLink;
    }

    private UUID insertEntity(DSLContext jooq) {
        return jooq.
            insertInto(ENTITIES).
            defaultValues().
            returning(ENTITIES.ENTITY_ID).
            fetchOne().
            getValue(ENTITIES.ENTITY_ID);
    }

    private UUID fetchEntityLinkGuaranteed(DSLContext jooq, UUID entityId) {
        UUID entityLink = fetchEntityLink(jooq, entityId);
        if (entityLink == null) {
            throw new ServiceInputError("Entity id '" + entityId + "' is not valid");
        }
        return entityLink;
    }

    private UUID fetchEntityLink(DSLContext jooq, UUID entityId) {
        return jooq.
            select(LINKABLES.LINKABLE_ID).
            from(LINKABLES).
            where(LINKABLES.ENTITY_ID.eq(entityId)).
            fetchOne(LINKABLES.LINKABLE_ID);
    }

    protected UUID insertRevisionRow(DSLContext jooq, UUID documentId, UUID parentRevisionId, UUID userId, String comments) {
        return jooq.
            insertInto(REVISIONS,
                       REVISIONS.DOCUMENT_ID,
                       REVISIONS.PARENT_REVISION_ID,
                       REVISIONS.USER_ID,
                       REVISIONS.COMMENTS).
            values(documentId, parentRevisionId, userId, comments).
            returning(REVISIONS.REVISION_ID).
            fetchOne().
            getValue(REVISIONS.REVISION_ID);
    }

    protected void insertLinks(DSLContext jooq, UUID revisionId, String title, LinkableConcept prototypeConcept, UUID entityLink, List<TransferLink> linkSpecs) {
        insertSpecialLinks(jooq, revisionId, title, entityLink, prototypeConcept);
        for(TransferLink linkSpec : linkSpecs) {
            if (! isLinkSpecial(linkSpec)) {
                insertStandardLink(jooq, revisionId, linkSpec);
            }
        }
    }

    private void insertSpecialLinks(DSLContext jooq, UUID revisionId, String title, UUID entityLink, LinkableConcept prototypeConcept) {
        if (! stringIsPresent(title)) {
            throw new ServiceInputError("No title specified");
        }
        insertDefinesLink(jooq, revisionId, title, entityLink);

        if (prototypeConcept != null) {
            insertHasPrototypeLink(jooq, revisionId, prototypeConcept);
        }
    }

    private void insertDefinesLink(DSLContext jooq, UUID revisionId, String title, UUID entityLink) {
        TransferLink definesLink = buildDefinesLink(title, entityLink);
        insertLinkRow(jooq, revisionId, SystemSchemaConstants.LINK_TYPE_ID_DEFINES, definesLink);
    }

    private TransferLink buildDefinesLink(String title, UUID entityLink) {
        TransferLink link = new TransferLink();
        link.setTitle(title);
        link.setTargetLinkableId(entityLink); // optional
        return link;
    }

    private void insertStandardLink(DSLContext jooq, UUID revisionId, TransferLink linkSpec) {
        int linkTypeId = fetchLinkTypeGuaranteed(linkSpec.getType());
        insertLinkRow(jooq, revisionId, linkTypeId, linkSpec);
    }

    private int fetchLinkTypeGuaranteed(String type) {
        if (! stringIsPresent(type)) {
            throw new ServiceInputError("No link type specified");
        }
        Integer linkTypeId = context.getSchemaDictionary().getLinkTypeId(type);
        if (linkTypeId == null) {
            throw new ServiceInputError("Invalid link type: '" + type + "'");
        }
        return linkTypeId;  //To change body of created methods use File | Settings | File Templates.
    }

    protected void insertLinkRow(DSLContext jooq, UUID revisionId, int linkTypeId, TransferLink linkSpec) {
        jooq.
            insertInto(REVISION_LINKS,
                       REVISION_LINKS.REVISION_ID,
                       REVISION_LINKS.LINK_TYPE_ID,
                       REVISION_LINKS.TARGET_TITLE,
                       REVISION_LINKS.TARGET_LINKABLE_ID,
                       REVISION_LINKS.RANK,
                       REVISION_LINKS.TIME_RANGE,
                       REVISION_LINKS.BEGINNING,
                       REVISION_LINKS.ENDING).
            values(revisionId,
                   linkTypeId,
                   linkSpec.getTitle(),
                   linkSpec.getTargetLinkableId(),
                   linkSpec.getRank(),
                   linkSpec.getTimeRange(),
                   linkSpec.getBeginning(),
                   linkSpec.getEnding()).
            execute();
    }

    private boolean isLinkSpecial(TransferLink linkSpec) {
        String linkType = linkSpec.getType();
        return (linkType.equals(SystemSchemaConstants.LINK_TYPE_HAS_PROTOTYPE)) ||
            (linkType.equals(SystemSchemaConstants.LINK_TYPE_DEFINES));
    }

    private void insertHasPrototypeLink(DSLContext jooq, UUID revisionId, LinkableConcept prototypeConcept) {
        TransferLink definesLink = buildHasPrototypeLink(prototypeConcept);
        insertLinkRow(jooq, revisionId, SystemSchemaConstants.LINK_TYPE_ID_HAS_PROTOTYPE, definesLink);
    }

    private TransferLink buildHasPrototypeLink(LinkableConcept prototypeConcept) {
        TransferLink link = new TransferLink();
        link.setTitle(prototypeConcept.getName());
        link.setTargetLinkableId(prototypeConcept.getLinkableId());
        return link;
    }

    protected void insertAssets(DSLContext jooq, UUID revisionId, List<TransferAsset> assetSpecs) {
        for(TransferAsset assetSpec : assetSpecs) {
            insertRevisionAsset(jooq, revisionId, assetSpec);
        }
    }

    private void insertRevisionAsset(DSLContext jooq, UUID revisionId, TransferAsset assetSpec) {
        int assetRoleId = lookupAssetRoleIdGuaranteed(assetSpec.getRole());
        UUID assetId = findOrCreateAsset(jooq, assetSpec);
        insertRevisionAssetRole(jooq, revisionId, assetRoleId, assetSpec.getTitle(), assetId);
    }

    private UUID findOrCreateAsset(DSLContext jooq, TransferAsset assetSpec) {
        int assetTypeId = lookupAssetTypeIdGuaranteed(assetSpec.getType());
        byte[] content = readAssetBytes(assetSpec.getContent(), assetSpec.getType());
        if (content.length == 0) {
            throw new ServiceInputError("Asset content is null");
        }
        String digest = WebDigest.digest64(content);
        UUID assetId = findAsset(jooq, assetTypeId, digest);
        return (assetId == null) ? insertAssetRow(jooq, assetTypeId, digest, content) : assetId;
    }

    private Integer lookupAssetTypeIdGuaranteed(String assetType) {
        if (! stringIsPresent(assetType)) {
            throw new ServiceInputError("Asset type not specified");
        }
        Integer assetTypeId = context.getSchemaDictionary().getAssetTypeId(assetType);
        if (assetTypeId == null) {
            throw new ServiceInputError("Asset type unknown: '" + assetType + "'");
        }
        return assetTypeId;
    }

    /*
        UTF-8 for most types, binary/base64 for images, etc.
     */
    private byte[] readAssetBytes(String content, String assetType) {
        byte[] bytes;
        if (assetType.startsWith("image")) {
            bytes = StringUtilities.readBase64Bytes(content);
        }
        else {
            bytes = content.getBytes(CHARSET_UTF8);
        }
        return bytes;
    }

    private UUID findAsset(DSLContext jooq, int assetTypeId, String digest) {
        return jooq.
            select(ASSETS.ASSET_ID).
            from(ASSETS).
            where(ASSETS.ASSET_TYPE_ID.eq(assetTypeId)).
            and(ASSETS.DIGEST.eq(digest)).
            fetchOne(ASSETS.ASSET_ID);
    }

    private UUID insertAssetRow(DSLContext jooq, int assetTypeId, String digest, byte[] content) {
        return jooq.
            insertInto(ASSETS,
                       ASSETS.ASSET_TYPE_ID,
                       ASSETS.DIGEST,
                       ASSETS.CONTENT).
            values(assetTypeId,
                digest,
                content).
            returning(ASSETS.ASSET_ID).
            fetchOne().
            getValue(ASSETS.ASSET_ID);
    }

    private Integer lookupAssetRoleIdGuaranteed(String assetRole) {
        if (!stringIsPresent(assetRole)) {
            throw new ServiceInputError("Asset role not specified");
        }
        Integer assetRoleId = context.getSchemaDictionary().getAssetRoleId(assetRole);
        if (assetRoleId == null) {
            throw new ServiceInputError("Asset role unknown: '" + assetRole + "'");
        }
        return assetRoleId;
    }

    private void insertRevisionAssetRole(DSLContext jooq, UUID revisionId, int assetRoleId, String title, UUID assetId) {
        jooq.
            insertInto(REVISION_ASSET_ROLES,
                       REVISION_ASSET_ROLES.REVISION_ID,
                       REVISION_ASSET_ROLES.ASSET_ROLE_ID,
                       REVISION_ASSET_ROLES.TITLE,
                       REVISION_ASSET_ROLES.ASSET_ID).
            values(revisionId,
                   assetRoleId,
                   title,
                   assetId).
            execute();
    }

}
