package sg.edu.rp.c346.id22025164.enrolment_ps;

public class Enrolment {
    private int year;
    private String type;
    private int enrolment;

    public Enrolment (int year, String type, int enrolment){
        this.year = year;
        this.type = type;
        this.enrolment = enrolment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "year=" + year +
                ", type='" + type + '\'' +
                ", enrolment='" + enrolment + '\'' +
                '}';
    }
}
