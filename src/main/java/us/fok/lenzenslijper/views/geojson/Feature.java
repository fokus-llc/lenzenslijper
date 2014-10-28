package us.fok.lenzenslijper.views.geojson;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.node.ObjectNode;

public class Feature extends GeoObject {

    private String id;
    private ObjectNode properties;
    private Geometry geometry;

    public Feature() {
        super(GeoObjectType.Feature);
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectNode getProperties() {
        return properties;
    }

    public void setProperties(ObjectNode properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

}
