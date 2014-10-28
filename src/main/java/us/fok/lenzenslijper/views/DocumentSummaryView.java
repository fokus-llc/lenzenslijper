package us.fok.lenzenslijper.views;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.providers.ISO8601DateFormatSerializer;

import javax.xml.bind.annotation.XmlElement;
import java.sql.Timestamp;
import java.util.UUID;

public class DocumentSummaryView {

    private ProjectUserDocumentSummary summary;
    private String documentType; // domain fields
    private String entityType;

    public DocumentSummaryView(ProjectUserDocumentSummary summary) {
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

    @XmlElement(name = "entity_type")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @XmlElement(name = "revision_id")
    public UUID getRevisionId() {
        return summary.getRevisionId();
    }

    public String getProject() {
        return summary.getProject();
    }

    @XmlElement(name = "user")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getUsername() {
        return summary.getUsername();
    }

    @JsonSerialize(using = ISO8601DateFormatSerializer.class)
    public Timestamp getAssessed() {
        return summary.getAssessed();
    }

}
