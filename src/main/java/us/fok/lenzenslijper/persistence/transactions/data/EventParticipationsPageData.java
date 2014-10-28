package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EventParticipationsPageData {

    private List<ProjectUserDocumentSummary> publicationSummaries;
    private Map<UUID, List<ReleasedLinkSummary>> outgoingLinks;
    private Map<UUID, List<EnrolledAsset>> enrolledAssets;
    private int count;

    public void setPublicationSummaries(List<ProjectUserDocumentSummary> publicationSummaries) {
        this.publicationSummaries = publicationSummaries;
    }

    public List<ProjectUserDocumentSummary> getPublicationSummaries() {
        return publicationSummaries;
    }

    public void setOutgoingLinks(Map<UUID, List<ReleasedLinkSummary>> outgoingLinks) {
        this.outgoingLinks = outgoingLinks;
    }

    public Map<UUID, List<ReleasedLinkSummary>> getOutgoingLinks() {
        return outgoingLinks;
    }

    public void setEnrolledAssets(Map<UUID, List<EnrolledAsset>> enrolledAssets) {
        this.enrolledAssets = enrolledAssets;
    }

    public Map<UUID, List<EnrolledAsset>> getEnrolledAssets() {
        return enrolledAssets;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
