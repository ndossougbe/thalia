package thalia.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import thalia.core.Media;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/media")
@Produces(MediaType.APPLICATION_JSON)
public class MediaResource {
    private final AtomicLong counter;

    public MediaResource() {
        this.counter = new AtomicLong();
    }

    @GET
    public Media sayHello(@QueryParam("name") Optional<String> name) {

        return new Media(counter.incrementAndGet(), name.or("something"));
    }
}
