package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
    To be fetched in a single transaction (post-processing is deferred)
 */
public class MemberDocumentsPageData {

    private Integer count;
    private List<ProjectUserDocumentSummary> publicationSummaries;
    private Map<UUID, List<EnrolledAsset>> enrolledAssets;
    private Map<UUID, List<ReleasedLinkSummary>> outgoingLinks;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProjectUserDocumentSummary> getPublicationSummaries() {
        return publicationSummaries;
    }

    public void setPublicationSummaries(List<ProjectUserDocumentSummary> publicationSummaries) {
        this.publicationSummaries = publicationSummaries;
    }

    public void setEnrolledAssets(Map<UUID, List<EnrolledAsset>> enrolledAssets) {
        this.enrolledAssets = enrolledAssets;
    }

    public Map<UUID, List<EnrolledAsset>> getEnrolledAssets() {
        return enrolledAssets;
    }

    public void setOutgoingLinks(Map<UUID, List<ReleasedLinkSummary>> outgoingLinks) {
        this.outgoingLinks = outgoingLinks;
    }

    public Map<UUID, List<ReleasedLinkSummary>> getOutgoingLinks() {
        return outgoingLinks;
    }

}
