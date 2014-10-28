package us.fok.lenzenslijper.models.pagination;

import java.util.List;

public class ListPaginator<T> {

    private final List<T> items;

    public ListPaginator(List<T> items) {
        this.items = items;
    }

    public PaginatedList<T> paginate(int count, Integer offset, Integer limit) {
        PaginatedList<T> list = new PaginatedList<T>();
        list.setItems(items);
        list.setCount(count);
        list.setOffset(defaultZero(offset));
        list.setLimit(limit);
        return list;
    }

    public PaginatedList<T> paginateAll() {
        PaginatedList<T> list = new PaginatedList<T>();
        list.setItems(items);
        list.setCount(items.size());
        list.setOffset(0);
        list.setLimit(null);
        return list;
    }

    private int defaultZero(Integer i) {
        return i == null ? 0 : i.intValue();
    }

}
