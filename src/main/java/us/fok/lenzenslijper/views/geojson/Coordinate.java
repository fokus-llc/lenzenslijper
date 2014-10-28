package us.fok.lenzenslijper.views.geojson;

import org.codehaus.jackson.annotate.JsonValue;

public class Coordinate {

    private final float x;
    private final float y;

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @JsonValue
    public float[] getJson() {
        float[] array = { x, y };
        return array;
    }

}