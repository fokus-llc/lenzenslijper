package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.dto.ReleasedRevisionSummary;

import java.util.List;

public class RevisionPageData {

    private final List<ReleasedRevisionSummary> revisions;
    private final int count;

    public RevisionPageData(List<ReleasedRevisionSummary> revisions, int count) {
        this.revisions = revisions;
        this.count = count;
    }

    public List<ReleasedRevisionSummary> getRevisions() {
        return revisions;
    }

    public int getCount() {
        return count;
    }

}
