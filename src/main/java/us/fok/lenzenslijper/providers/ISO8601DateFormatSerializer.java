package us.fok.lenzenslijper.providers;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.util.StdDateFormat;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;

public class ISO8601DateFormatSerializer extends JsonSerializer<Timestamp> {

    @Override
    public void serialize(Timestamp timestamp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        DateFormat formatter = (DateFormat) StdDateFormat.getBlueprintISO8601Format().clone();
        String dateString = formatter.format(timestamp);
        jsonGenerator.writeString(dateString);
    }

}
