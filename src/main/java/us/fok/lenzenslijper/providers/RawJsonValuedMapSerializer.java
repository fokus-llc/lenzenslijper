package us.fok.lenzenslijper.providers;


import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Map;

public class RawJsonValuedMapSerializer extends JsonSerializer<Map<String, String>> {

    @Override
    public void serialize(Map<String, String> map, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            generator.writeFieldName(entry.getKey());
            generator.writeRawValue(entry.getValue());
        }
        generator.writeEndObject();
    }

}
