package app.rest.service;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import java.io.*;
import java.net.URL;

/**
 *
 * Created by JHP on 12/22/15.
 */
public class SmokerDataService implements ISmokerDataService {
    InputStream in = getClass().getResourceAsStream("/smoker-data.json");

    public JSONArray getJsonHeaders() {
        try{
            String jsonTxt = IOUtils.toString(in);
            JSONParser jsonParser = new JSONParser();
            System.out.println(jsonTxt);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonTxt);
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
            String jsonTxt = IOUtils.toString(in);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonTxt.toString());
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
