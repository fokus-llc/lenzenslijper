package us.fok.lenzenslijper.views.geojson;

import java.util.Arrays;
import java.util.List;

public class BoundingBox {

    private final List<Coordinate> coordinates;

    public BoundingBox(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4) {
        Coordinate[] array = { c1, c2, c3, c4 };
        coordinates = Arrays.asList(array);
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

}
