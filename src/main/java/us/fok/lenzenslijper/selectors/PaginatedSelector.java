package us.fok.lenzenslijper.selectors;

public class PaginatedSelector {

    private Integer limit;
    private Integer offset;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public boolean isSelectAll() {
        return !isLimited() && !hasNonZeroOffset();
    }

    public boolean isLimited() {
        return limit != null;
    }

    public boolean hasNonZeroOffset() {
        return (offset != null) && (offset != 0);
    }

}
