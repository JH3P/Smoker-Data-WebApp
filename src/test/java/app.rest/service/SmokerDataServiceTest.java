package app.rest.service;

import org.junit.Assert;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * Created by JHP on 12/22/15.
 */
public class SmokerDataServiceTest{

    @Test
    public void testGetData(){
        SmokerDataService dataService = new SmokerDataService();
        JSONArray jsonArray = dataService.getJsonData();
        JSONArray headerArr = dataService.getJsonHeaders();
        Assert.assertFalse(jsonArray.isEmpty());
        Assert.assertNotNull(headerArr);
    }

}
