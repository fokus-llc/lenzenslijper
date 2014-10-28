package us.fok.lenzenslijper.presenters;

import us.fok.lenzenslijper.domain.SchemaDictionary;
import us.fok.lenzenslijper.views.AssetDetailView;

import java.io.UnsupportedEncodingException;

public class AssetDetailPresenter {

    private static enum ContentType {
        DATA, TEXT, JSON;
    }

    private final SchemaDictionary schema;

    public AssetDetailPresenter(SchemaDictionary schema) {
        this.schema = schema;
    }

    public AssetDetailView buildAssetView(String assetType, byte[] bytes) {
        AssetDetailView assetContent = new AssetDetailView();
        assetContent.setAssetType(assetType);

        switch(contentType(assetType)) {
            case TEXT:
            case JSON:
                assetContent.setAssetText(decodeAssetText(bytes));
                break;
            case DATA:
            default:
                assetContent.setAssetData(bytes);
                break;
        }

        return assetContent;
    }

    private static ContentType contentType(String assetType) {
        ContentType type;
        if (assetType.startsWith("text")) {
            type = ContentType.TEXT;
        }
        else if (assetType.endsWith("json")) {
            type = ContentType.JSON;
        }
        else {
            type = ContentType.DATA;
        }
        return type;
    }


    private static String decodeAssetText(byte[] assetBytes) {
        try {
            return new String(assetBytes, "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to decode asset text", e);
        }
    }

}
