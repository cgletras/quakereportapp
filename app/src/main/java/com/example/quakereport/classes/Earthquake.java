package com.example.quakereport.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {

    double mag;
    String place;
    long time;

    public Earthquake(double mag, String place, long time) {
        this.mag = mag;
        this.place = place;
        this.time = time;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
