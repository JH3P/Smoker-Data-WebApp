package app.rest.service;

import org.json.simple.JSONArray;

/**
 * Created by JHP on 12/22/15.
 */
public interface ISmokerDataService {
    JSONArray getJsonHeaders();
    JSONArray getJsonData();
}
