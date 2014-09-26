package thalia.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import thalia.core.Media;

import java.util.List;

public class MediaDAO extends AbstractDAO<Media> {
    public MediaDAO(SessionFactory factory) {
        super(factory);
    }

    public Media findById(Long id) {
        return get(id);
    }

    public long create(Media media) {
        return persist(media).getId();
    }

    public List<Media> findAll() {
        return list(namedQuery("thalia.core.Media.findAll"));
    }
}