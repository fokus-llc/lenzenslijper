package us.fok.lenzenslijper.views.geojson;

import org.codehaus.jackson.node.ObjectNode;

public abstract class CoordinateReferenceSystem {

    private ObjectNode properties;

    public abstract String getType();

    public ObjectNode getProperties() {
        return properties;
    }

    public void setProperties(ObjectNode properties) {
        this.properties = properties;
    }

}
