package thalia;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thalia.core.Format;
import thalia.core.Genre;
import thalia.core.Media;
import thalia.core.Version;
import thalia.dao.MediaDAO;
import thalia.dao.MetadataDAO;
import thalia.resources.MediaResource;
import thalia.resources.MetadataResource;

public class ThaliaApplication extends Application<ThaliaConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThaliaApplication.class);

    public static void main(String[] args) throws Exception {
        new ThaliaApplication().run(args);
    }

    private final HibernateBundle<ThaliaConfiguration> hibernate = new HibernateBundle<ThaliaConfiguration>(
            Media.class, Format.class, Genre.class, Version.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(ThaliaConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "thalia";
    }

    @Override
    public void initialize(Bootstrap<ThaliaConfiguration> bootstrap) {
        // The classpath is supposed to include thalia/app/, which contains build
        bootstrap.addBundle(new AssetsBundle("/build/", "/", "index.html", "app"));

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
    }
}
