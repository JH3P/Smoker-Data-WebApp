package app.rest.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.ws.Response;

/**
 * Created by JHP on 12/24/15.
 */
@Path("/smokerTrends")
public class SmokerTrendsEndpoint {
    @GET
    @Path("/{name}")
    public Response helloWorld(@PathParam("name") String name) {
        String response = "Hello world! My name is " + name;

        return null;
    }
}