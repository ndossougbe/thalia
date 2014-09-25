package thalia;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thalia.resources.MediaResource;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Enumeration;

public class ThaliaApplication extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThaliaApplication.class);

    public static void main(String[] args) throws Exception {
        new ThaliaApplication().run(args);
    }

    @Override
    public String getName() {
        return "thalia";
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // The classpath is supposed to include thalia/app/, which contains build
        bootstrap.addBundle(new AssetsBundle("/build/", "/", "index.html", "app"));
    }

    @Override
    public void run(Configuration configuration,
                    Environment environment) {


        LOGGER.debug("----------------------------------");
        LOGGER.debug(" RUN ");
        LOGGER.debug("----------------------------------");

        final MediaResource resource = new MediaResource();
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(resource);
    }
}
