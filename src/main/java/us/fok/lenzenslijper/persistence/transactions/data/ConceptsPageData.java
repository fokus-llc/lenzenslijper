package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.views.ConceptSummaryView;

import java.util.List;

public class ConceptsPageData {

    private final List<ConceptSummaryView> concepts;
    private final int count;

    public ConceptsPageData(List<ConceptSummaryView> concepts, int count) {
        this.concepts = concepts;
        this.count = count;
    }

    public List<ConceptSummaryView> getConcepts() {
        return concepts;
    }

    public int getCount() {
        return count;
    }

}
