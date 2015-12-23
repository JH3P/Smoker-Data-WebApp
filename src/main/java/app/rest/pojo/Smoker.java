package app.rest.pojo;

/**
 * Created by JHP on 12/22/15.
 */
public class Smoker {

    private String gender;
    private int year;

    Smoker(String gender, int year){
        this.gender = gender;
        this.year = year;
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
}
