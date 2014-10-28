package us.fok.lenzenslijper.views.geojson;

import java.util.List;

public class GeometryCollection extends GeoObject {

    private List<Geometry> geometries;

    public GeometryCollection() {
        super(GeoObjectType.GeometryCollection);
    }

    public List<Geometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
    }

}
