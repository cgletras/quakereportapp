package com.example.quakereport.classes;

public class Earthquake {

    double mag;
    String place;
    long time;
    String url;

    public Earthquake(double mag, String place, long time, String url) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
