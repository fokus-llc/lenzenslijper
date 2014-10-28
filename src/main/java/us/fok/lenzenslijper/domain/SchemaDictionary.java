package us.fok.lenzenslijper.domain;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.jooq.DSLContext;
import us.fok.lenzenslijper.models.jooq.tables.LinkTypes;

import java.util.Map;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

public class SchemaDictionary {

    private final UUID coreProjectId;

    private final BiMap<Integer, String> documentTypes;
    private final BiMap<Integer, String> assessmentTypes;
    private final BiMap<Integer, String> assetRoles;
    private final BiMap<Integer, String> assetTypes;
    private final BiMap<Integer, String> linkTypes;
    private final BiMap<Integer, String> converseLinkTypes;
    private final BiMap<Integer, String> linkTargetTypes;
    private final BiMap<Integer, String> projectRoles;
    private final BiMap<Integer,String> releaseTags;
    private final BiMap<UUID, String> coreConcepts;
    private final BiMap<UUID, UUID> linkableConcepts;

    public SchemaDictionary(DSLContext jooq) {
        this.coreProjectId = readCoreProjectId(jooq);

        this.documentTypes = readDocumentTypes(jooq);
        this.assessmentTypes = readAssessmentTypes(jooq);
        this.assetRoles = readAssetRoles(jooq);
        this.assetTypes = readAssetTypes(jooq);
        this.linkTypes = readLinkTypes(jooq);
        this.converseLinkTypes = readConverseLinkTypes(jooq);
        this.linkTargetTypes = readLinkTargetTypes(jooq);
        this.projectRoles = readProjectRoles(jooq);
        this.releaseTags = readReleaseTags(jooq);

        this.coreConcepts = readCoreConcepts(jooq);

        this.linkableConcepts = readLinkableConcepts(jooq);

    }

    private UUID readCoreProjectId(DSLContext jooq) {
        return jooq.
            select(PROJECTS.PROJECT_ID).
            from(PROJECTS).
            where(PROJECTS.SLUG.eq(SystemSchemaConstants.ONTOLOGY_PROJECT_SLUG)).
            fetchOne(PROJECTS.PROJECT_ID);
    }

    public UUID getCoreProjectId() {
        return coreProjectId;
    }

    private BiMap<Integer, String> readDocumentTypes(DSLContext jooq) {
        Map<Integer, String> documentTypes =
            jooq.select(DOCUMENT_TYPES.DOCUMENT_TYPE_ID, DOCUMENT_TYPES.SLUG).
                from(DOCUMENT_TYPES).
                fetchMap(DOCUMENT_TYPES.DOCUMENT_TYPE_ID, DOCUMENT_TYPES.SLUG);
        return ImmutableBiMap.copyOf(documentTypes);
    }

    private BiMap<Integer, String> readAssessmentTypes(DSLContext jooq) {
        Map<Integer, String> assessmentTypes =
            jooq.select(ASSESSMENT_TYPES.ASSESSMENT_TYPE_ID, ASSESSMENT_TYPES.SLUG).
                from(ASSESSMENT_TYPES).
                fetchMap(ASSESSMENT_TYPES.ASSESSMENT_TYPE_ID, ASSESSMENT_TYPES.SLUG);
        return ImmutableBiMap.copyOf(assessmentTypes);
    }

    private BiMap<Integer, String> readAssetRoles(DSLContext jooq) {
        Map<Integer, String> assetRoles =
            jooq.select(ASSET_ROLES.ASSET_ROLE_ID, ASSET_ROLES.SLUG).
                from(ASSET_ROLES).
                fetchMap(ASSET_ROLES.ASSET_ROLE_ID, ASSET_ROLES.SLUG);
        return ImmutableBiMap.copyOf(assetRoles);
    }

    private BiMap<Integer, String> readAssetTypes(DSLContext jooq) {
        Map<Integer, String> assetTypes =
            jooq.select(ASSET_TYPES.ASSET_TYPE_ID, ASSET_TYPES.VALUE).
                from(ASSET_TYPES).
                fetchMap(ASSET_TYPES.ASSET_TYPE_ID, ASSET_TYPES.VALUE);
        return ImmutableBiMap.copyOf(assetTypes);
    }

    private BiMap<Integer,String> readLinkTypes(DSLContext jooq) {
        Map<Integer, String> linkTypes =
            jooq.select(LINK_TYPES.LINK_TYPE_ID, LINK_TYPES.SLUG).
                from(LINK_TYPES).
                fetchMap(LINK_TYPES.LINK_TYPE_ID, LINK_TYPES.SLUG);
        return ImmutableBiMap.copyOf(linkTypes);
    }

    private BiMap<Integer,String> readConverseLinkTypes(DSLContext jooq) {
        LinkTypes inverse = LINK_TYPES.as("inverse");
        Map<Integer, String> converseLinkTypes =
            jooq.select(LINK_TYPES.LINK_TYPE_ID, LINK_TYPES.SLUG).
                from(LINK_TYPES).
                join(inverse).
                    on(inverse.LINK_TYPE_ID.eq(LINK_TYPES.CONVERSE_LINK_TYPE_ID)).
                fetchMap(inverse.LINK_TYPE_ID, LINK_TYPES.SLUG);
        return ImmutableBiMap.copyOf(converseLinkTypes);
    }

