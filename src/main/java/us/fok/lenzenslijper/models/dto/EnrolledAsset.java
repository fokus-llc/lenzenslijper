package us.fok.lenzenslijper.models.dto;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectSelectStep;

import static us.fok.lenzenslijper.models.jooq.Tables.ASSETS;
import static us.fok.lenzenslijper.models.jooq.Tables.REVISION_ASSET_ROLES;

// join: EDITION_ASSET_ROLES and ASSETS
public class EnrolledAsset {

    public static SelectSelectStep<? extends Record> projection(DSLContext jooq) {
        return jooq.
            select(REVISION_ASSET_ROLES.REVISION_ID,
                REVISION_ASSET_ROLES.ASSET_ROLE_ID,
                REVISION_ASSET_ROLES.TITLE,
                ASSETS.ASSET_TYPE_ID,
                ASSETS.CONTENT);
    }

    public static SelectOnConditionStep<? extends Record> relation(DSLContext jooq) {
        return projection(jooq).
            from(REVISION_ASSET_ROLES).
            join(ASSETS).
            on(ASSETS.ASSET_ID.eq(REVISION_ASSET_ROLES.ASSET_ID));
    }

    private int assetRoleId;
    private String title;
    private int assetTypeId;
    private byte[] content;

    public int getAssetRoleId() {
        return assetRoleId;
    }

    public void setAssetRoleId(int assetRoleId) {
        this.assetRoleId = assetRoleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(int assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
