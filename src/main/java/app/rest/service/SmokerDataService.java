package app.rest.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 *
 * Created by JHP on 12/22/15.
 */
public class SmokerDataService implements ISmokerDataService {
    private static final String jsonFilePath = "/smoker-data.json";


    public JSONArray getJsonHeaders() {
        try{
            final URL jsonURL = this.getClass().getResource(jsonFilePath);
            FileReader reader = new FileReader(jsonURL.getFile());
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return (JSONArray)((JSONObject)((JSONObject) jsonObject.get("meta")).get("view")).get("columns");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getJsonData() {
        try{
            final URL jsonURL = this.getClass().getResource(jsonFilePath);
            FileReader reader = new FileReader(jsonURL.getFile());
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return (JSONArray) jsonObject.get("data");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
