package us.fok.lenzenslijper.views;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;

public class AssetDetailView {

    private String assetType;
    private String assetText;
    private byte[] assetData;

    @XmlElement(name = "type")
    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    @XmlElement(name = "text")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getAssetText() {
        return assetText;
    }

    public void setAssetText(String assetText) {
        this.assetText = assetText;
    }

    @XmlElement(name = "data")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public byte[] getAssetData() {
        return assetData;
    }

    public void setAssetData(byte[] assetData) {
        this.assetData = assetData;
    }

}
