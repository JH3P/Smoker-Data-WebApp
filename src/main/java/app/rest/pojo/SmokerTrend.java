package app.rest.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JHP on 12/22/15.
 */
public class SmokerTrend {

    private String gender;
    private int year;
    private double percentage;
    private int numRespondents;
    private String definition;

    public SmokerTrend(String gender, int year, double percentage, int numRespondents, String definition){
        this.gender = gender;
        this.year = year;
        this.percentage = percentage;
        this.numRespondents = numRespondents;
        this.definition = definition;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getNumRespondents() {
        return numRespondents;
    }

    public void setNumRespondents(int numRespondents) {
        this.numRespondents = numRespondents;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
