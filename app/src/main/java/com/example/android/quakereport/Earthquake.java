package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Marcel on 15-3-2018.
 */

public class Earthquake {

    public Earthquake(String location, double mag, long time) {
        this.location = location;
        this.mag = mag;
        this.time = time;
    }

    private String location;
    private double mag;
    private long time;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

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

    public long getTimeInMilliseconds() {
        return time;
    }

    public void setTimeInMilliseconds(long time) {
        this.time = time;
    }


}
