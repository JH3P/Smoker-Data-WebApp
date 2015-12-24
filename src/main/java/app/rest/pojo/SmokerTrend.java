package app.rest.pojo;

/**
 * Created by JHP on 12/22/15.
 */
public class SmokerTrend {

    private String gender;
    private int year;
    private double percentage;
    private int numRespondents;

    public SmokerTrend(String gender, int year, double percentage, int numRespondents){
        this.gender = gender;
        this.year = year;
        this.percentage = percentage;
        this.numRespondents = numRespondents;
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
}
