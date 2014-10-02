package thalia;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.jetty.HttpConnectorFactory;
import io.dropwizard.server.SimpleServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thalia.dao.MediaDAO;
import thalia.dao.MetadataDAO;
import thalia.resources.MediaResource;
import thalia.resources.MetadataResource;

public class ThaliaApplication extends Application<ThaliaConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThaliaApplication.class);

    private final HibernateBundle<ThaliaConfiguration> hibernate = new ScanningHibernateBundle<ThaliaConfiguration>("thalia.core") {
        @Override
        public DataSourceFactory getDataSourceFactory(ThaliaConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    private int apiPort;

    public static void main(String[] args) throws Exception {
        new ThaliaApplication().run(args);
    }

    @Override
    public String getName() {
        return "thalia";
    }

    @Override
    public void initialize(Bootstrap<ThaliaConfiguration> bootstrap) {

        /* Dev: thalia/app/ should be added to the classpath. the build directory is then picked up as asset root.
         * TODO: Automate building the JS app and add it to the resources dir, so that it all sits in the JAR. */
        bootstrap.addBundle(new AssetsBundle("/build/", "/", "index.html"));

        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(ThaliaConfiguration configuration, Environment environment) {
        LOGGER.debug("----------------------------------");
        LOGGER.debug(" RUN ");
        LOGGER.debug("----------------------------------");

        final MediaDAO mediaDAO = new MediaDAO(hibernate.getSessionFactory());

        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(new MediaResource(mediaDAO));
        environment.jersey().register(new MetadataResource(new MetadataDAO(hibernate.getSessionFactory())));


        apiPort = ((HttpConnectorFactory) ((SimpleServerFactory) configuration.getServerFactory()).getConnector()).getPort();
    }

    public int getApiPort() {
        return apiPort;
    }
}
