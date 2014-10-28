package us.fok.lenzenslijper.models.dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;

public class TransferDocumentRevision {

    // previously revised document
    private UUID parentRevisionId; // (only old documents)

    // new documents; ignored when parentRevisionId is present
    private String project;
    private String documentType; // e.g. perspective or collection
    // note: concept set not applied to document in revision

    private String title;

    private UUID entityLink;
    private String entityType;

    private List<TransferLink> links;
    private List<TransferAsset> assets;

    private String comments;

    private String user;

    @XmlElement(name = "parent_revision_id")
    public UUID getParentRevisionId() {
        return parentRevisionId;
    }

    public void setParentRevisionId(UUID parentRevisionId) {
        this.parentRevisionId = parentRevisionId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @XmlElement(name = "document_type")
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "entity_link")
    public UUID getEntityLink() {
        return entityLink;
    }

    public void setEntityLink(UUID entityLink) {
        this.entityLink = entityLink;
    }

    @XmlElement(name = "entity_type")
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public List<TransferLink> getLinks() {
        return links;
    }

    public void setLinks(List<TransferLink> links) {
        this.links = links;
    }

    public List<TransferAsset> getAssets() {
        return assets;
    }

    public void setAssets(List<TransferAsset> assets) {
        this.assets = assets;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

}
