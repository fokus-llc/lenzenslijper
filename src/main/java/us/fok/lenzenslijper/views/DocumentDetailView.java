package us.fok.lenzenslijper.views;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.providers.ISO8601DateFormatSerializer;
import us.fok.lenzenslijper.providers.RawJsonValuedMapSerializer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DocumentDetailView {

    private ProjectUserDocumentSummary summary;

    private String documentType;
    private String entityType;

    private ConceptNestableView conceptSet;

    private AssetDetailView mainAsset;
    private Map<String, String> notes;

    private Map<String, Map<String, ReleasedLinkView>> outgoingLinks;
    private Map<String, List<ReleasedLinkView>> incomingLinks;

    private Map<String, Map<String, AssetDetailView>> assetsByRoleAndTitle;

    private List<DocumentDetailView> members;
    private UUID entityLink;

    public DocumentDetailView(ProjectUserDocumentSummary summary) {
        this.summary = summary;
    }

    @XmlElement(name = "link")
    public UUID getLinkableId() {
        return summary.getLinkableId();
    }

    @XmlElement(name = "document_id")
    public UUID getDocumentId() {
        return summary.getDocumentId();
    }

    @XmlTransient
    public int getDocumentTypeId() {
        return summary.getDocumentTypeId();
    }

    @XmlElement(name = "document_type")
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getTitle() {
        return summary.getTitle();
    }

    @XmlElement(name = "entity_id")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public UUID getEntityId() {
        return summary.getEntityId();
    }

    @XmlElement(name = "entity_link")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public UUID getEntityLink() {
        return entityLink;
    }

    public void setEntityLink(UUID entityLink) {
        this.entityLink = entityLink;
    }

    @XmlTransient
    public UUID getPrototypeConceptId() {
        return summary.getPrototypeConceptId();
    }

    @XmlElement(name = "entity_type")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @XmlElement(name = "concept_set")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public ConceptNestableView getConceptSet() {
        return conceptSet;
    }

    public void setConceptSet(ConceptNestableView conceptSet) {
        this.conceptSet = conceptSet;
    }

    public String getProject() {
        return summary.getProject();
    }

    @XmlElement(name = "user")
    public String getUsername() {
        return summary.getUsername();
    }

    @XmlElement(name = "revision_id")
    public UUID getRevisionId() {
        return summary.getRevisionId();
    }

    @JsonSerialize(using = ISO8601DateFormatSerializer.class)
    public Timestamp getAssessed() {
        return summary.getAssessed();
    }

    @XmlElement(name = "body")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public AssetDetailView getMainAsset() {
        return mainAsset;
    }

    public void setMainAsset(AssetDetailView mainAsset) {
        this.mainAsset = mainAsset;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = RawJsonValuedMapSerializer.class)
    public Map<String, String> getNotes() {
        return notes;
    }

    public void setNotes(Map<String, String> notes) {
        this.notes = notes;
    }

    @XmlElement(name = "links")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Map<String, Map<String, ReleasedLinkView>> getLinks() {
        return outgoingLinks;
    }

    public void setLinks(Map<String, Map<String, ReleasedLinkView>> outgoingLinks) {
        this.outgoingLinks = outgoingLinks;
    }

    @XmlElement(name = "incoming_links")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Map<String, List<ReleasedLinkView>> getIncomingLinks() {
        return incomingLinks;
    }

    public void setIncomingLinks(Map<String, List<ReleasedLinkView>> incomingLinks) {
        this.incomingLinks = incomingLinks;
    }

    @XmlElement(name = "assets")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Map<String, Map<String, AssetDetailView>> getAssetsByRoleAndTitle() {
        return assetsByRoleAndTitle;
    }

    public void setAssetsByRoleAndTitle(Map<String, Map<String, AssetDetailView>> assetsByRoleAndTitle) {
        this.assetsByRoleAndTitle = assetsByRoleAndTitle;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public List<DocumentDetailView> getMembers() {
        return members;
    }

    public void setMembers(List<DocumentDetailView> members) {
        this.members = members;
    }

}
