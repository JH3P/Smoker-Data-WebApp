package app.rest.dao;

import app.rest.pojo.SmokerTrend;
import app.rest.service.SmokerDataService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JHP on 12/22/15.
 */
public class SmokerTrendDao implements ISmokerTrendDao {
    private SmokerDataService service;
    public enum HeaderName{
        Year(8), Gender(10), Percentage(11), Respondents(14);
        private int value;

        private HeaderName(int value) {
            this.value = value;
        }
    };

    public SmokerTrendDao(){
        this.service = new SmokerDataService();
    }

    public List<String> getAllHeaders() {
        JSONArray headerArr = service.getJsonHeaders();
        ArrayList<String> headers = new ArrayList<String>();
        for (int i = 0; i < headerArr.size(); i++){
            headers.add(i, ((JSONObject) headerArr.get(i)).get("name").toString());
        }
        return headers;
    }

    public List<SmokerTrend> getAllSmokerData() {
        JSONArray dataArr = service.getJsonData();
        ArrayList<SmokerTrend> data = new ArrayList<SmokerTrend>();
        for (int i = 0; i < dataArr.size(); i++){
            JSONArray line = (JSONArray) dataArr.get(i);
            SmokerTrend dataObj = new SmokerTrend(line.get(HeaderName.Gender.value).toString(), Integer.parseInt(line.get(HeaderName.Year.value).toString()),
                    Double.parseDouble(line.get(HeaderName.Percentage.value).toString()), Integer.parseInt(line.get(HeaderName.Respondents.value).toString()));
            data.add(dataObj);
        }
        return data;
    }

    public List<SmokerTrend> getSmokerDataByGender() {
        JSONArray dataArr = service.getJsonData();
        ArrayList<SmokerTrend> data = new ArrayList<SmokerTrend>();
        for (int i = 0; i < dataArr.size(); i++){
            JSONArray line = (JSONArray) dataArr.get(i);
            if (!line.get(HeaderName.Gender.value).toString().equals("Total")) {
                SmokerTrend dataObj = new SmokerTrend(line.get(HeaderName.Gender.value).toString(), Integer.parseInt(line.get(HeaderName.Year.value).toString()),
                        Double.parseDouble(line.get(HeaderName.Percentage.value).toString()), Integer.parseInt(line.get(HeaderName.Respondents.value).toString()));
                data.add(dataObj);
            }
        }
        return data;
    }

    public List<SmokerTrend> getTotalSmokerData() {
        JSONArray dataArr = service.getJsonData();
        ArrayList<SmokerTrend> data = new ArrayList<SmokerTrend>();
        for (int i = 0; i < dataArr.size(); i++){
            JSONArray line = (JSONArray) dataArr.get(i);
            if (line.get(HeaderName.Gender.value).toString().equals("Total")) {
                SmokerTrend dataObj = new SmokerTrend(line.get(HeaderName.Gender.value).toString(), Integer.parseInt(line.get(HeaderName.Year.value).toString()),
                        Double.parseDouble(line.get(HeaderName.Percentage.value).toString()), Integer.parseInt(line.get(HeaderName.Respondents.value).toString()));
                data.add(dataObj);
            }
        }
        return data;
    }

    public List<String> getAllYears() {
        JSONArray dataArr = service.getJsonData();
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < dataArr.size(); i++){
            JSONArray line = (JSONArray) dataArr.get(i);
            if(!data.contains(line.get(HeaderName.Year.value).toString())){
                data.add(line.get(HeaderName.Year.value).toString());
            }
        }
        return data;
    }
}

