package us.fok.lenzenslijper.persistence.transactions.data;

import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;

import java.util.List;

public class DocumentPageData {

    private final List<ProjectUserDocumentSummary> documents;
    private final Integer count;

    public DocumentPageData(List<ProjectUserDocumentSummary> documents, Integer count) {
        this.documents = documents;
        this.count = count;
    }

    public List<ProjectUserDocumentSummary> getDocuments() {
        return documents;
    }

    public Integer getCount() {
        return count;
    }

}
