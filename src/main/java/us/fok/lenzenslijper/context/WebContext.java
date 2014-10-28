package us.fok.lenzenslijper.context;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("") // required when package introspection is used
public class WebContext extends ResourceConfig {

    public WebContext() {
        packages("us.fok.lenzenslijper.controllers").
            register(JacksonFeature.class);
    }

}
