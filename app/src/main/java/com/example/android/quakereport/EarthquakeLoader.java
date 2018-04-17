package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcel on 30-3-2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String TAG = EarthquakeLoader.class.getName();

    private String mUrl;
    private int mOrderBy;

    public EarthquakeLoader(Context context , String url , int orderby) {
        super(context);
        mUrl = url;
        mOrderBy = orderby;
    }

    @Override
    protected void onStartLoading() {
        Log.i(TAG , "Loader started");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(TAG , "Loading in background");
        if(mUrl == null) return null;
        List<Earthquake> earthquakes = QueryUtils.extractEarthquakes(mUrl , mOrderBy);
        return earthquakes;
    }
}
