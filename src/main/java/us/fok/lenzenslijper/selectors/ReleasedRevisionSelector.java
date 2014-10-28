package us.fok.lenzenslijper.selectors;

import java.util.UUID;

public class ReleasedRevisionSelector extends PaginatedSelector {

    public static enum Sort {
        LATEST, OLDEST;
    }

    private final UUID documentLinkableId;
    private final int releaseTagId;
    private Sort sort;

    public ReleasedRevisionSelector(UUID documentLinkableId, int releaseTagId) {
        this.documentLinkableId = documentLinkableId;
        this.releaseTagId = releaseTagId;
    }

    public UUID getDocumentLinkableId() {
        return documentLinkableId;
    }

    public int getReleaseTagId() {
        return releaseTagId;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

}