    private BiMap<Integer, String> readLinkTargetTypes(DSLContext jooq) {
        Map<Integer, String> linkTargetTypes =
            jooq.select(LINK_TARGET_TYPES.LINK_TARGET_TYPE_ID, LINK_TARGET_TYPES.SLUG).
                from(LINK_TARGET_TYPES).
                fetchMap(LINK_TARGET_TYPES.LINK_TARGET_TYPE_ID, LINK_TARGET_TYPES.SLUG);
        return ImmutableBiMap.copyOf(linkTargetTypes);
    }

    private BiMap<Integer, String> readProjectRoles(DSLContext jooq) {
        Map<Integer, String> projectRoles =
            jooq.select(PROJECT_ROLES.PROJECT_ROLE_ID, PROJECT_ROLES.SLUG).
                from(PROJECT_ROLES).
                fetchMap(PROJECT_ROLES.PROJECT_ROLE_ID, PROJECT_ROLES.SLUG);
        return ImmutableBiMap.copyOf(projectRoles);
    }

    private BiMap<Integer, String> readReleaseTags(DSLContext jooq) {
        Map<Integer, String> tags =
            jooq.select(RELEASE_TAGS.RELEASE_TAG_ID, RELEASE_TAGS.SLUG).
                from(RELEASE_TAGS).
                fetchMap(RELEASE_TAGS.RELEASE_TAG_ID, RELEASE_TAGS.SLUG);
        return ImmutableBiMap.copyOf(tags);
    }

    private BiMap<UUID, String> readCoreConcepts(DSLContext jooq) {
        Map<UUID, String> concepts =
            jooq.select(CONCEPTS.CONCEPT_ID, CONCEPTS.SLUG).
                from(CONCEPTS).
                where(CONCEPTS.PROJECT_ID.eq(coreProjectId)).
                fetchMap(CONCEPTS.CONCEPT_ID, CONCEPTS.SLUG);
        return ImmutableBiMap.copyOf(concepts);
    }

    private BiMap<UUID,UUID> readLinkableConcepts(DSLContext jooq) {
        Map<UUID, UUID> linkableConcepts =
            jooq.select(LINKABLES.LINKABLE_ID, CONCEPTS.CONCEPT_ID).
                from(CONCEPTS).
                join(LINKABLES).
                    on(LINKABLES.CONCEPT_ID.eq(CONCEPTS.CONCEPT_ID)).
                fetchMap(LINKABLES.LINKABLE_ID, CONCEPTS.CONCEPT_ID);
        return ImmutableBiMap.copyOf(linkableConcepts);
    }

    public String getDocumentType(Integer documentTypeId) {
        return documentTypes.get(documentTypeId);
    }

    public Integer getDocumentTypeId(String slug) {
        return documentTypes.inverse().get(slug);
    }

    public String getAssessmentType(Integer assessmentTypeId) {
        return assessmentTypes.get(assessmentTypeId);
    }

    public Integer getAssessmentTypeId(String slug) {
        return assessmentTypes.inverse().get(slug);
    }

    public String getAssetRole(Integer assetRoleId) {
        return assetRoles.get(assetRoleId);
    }

    public Integer getAssetRoleId(String slug) {
        return assetRoles.inverse().get(slug);
    }

    public String getAssetType(Integer assetTypeId) {
        return assetTypes.get(assetTypeId);
    }

    public Integer getAssetTypeId(String slug) {
        return assetTypes.inverse().get(slug);
    }

    public String getLinkType(Integer linkTypeId) {
        return linkTypes.get(linkTypeId);
    }

    public Integer getLinkTypeId(String slug) {
        return linkTypes.inverse().get(slug);
    }

    public String getConverseLinkType(Integer linkTypeId) {
        return converseLinkTypes.get(linkTypeId);
    }

    public Integer geConversetLinkTypeId(String slug) {
        return converseLinkTypes.inverse().get(slug);
    }

    public String getLinkTargetType(Integer linkTypeId) {
        return linkTargetTypes.get(linkTypeId);
    }

    public Integer getLinkTargetTypeId(String slug) {
        return linkTargetTypes.inverse().get(slug);
    }

    public String getProjectRole(Integer projectRoleId) {
        return projectRoles.get(projectRoleId);
    }

    public Integer getProjectRoleId(String slug) {
        return projectRoles.inverse().get(slug);
    }


    public String getReleaseTag(Integer releaseTagId) {
        return releaseTags.get(releaseTagId);
    }

    public Integer getReleaseTagId(String slug) {
        return releaseTags.inverse().get(slug);
    }

    public String getCoreConcept(UUID conceptId) {
        return coreConcepts.get(conceptId);
    }

    public UUID getCoreConceptId(String slug) {
        return coreConcepts.inverse().get(slug);
    }

    public UUID getLinkableCoreConcept(UUID linkableId) {
        return linkableConcepts.get(linkableId);
    }

}
