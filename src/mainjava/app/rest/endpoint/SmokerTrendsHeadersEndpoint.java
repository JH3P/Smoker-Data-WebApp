package app.rest.endpoint;

import app.rest.dao.SmokerTrendDao;
import app.rest.pojo.SmokerHeaderObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by JHP on 1/12/16.
 */
@Path("/headers")
public class SmokerTrendsHeadersEndpoint {
    private SmokerTrendDao smokerDao;
    //Get the years
    @Path("/allYears")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public SmokerHeaderObject getYears() {
        smokerDao = new SmokerTrendDao();
        SmokerHeaderObject result =  new SmokerHeaderObject();
        result.setValues(smokerDao.getAllYears());
        return result;
    }

    //Get the smoker definitions
    @Path("/allDefinitions")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public SmokerHeaderObject getDefinitions() {
        smokerDao = new SmokerTrendDao();
        SmokerHeaderObject result =  new SmokerHeaderObject();
        result.setValues(smokerDao.getAllDefinitions());
        return result;
    }

}
