package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;

import java.util.List;
import java.util.UUID;

public class EntityDetailData {

    private UUID entityId;
    private UUID prototypeConceptId;
    private List<ProjectUserDocumentSummary> documentSummaries;
    private List<ReleasedLinkSummary> outgoingLinks;
    private List<ReleasedLinkSummary> incomingLinks;

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public void setDocumentSummaries(List<ProjectUserDocumentSummary> documentSummaries) {
        this.documentSummaries = documentSummaries;
    }

    public List<ProjectUserDocumentSummary> getDocumentSummaries() {
        return documentSummaries;
    }

    public UUID getPrototypeConceptId() {
        return prototypeConceptId;
    }

    public void setPrototypeConceptId(UUID prototypeConceptId) {
        this.prototypeConceptId = prototypeConceptId;
    }

    public List<ReleasedLinkSummary> getOutgoingLinks() {
        return outgoingLinks;
    }

    public void setOutgoingLinks(List<ReleasedLinkSummary> outgoingLinks) {
        this.outgoingLinks = outgoingLinks;
    }

    public List<ReleasedLinkSummary> getIncomingLinks() {
        return incomingLinks;
    }

    public void setIncomingLinks(List<ReleasedLinkSummary> incomingLinks) {
        this.incomingLinks = incomingLinks;
    }

}
