package us.fok.lenzenslijper.views;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Map;

public class EntityDetailView {

    private String entityType;
    private List<DocumentSummaryView> documents;
    private Map<String, Map<String, ReleasedLinkView>> outgoingLinkMap;
    private Map<String, List<ReleasedLinkView>> incomingLinkMap;

    public void setPrototypeConcept(String entityType) {
        this.entityType = entityType;
    }

    @XmlElement(name = "entity_type")
    public String getEntityType() {
        return entityType;
    }

    public void setDocuments(List<DocumentSummaryView> documents) {
        this.documents = documents;
    }

    public List<DocumentSummaryView> getDocuments() {
        return documents;
    }

    @XmlElement(name = "links")
    public void setOutgoingLinkMap(Map<String, Map<String, ReleasedLinkView>> outgoingLinkMap) {
        this.outgoingLinkMap = outgoingLinkMap;
    }

    public Map<String, Map<String, ReleasedLinkView>> getOutgoingLinkMap() {
        return outgoingLinkMap;
    }

    @XmlElement(name = "incoming_links")
    public void setIncomingLinkMap(Map<String, List<ReleasedLinkView>> incomingLinkMap) {
        this.incomingLinkMap = incomingLinkMap;
    }

    public Map<String, List<ReleasedLinkView>> getIncomingLinkMap() {
        return incomingLinkMap;
    }

}
