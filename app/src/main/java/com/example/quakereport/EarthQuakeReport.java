package com.example.quakereport;

public class EarthQuakeReport {

    private String mCity;
    private Double mMagnitude;
    private String date;

    public EarthQuakeReport(String mCity, Double mMagnitude, String date) {
        this.mCity = mCity;
        this.mMagnitude = mMagnitude;
        this.date = date;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(Double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
