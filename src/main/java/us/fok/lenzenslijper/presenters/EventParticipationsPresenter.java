package us.fok.lenzenslijper.presenters;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.models.dto.EnrolledAsset;
import us.fok.lenzenslijper.models.dto.ProjectUserDocumentSummary;
import us.fok.lenzenslijper.models.dto.ReleasedLinkSummary;
import us.fok.lenzenslijper.persistence.transactions.data.EventParticipationsPageData;
import us.fok.lenzenslijper.views.AssetDetailView;
import us.fok.lenzenslijper.views.DocumentDetailView;
import us.fok.lenzenslijper.views.ReleasedLinkView;

import java.util.*;

public class EventParticipationsPresenter {

    private static final String ASSET_TYPE_MAIN = "main";
    private static final String ASSET_TYPE_NOTE = "note";
    private static final String ASSET_NAME_DEFINITION = "definition";

    private final SchemaDictionary schema;

    public EventParticipationsPresenter(SchemaDictionary schema) {
        this.schema = schema;
    }

    public List<DocumentDetailView> makeViews(EventParticipationsPageData data) {
        List<DocumentDetailView> memberViews = null;
        List<ProjectUserDocumentSummary> members = data.getPublicationSummaries();
        if (members != null) {
            memberViews = new ArrayList<DocumentDetailView>(members.size());
            for (ProjectUserDocumentSummary member : members) {
                memberViews.add(configureMemberView(member, data.getEnrolledAssets(), data.getOutgoingLinks()));
            }
        }
        return memberViews;
    }

    private DocumentDetailView configureMemberView(ProjectUserDocumentSummary member, Map<UUID,List<EnrolledAsset>> assetsByRevisionId, Map<UUID,List<ReleasedLinkSummary>> linksByRevisionId) {
        UUID revisionId = member.getRevisionId();
        return configureMemberView(member, assetsByRevisionId.get(revisionId), linksByRevisionId.get(revisionId));
    }

    private DocumentDetailView configureMemberView(ProjectUserDocumentSummary summary, List<EnrolledAsset> assets, List<ReleasedLinkSummary> links) {
        DocumentDetailView view = new DocumentDetailView(summary);
        if (links != null) { configureOutgoingLinks(view, links); }
        if (assets != null) { configureViewAssets(view, assets); }
        return view;
    }

    private void configureOutgoingLinks(DocumentDetailView view, List<ReleasedLinkSummary> outgoingLinks) {
        Map<String, Map<String, ReleasedLinkView>> linksMap =
            new ReleasedLinkPresenter(schema).buildOutgoingLinkMap(outgoingLinks);
        if (!linksMap.isEmpty()) {
            view.setLinks(linksMap);
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

    private AssetDetailView extractMainAsset(Map<String, Map<String, AssetDetailView>> assetsMap) {
        AssetDetailView mainAsset = null;
        Map<String, AssetDetailView> mainAssetsMap = assetsMap.remove(ASSET_TYPE_MAIN);
        if (mainAssetsMap != null) {
            mainAsset = mainAssetsMap.get(ASSET_NAME_DEFINITION);
        }
        return mainAsset;
    }

    private Map<String, String> extractNotes(Map<String,Map<String, AssetDetailView>> assetsMap) {
        Map<String, String> notes = null;
        Map<String, AssetDetailView> noteAssetsMap = assetsMap.remove(ASSET_TYPE_NOTE);
        if ((noteAssetsMap != null) && ! noteAssetsMap.isEmpty()) {
            notes = new HashMap<String, String>(assetsMap.size());
            for(Map.Entry<String, AssetDetailView> entry : noteAssetsMap.entrySet()) {
                notes.put(entry.getKey(), entry.getValue().getAssetText());
            }
        }
        return notes;
    }

    private AssetDetailView buildAssetView(EnrolledAsset enrolledAsset) {
        String assetType = schema.getAssetType(enrolledAsset.getAssetTypeId());
        return new AssetDetailPresenter(schema).buildAssetView(assetType, enrolledAsset.getContent());
    }

}
