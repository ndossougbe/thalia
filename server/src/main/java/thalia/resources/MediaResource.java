package thalia.resources;

import io.dropwizard.hibernate.UnitOfWork;
import thalia.core.Media;
import thalia.dao.MediaDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/media")
@Produces(MediaType.APPLICATION_JSON)
public class MediaResource {
    private final MediaDAO dao;

    public MediaResource(MediaDAO dao) {
        this.dao = dao;
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public Media get(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @GET
    @UnitOfWork
    public List<Media> list() {
        return dao.findAll();
    }
}
