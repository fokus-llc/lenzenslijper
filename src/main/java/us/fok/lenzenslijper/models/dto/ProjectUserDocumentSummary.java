package us.fok.lenzenslijper.models.dto;

import org.jooq.*;

import java.sql.Timestamp;
import java.util.UUID;

import static us.fok.lenzenslijper.models.jooq.Tables.*;

/**
 * PUBLISHED_DEFINITION_SUMMARIES joined with users.username and projects.slug
 */
public class ProjectUserDocumentSummary {

    public static SelectSelectStep<Record10<UUID, UUID, Integer, UUID, String, UUID, UUID, Timestamp, String, String>> projection(DSLContext jooq) {
        return jooq.
            select(LINKABLES.LINKABLE_ID,
                   PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID,
                   PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_TYPE_ID,
                   PUBLISHED_DEFINITION_SUMMARIES.PROTOTYPE_CONCEPT_ID,
                   PUBLISHED_DEFINITION_SUMMARIES.TITLE,
                   PUBLISHED_DEFINITION_SUMMARIES.ENTITY_ID,
                   PUBLISHED_DEFINITION_SUMMARIES.REVISION_ID,
                   PUBLISHED_DEFINITION_SUMMARIES.ASSESSED,
                   PROJECTS.SLUG.as("project"),
                   USERS.USERNAME);
    }

    public static SelectOnConditionStep<Record10<UUID, UUID, Integer, UUID, String, UUID, UUID, Timestamp, String, String>> publishedRelation(DSLContext jooq) {
        return projection(jooq).
            from(LINKABLES).
            join(PUBLISHED_DEFINITION_SUMMARIES).
                on(PUBLISHED_DEFINITION_SUMMARIES.DOCUMENT_ID.eq(LINKABLES.DOCUMENT_ID)).
            join(PROJECTS).
                on(PROJECTS.PROJECT_ID.eq(PUBLISHED_DEFINITION_SUMMARIES.PROJECT_ID)).
            leftOuterJoin(USERS).
                on(USERS.USER_ID.eq(PUBLISHED_DEFINITION_SUMMARIES.USER_ID));
    }

    private UUID documentId;
    private UUID linkableId;
    private int documentTypeId; // domain
    private String title;
    private UUID entityId;
    private UUID prototypeConceptId; // domain
    private UUID revisionId;
    private Timestamp assessed;

    private String project; // joined
    private String username;

    public UUID getLinkableId() {
        return linkableId;
    }

    public void setLinkableId(UUID linkableId) {
        this.linkableId = linkableId;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public UUID getPrototypeConceptId() {
        return prototypeConceptId;
    }

    public void setPrototypeConceptId(UUID prototypeConceptId) {
        this.prototypeConceptId = prototypeConceptId;
    }

    public UUID getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(UUID revisionId) {
        this.revisionId = revisionId;
    }

    public Timestamp getAssessed() {
        return assessed;
    }

    public void setAssessed(Timestamp assessed) {
        this.assessed = assessed;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
