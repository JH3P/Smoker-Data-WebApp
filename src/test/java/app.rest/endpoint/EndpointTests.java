package app.rest.endpoint;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.sun.org.apache.xpath.internal.operations.String;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Assert;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;

/**
 * Created by JHP on 1/3/16.
 */
public class EndpointTests {
    @Test
    public void totalDataTest() {
        Response resp = get("http://localhost:8080/smokerTrends/total");
        JSONObject obj  = (JSONObject) JSONValue.parse(resp.asString());
        JSONArray jsonArray = (JSONArray) obj.get("values");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            JSONObject objectInArray = (JSONObject) jsonArray.get(i);
            Assert.assertEquals(objectInArray.get("gender"), "Total");

        }

        expect()
                .statusCode(200)
                .log().ifError()
                .when()
                .get("http://localhost:8080/smokerTrends/total");
    }

    @Test
    public void genderDataTest() {
        Response resp = get("http://localhost:8080/smokerTrends/genders");
        JSONObject obj  = (JSONObject) JSONValue.parse(resp.asString());
        JSONArray jsonArray = (JSONArray) obj.get("values");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            JSONObject objectInArray = (JSONObject) jsonArray.get(i);
            Assert.assertNotEquals(objectInArray.get("gender"), "Total");

        }

        expect()
                .statusCode(200)
                .log().ifError()
                .when()
                .get("http://localhost:8080/smokerTrends/genders");
    }

    @Test
    public void allYearsTest() {

        expect()
                .statusCode(200)
                .log().ifError()
                .when()
                .get("http://localhost:8080/smokerTrends/allYears");
    }
}
