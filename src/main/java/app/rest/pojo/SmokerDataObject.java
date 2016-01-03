package app.rest.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by JHP on 1/2/16.
 */
@XmlRootElement
public class SmokerDataObject {
    private List<SmokerTrend> values;

    public List<SmokerTrend> getValues() {
        return values;
    }

    public void setValues(List<SmokerTrend> values) {
        this.values = values;
    }
}
