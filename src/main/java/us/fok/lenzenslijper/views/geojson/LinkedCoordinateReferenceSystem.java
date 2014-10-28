package us.fok.lenzenslijper.views.geojson;

public class LinkedCoordinateReferenceSystem extends CoordinateReferenceSystem {

    @Override
    public String getType() {
        return "link";
    }

    // properties must include href, may include type (proj4|ogcwkt|esriwkt)

}
