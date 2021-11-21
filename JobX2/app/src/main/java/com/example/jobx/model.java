package com.example.jobx;

public class model {

    String aadh, add, day, hour, occu, ph, user, year;

    public model(){

    }

    public model(String aadh, String add, String day, String hour, String occu, String ph, String user, String year) {
        this.aadh = aadh;
        this.add = add;
        this.day = day;
        this.hour = hour;
        this.occu = occu;
        this.ph = ph;
        this.user = user;
        this.year = year;
    }

    public String getAadh() {
        return aadh;
    }

    public void setAadh(String aadh) {
        this.aadh = aadh;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getOccu() {
        return occu;
    }

    public void setOccu(String occu) {
        this.occu = occu;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
