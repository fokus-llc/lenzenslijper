package us.fok.lenzenslijper.presenters;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.persistence.transactions.data.EntityDetailData;
import us.fok.lenzenslijper.views.DocumentSummaryView;
import us.fok.lenzenslijper.views.EntityDetailView;
import us.fok.lenzenslijper.views.ReleasedLinkView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EntityDetailPresenter {

    private final SchemaDictionary schema;

    public EntityDetailPresenter(SchemaDictionary schema) {
        this.schema = schema;
    }

    public EntityDetailView makeView(EntityDetailData data) {
        EntityDetailView view = new EntityDetailView();

        UUID prototypeConceptId = data.getPrototypeConceptId();
        view.setPrototypeConcept(schema.getCoreConcept(prototypeConceptId));

        List<DocumentSummaryView> documentViews =
            new DocumentSummaryPresenter(schema).summarize(data.getDocumentSummaries());
        view.setDocuments(documentViews);

        Map<String, Map<String, ReleasedLinkView>> outgoingLinkMap =
            new ReleasedLinkPresenter(schema).buildOutgoingLinkMap(data.getOutgoingLinks());
        view.setOutgoingLinkMap(outgoingLinkMap);

        Map<String, List<ReleasedLinkView>> incomingLinkMap =
            new ReleasedLinkPresenter(schema).buildIncomingLinkMap(data.getIncomingLinks());
        view.setIncomingLinkMap(incomingLinkMap);

        return view;
    }

}
