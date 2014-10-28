package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.views.ConceptNestableView;

import java.util.List;
import java.util.UUID;

/*
    To be fetched in a single transaction (post-processing is deferred)
 */
public class DocumentDetailData {

    private ProjectUserDocumentSummary publicationSummary;

    private UUID entityLink;

    private List<EnrolledAsset> enrolledAssets;

    private List<ReleasedLinkSummary> links;
    private List<ReleasedLinkSummary> incomingLinks;

    private ConceptNestableView conceptSet;

    public ProjectUserDocumentSummary getPublicationSummary() {
        return publicationSummary;
    }

    public void setPublicationSummary(ProjectUserDocumentSummary summary) {
        this.publicationSummary = summary;
    }

    public UUID getEntityLink() {
        return entityLink;
    }

    public void setEntityLink(UUID entityLink) {
        this.entityLink = entityLink;
    }

    public List<EnrolledAsset> getEnrolledAssets() {
        return enrolledAssets;
    }

    public void setEnrolledAssets(List<EnrolledAsset> enrolledAssets) {
        this.enrolledAssets = enrolledAssets;
    }

    public List<ReleasedLinkSummary> getLinks() {
        return links;
    }

    public void setLinks(List<ReleasedLinkSummary> links) {
        this.links = links;
    }

    public List<ReleasedLinkSummary> getIncomingLinks() {
        return incomingLinks;
    }

    public void setIncomingLinks(List<ReleasedLinkSummary> incomingLinks) {
        this.incomingLinks = incomingLinks;
    }

    public ConceptNestableView getConceptSet() {
        return conceptSet;
    }

    public void setConceptSet(ConceptNestableView conceptSet) {
        this.conceptSet = conceptSet;
    }

}
