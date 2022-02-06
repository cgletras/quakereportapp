package com.example.quakereport.classes;

public class Earthquake {

    double mag;
    String place;
    int time;

    public Earthquake(double mag, String place, int time) {
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
