package us.fok.lenzenslijper.views.geojson;

import org.codehaus.jackson.annotate.JsonRawValue;
import org.codehaus.jackson.annotate.JsonValue;

public class GeometryLiteral implements Geometry {

    private final String json;

    public GeometryLiteral(String json) {
        this.json = json;
    }

    @JsonValue @JsonRawValue
    public String getJson() {
        return json;
    }

}
