package us.fok.lenzenslijper.selectors;

public class UsersSelector extends PaginatedSelector {

    public UsersSelector(Integer limit, Integer offset) {
        this.setLimit(limit);
        this.setOffset(offset);
    }

}
