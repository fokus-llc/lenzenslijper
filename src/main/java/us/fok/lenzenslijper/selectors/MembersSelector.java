package us.fok.lenzenslijper.selectors;

public class MembersSelector extends PaginatedSelector {

    String conceptSlug;

    public MembersSelector(Integer limit, Integer offset) {
        this.setLimit(limit);
        this.setOffset(offset);
    }

    public String getConceptSlug() {
        return conceptSlug;
    }

    public void setConceptSlug(String conceptSlug) {
        this.conceptSlug = conceptSlug;
    }

}
