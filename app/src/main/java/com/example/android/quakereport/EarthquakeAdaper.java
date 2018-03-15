package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marcel on 15-3-2018.
 */

public class EarthquakeAdaper extends ArrayAdapter {
    public EarthquakeAdaper(@NonNull Context context, ArrayList<Earthquake > resource) {
        super(context, 0 , resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.eartquake_layout ,parent , false);
        }
        TextView tvMag = (TextView)convertView.findViewById(R.id.eqmag);
        TextView tvLoc = (TextView)convertView.findViewById(R.id.eqlocation);
        TextView tvDate = (TextView)convertView.findViewById(R.id.eqdate);
        Earthquake eq = (Earthquake)getItem(position);
        tvMag.setText("" + eq.getMag());
        tvLoc.setText(eq.getLocation());
        tvDate.setText(eq.getDate().toString());
        return convertView;
    }
}
