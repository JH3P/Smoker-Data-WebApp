package app.rest.endpoint;

import app.rest.dao.SmokerTrendDao;
import app.rest.pojo.SmokerDataObject;
import app.rest.pojo.SmokerHeaderObject;
import app.rest.pojo.SmokerTrend;
import org.glassfish.jersey.message.internal.MediaTypeProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JHP on 12/24/15.
 */
@Path("/smokerTrends")
public class SmokerTrendsEndpoint {
    private SmokerTrendDao smokerDao;
    //Get data for all genders
    @Path("/total")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public SmokerDataObject getTotalData() {
        smokerDao = new SmokerTrendDao();
        SmokerDataObject result =  new SmokerDataObject();
        result.setValues(smokerDao.getTotalSmokerData());
        return result;
    }
    //Get data by female and male genders
    @Path("/genders")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public SmokerDataObject getGenderData() {
        smokerDao = new SmokerTrendDao();
        SmokerDataObject result =  new SmokerDataObject();
        result.setValues(smokerDao.getSmokerDataByGender());
        return result;
    }

    //Get the entire data set
    @Path("/all")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public SmokerDataObject getAllData() {
        smokerDao = new SmokerTrendDao();
        SmokerDataObject result =  new SmokerDataObject();
        result.setValues(smokerDao.getAllSmokerData());
        return result;
    }
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


}