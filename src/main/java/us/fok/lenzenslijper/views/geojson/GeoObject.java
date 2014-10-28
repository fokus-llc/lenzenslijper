package us.fok.lenzenslijper.views.geojson;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public abstract class GeoObject {

    private final GeoObjectType type;
    private CoordinateReferenceSystem crs;
    private BoundingBox bbox;

    public GeoObject(GeoObjectType type) {
        this.type = type;
    }

    public GeoObjectType getType() {
        return type;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public CoordinateReferenceSystem getCrs() {
        return crs;
    }

    public void setCrs(CoordinateReferenceSystem crs) {
        this.crs = crs;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public BoundingBox getBbox() {
        return bbox;
    }

    public void setBbox(BoundingBox bbox) {
        this.bbox = bbox;
    }

}
