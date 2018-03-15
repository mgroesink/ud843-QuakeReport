package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Marcel on 15-3-2018.
 */

public class Earthquake {

    public Earthquake(String location, double mag, Date date) {
        this.location = location;
        this.mag = mag;
        this.date = date;
    }

    private String location;
    private double mag;
    private Date date;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
