package thalia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import thalia.core.Format;
import thalia.core.Genre;
import thalia.core.MediaType;

import java.util.Arrays;
import java.util.List;

public class MetadataDAO {

    private final SessionFactory factory;

    public MetadataDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public List<Format> getFormats() {
        Session s = factory.getCurrentSession();
        return s.createCriteria(Format.class).list();
    }

    public List<Genre> getGenres() {
        Session s = factory.getCurrentSession();
        return s.createCriteria(Genre.class).list();
    }

    public List<MediaType> getMediaTypes() {
        return Arrays.asList(MediaType.values());
    }
}
