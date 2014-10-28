package us.fok.lenzenslijper.presenters;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.domain.SystemSchemaConstants;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.views.ReleasedLinkView;

import java.util.*;

public class ReleasedLinkPresenter {

    private final SchemaDictionary schema;

    public ReleasedLinkPresenter(SchemaDictionary schema) {
        this.schema = schema;
    }

    public Map<String, Map<String, ReleasedLinkView>> buildOutgoingLinkMap(List<ReleasedLinkSummary> links) {
        Map<String, Map<String, ReleasedLinkView>> linksByType = new HashMap<String, Map<String, ReleasedLinkView>>();
        for(ReleasedLinkSummary linkRecord : links) {
            addOutgoingLinkToMap(linksByType, linkRecord);
        }
        return linksByType;
    }

    public Map<String, List<ReleasedLinkView>> buildIncomingLinkMap(List<ReleasedLinkSummary> links) {
        Map<String, List<ReleasedLinkView>> linksByType = new HashMap<String, List<ReleasedLinkView>>();
        for(ReleasedLinkSummary linkRecord : links) {
            addIncomingLinkToMap(linksByType, linkRecord);
        }
        return linksByType;
    }

    private void addOutgoingLinkToMap(Map<String, Map<String, ReleasedLinkView>> linksByType, ReleasedLinkSummary linkRecord) {
        String linkTypeName = schema.getLinkType(linkRecord.getLinkTypeId());
        if (SystemSchemaConstants.LINK_TYPE_HAS_PROTOTYPE.equals(linkTypeName) ||
            SystemSchemaConstants.LINK_TYPE_DEFINES.equals(linkTypeName)) {
            // skip: loaded separately
        }
        else {
            Map<String, ReleasedLinkView> linksByTitle = linksByType.get(linkTypeName);
            if (linksByTitle == null) {
                linksByTitle = new HashMap<String, ReleasedLinkView>();
                linksByType.put(linkTypeName, linksByTitle);
            }
            linksByTitle.put(linkRecord.getTargetTitle(), makeLinkView(linkTypeName, linkRecord));
        }
    }

    private void addIncomingLinkToMap(Map<String,List<ReleasedLinkView>> linksByType, ReleasedLinkSummary linkRecord) {
        String linkTypeName = schema.getConverseLinkType(linkRecord.getLinkTypeId());
        if (linkTypeName != null) {
            List<ReleasedLinkView> views = linksByType.get(linkTypeName);
            if (views == null) {
                views = new ArrayList<ReleasedLinkView>();
                linksByType.put(linkTypeName, views);
            }
            views.add(makeLinkView(linkTypeName, linkRecord));
        }
    }

    private ReleasedLinkView makeLinkView(String linkTypeName, ReleasedLinkSummary linkRecord) {
        ReleasedLinkView view = new ReleasedLinkView(linkRecord);

        view.setLinkType(linkTypeName);

        view.setDocumentType(schema.getDocumentType(linkRecord.getDocumentTypeId()));

        UUID prototypeConceptId = linkRecord.getPrototypeConceptId();
        if (prototypeConceptId != null) {
            view.setEntityType(schema.getCoreConcept(prototypeConceptId));
        }

        return view;
    }

}
