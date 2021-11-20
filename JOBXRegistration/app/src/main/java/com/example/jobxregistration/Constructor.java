package com.example.jobxregistration;

public class Constructor {
    String user, add, ph, aadh,occu, hour, day;

    public Constructor(String user, String add, String ph, String aadh, String occu, String hour, String day) {
        this.user = user;
        this.add = add;
        this.ph = ph;
        this.aadh = aadh;
        this.occu = occu;
        this.hour = hour;
        this.day = day;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getAadh() {
        return aadh;
    }

    public void setAadh(String aadh) {
        this.aadh = aadh;
    }

    public String getOccu() {
        return occu;
    }

    public void setOccu(String occu) {
        this.occu = occu;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
