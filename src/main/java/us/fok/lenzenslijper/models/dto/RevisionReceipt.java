package us.fok.lenzenslijper.models.dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

public class RevisionReceipt {

    final UUID projectId;
    final UUID userId;
    final UUID documentId;
    final UUID documentLink;
    final UUID revisionId;

    public RevisionReceipt(UUID projectId, UUID userId, UUID documentId, UUID documentLink, UUID revisionId) {
        this.projectId = projectId;
        this.userId = userId;
        this.documentId = documentId;
        this.documentLink = documentLink;
        this.revisionId = revisionId;
    }

    @XmlElement(name = "project_id")
    public UUID getProjectId() {
        return projectId;
    }

    @XmlElement(name = "user_id")
    public UUID getUserId() {
        return userId;
    }

    @XmlElement(name = "document_id")
    public UUID getDocumentId() {
        return documentId;
    }

    @XmlElement(name = "document_link")
    public UUID getDocumentLink() {
        return documentLink;
    }

    @XmlElement(name = "revision_id")
    public UUID getRevisionId() {
        return revisionId;
    }

}
