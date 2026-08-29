package mx.dgtic.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("mx.dgtic.controller");
        register(JacksonFeature.class);
        register(CorsFilter.class);
    }
}
