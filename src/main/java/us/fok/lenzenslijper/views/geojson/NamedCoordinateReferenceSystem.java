package us.fok.lenzenslijper.views.geojson;

public class NamedCoordinateReferenceSystem extends CoordinateReferenceSystem {

    @Override
    public String getType() {
        return "name";
    }

    // properties must include name

}
