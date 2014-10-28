package us.fok.lenzenslijper.selectors;

public class ReleasedTitleSelector extends PaginatedSelector {

    private final String prefix;
    private final int releaseTagId;

    public ReleasedTitleSelector(String prefix, int releaseTagId, Integer offset, Integer limit) {
        this.prefix = prefix;
        this.releaseTagId = releaseTagId;
        this.setOffset(offset);
        this.setLimit(limit);
    }

    public String getPrefix() {
        return prefix;
    }

    public int getReleaseTagId() {
        return releaseTagId;
    }

}
