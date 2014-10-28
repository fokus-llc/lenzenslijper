package us.fok.lenzenslijper.presenters;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.views.DocumentSummaryView;

import java.util.*;

public class DocumentSummaryPresenter {

    private SchemaDictionary dictionary;

    public DocumentSummaryPresenter(SchemaDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<DocumentSummaryView> summarize(List<ProjectUserDocumentSummary> records) {
        List<DocumentSummaryView> summaries = new ArrayList<DocumentSummaryView>(records.size());
        for (ProjectUserDocumentSummary record : records) {
            DocumentSummaryView summary = enrichWithDomainLabels(record);
            summaries.add(summary);
        }
        return summaries;
    }

    private DocumentSummaryView enrichWithDomainLabels(ProjectUserDocumentSummary record) {
        DocumentSummaryView summary = new DocumentSummaryView(record);

        String documentTypeName = dictionary.getDocumentType(record.getDocumentTypeId());
        summary.setDocumentType(documentTypeName);

        UUID prototypeConceptId = record.getPrototypeConceptId();
        if (prototypeConceptId != null) {
            String prototypeConceptName = dictionary.getCoreConcept(prototypeConceptId);
            summary.setEntityType(prototypeConceptName);
        }

        return summary;
    }

}
