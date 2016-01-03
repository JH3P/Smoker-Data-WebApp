package app.rest.dao;

import app.rest.pojo.SmokerTrend;

import java.util.List;

/**
 * Created by JHP on 12/15/15.
 */
public interface ISmokerTrendDao {
    public List<String> getAllHeaders();
    public List<SmokerTrend> getAllSmokerData();
    public List<SmokerTrend> getSmokerDataByGender();
    public List<SmokerTrend> getTotalSmokerData();
    public List<String> getAllYears();
}
