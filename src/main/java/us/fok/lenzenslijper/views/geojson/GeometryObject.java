package us.fok.lenzenslijper.views.geojson;

import java.util.List;

public class GeometryObject extends GeoObject implements Geometry {

    private List<Coordinate> coordinates;

    public GeometryObject(GeoObjectType type) {
        super(type);
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

}
