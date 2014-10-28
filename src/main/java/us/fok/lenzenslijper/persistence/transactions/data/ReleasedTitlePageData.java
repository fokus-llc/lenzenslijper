package us.fok.lenzenslijper.persistence.transactions.data;

import java.util.List;

public class ReleasedTitlePageData {

    private final List<String> titles;
    private final Integer count;

    public ReleasedTitlePageData(List<String> titles, Integer count) {
        this.titles = titles;
        this.count = count;
    }

    public List<String> getTitles() {
        return titles;
    }

    public Integer getCount() {
        return count;
    }

}
