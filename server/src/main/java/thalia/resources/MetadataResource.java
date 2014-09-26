package thalia.resources;

import io.dropwizard.hibernate.UnitOfWork;
import thalia.core.Format;
import thalia.core.Genre;
import thalia.core.MediaType;
import thalia.dao.MetadataDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


/**
 * Gives access to data about the data - providing labels for the ids, and stuff like that.
 */
@Path("/metadata")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class MetadataResource {

    private final MetadataDAO dao;

    public MetadataResource(MetadataDAO dao) {
        this.dao = dao;
    }

    @GET
    @Path("/format")
    @UnitOfWork
    public List<Format> getFormatList() {
        return dao.getFormats();
    }

    @GET
    @Path("/genre")
    @UnitOfWork
    public List<Genre> getGenreList() {
        return dao.getGenres();
    }

    @GET
    @Path("/mediatype")
    @UnitOfWork
    public List<MediaType> getMediaTypeList() {
        return dao.getMediaTypes();
    }
}



