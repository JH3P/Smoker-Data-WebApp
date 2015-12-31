package app.rest.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;

/**
 * Created by JHP on 12/24/15.
 */
@Path("/smokerTrends")
public class SmokerTrendsEndpoint {
    @GET
    @Produces("text/plain")
    public String getIt() {
        return "Got it!";
    }
}