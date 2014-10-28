package us.fok.lenzenslijper.views.geojson;

import java.util.List;

public class FeatureCollection extends GeoObject {

    private List<Feature> features;

    public FeatureCollection() {
        super(GeoObjectType.FeatureCollection);
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

}
