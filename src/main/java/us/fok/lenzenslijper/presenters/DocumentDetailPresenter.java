package us.fok.lenzenslijper.presenters;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.persistence.transactions.data.DocumentDetailData;
import us.fok.lenzenslijper.views.DocumentDetailView;
import us.fok.lenzenslijper.views.AssetDetailView;
import us.fok.lenzenslijper.views.ReleasedLinkView;

import java.util.*;

public class DocumentDetailPresenter {

    private static final String MAIN_ASSET = "main";
    private static final String NOTES_ASSETS = "note";

    private static final String MAIN_ASSET_NAME = "definition";

    private final SchemaDictionary schema;

    public DocumentDetailPresenter(SchemaDictionary schema) {
        this.schema = schema;
    }

    public DocumentDetailView makeView(DocumentDetailData data) {
        DocumentDetailView view = new DocumentDetailView(data.getPublicationSummary());
        view.setEntityLink(data.getEntityLink());
        enrichViewWithDomainLabels(view);
        configureOutgoingLinks(view, data.getLinks());
        configureIncomingLinks(view, data.getIncomingLinks());
        configureViewAssets(view, data.getEnrolledAssets());
        view.setConceptSet(data.getConceptSet());
        return view;
    }

    private void enrichViewWithDomainLabels(DocumentDetailView content) {
        content.setDocumentType(schema.getDocumentType(content.getDocumentTypeId()));
        UUID prototypeConceptId = content.getPrototypeConceptId();
        if (prototypeConceptId != null) {
            content.setEntityType(schema.getCoreConcept(prototypeConceptId));
        }
    }

    private void configureOutgoingLinks(DocumentDetailView view, List<ReleasedLinkSummary> outgoingLinks) {
        Map<String, Map<String, ReleasedLinkView>> linksMap =
            new ReleasedLinkPresenter(schema).buildOutgoingLinkMap(outgoingLinks);
        if (!linksMap.isEmpty()) {
            view.setLinks(linksMap);
        }
    }

    private void configureIncomingLinks(DocumentDetailView view, List<ReleasedLinkSummary> incomingLinks) {
        Map<String, List<ReleasedLinkView>> linksMap =
            new ReleasedLinkPresenter(schema).buildIncomingLinkMap(incomingLinks);
        if (!linksMap.isEmpty()) {
            view.setIncomingLinks(linksMap);
        }
    }

    private void configureViewAssets(DocumentDetailView view, List<EnrolledAsset> assetsWithRoles) {
        Map<String, Map<String, AssetDetailView>> assetsMap = buildAssetMap(assetsWithRoles);
        view.setMainAsset(extractMainAsset(assetsMap));
        view.setNotes(extractNotes(assetsMap));
        if (!assetsMap.isEmpty()) {
            view.setAssetsByRoleAndTitle(assetsMap);
        }
    }

    private Map<String, Map<String, AssetDetailView>> buildAssetMap(List<EnrolledAsset> enrolledAssets) {
        Map<String, Map<String, AssetDetailView>> assetsByRole = new HashMap<String, Map<String, AssetDetailView>>();
        for(EnrolledAsset enrolledAsset : enrolledAssets) {
            String roleName = schema.getAssetRole(enrolledAsset.getAssetRoleId());
            Map<String, AssetDetailView> assetsByTitle = assetsByRole.get(roleName);
            if (assetsByTitle == null) {
                assetsByTitle = new HashMap<String, AssetDetailView>();
                assetsByRole.put(roleName, assetsByTitle);
            }
            assetsByTitle.put(enrolledAsset.getTitle(), buildAssetView(enrolledAsset));
        }
        return assetsByRole;
    }

    private AssetDetailView buildAssetView(EnrolledAsset enrolledAsset) {
        String assetType = schema.getAssetType(enrolledAsset.getAssetTypeId());
        return new AssetDetailPresenter(schema).buildAssetView(assetType, enrolledAsset.getContent());
    }

    private AssetDetailView extractMainAsset(Map<String, Map<String, AssetDetailView>> assetsMap) {
        AssetDetailView mainAsset = null;
        Map<String, AssetDetailView> mainAssetsMap = assetsMap.remove(MAIN_ASSET);
        if (mainAssetsMap != null) {
            mainAsset = mainAssetsMap.get(MAIN_ASSET_NAME);
        }
        return mainAsset;
    }

    private Map<String, String> extractNotes(Map<String,Map<String, AssetDetailView>> assetsMap) {
        Map<String, String> notes = null;
        Map<String, AssetDetailView> noteAssetsMap = assetsMap.remove(NOTES_ASSETS);
        if ((noteAssetsMap != null) && ! noteAssetsMap.isEmpty()) {
            notes = new HashMap<String, String>(assetsMap.size());
            for(Map.Entry<String, AssetDetailView> entry : noteAssetsMap.entrySet()) {
                notes.put(entry.getKey(), entry.getValue().getAssetText());
            }
        }
        return notes;
    }

}
