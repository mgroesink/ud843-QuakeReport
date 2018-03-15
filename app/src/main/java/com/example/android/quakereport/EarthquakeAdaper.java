package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.support.v4.app.ActivityCompat.startActivity;

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
        SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy");
        DecimalFormat magFormatter = new DecimalFormat("0.0");
        TextView tvMag = (TextView)convertView.findViewById(R.id.magnitude);
        TextView tvLoc1 = (TextView)convertView.findViewById(R.id.location_offset);
        TextView tvLoc2 = (TextView)convertView.findViewById(R.id.primary_location);
        TextView tvDate = (TextView)convertView.findViewById(R.id.date);
        TextView tvTime = (TextView)convertView.findViewById(R.id.time);

        final Earthquake eq = (Earthquake)getItem(position);
        Date eqDate = new Date(eq.getTimeInMilliseconds());
        tvMag.setText(magFormatter.format(eq.getMag()));

        String location1;
        String location2;
        String location = eq.getLocation();
        if(!location.contains(" of ")){
            location1 = "Near the";
            location2 = location;
        }
        else {
            location1 = location.substring(0 , location.indexOf(" of ") + 3);
            location2 = location.substring(location.indexOf(" of ") + 4);
        }
        tvLoc1.setText(location1);
        tvLoc2.setText(location2);
        tvDate.setText(formatDate(eqDate));
        tvTime.setText(formatTime(eqDate));

        GradientDrawable magCircle = (GradientDrawable)tvMag.getBackground();

        int magColor = getMagnitudeColor(eq.getMag());
        magCircle.setColor(magColor);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(eq.getUrl()));
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    /**
     * 
     * @param mag
     * @return
     */
    private int getMagnitudeColor(double mag) {
        int value = (int)mag;
        int color;
        switch(value){
            case 1:
                color =  ContextCompat.getColor(getContext() , R.color.magnitude1);
                break;
            case 2:
                color = ContextCompat.getColor(getContext() , R.color.magnitude2);
                break;
            case 3:
                color = ContextCompat.getColor(getContext() , R.color.magnitude3);
                break;
            case 4:
                color = ContextCompat.getColor(getContext() , R.color.magnitude4);
                break;
            case 5:
                color = ContextCompat.getColor(getContext() , R.color.magnitude5);
                break;
            case 6:
                color = ContextCompat.getColor(getContext() , R.color.magnitude6);
                break;
            case 7:
                color = ContextCompat.getColor(getContext() , R.color.magnitude7);
                break;
            case 8:
                color = ContextCompat.getColor(getContext() , R.color.magnitude8);
                break;
            case 9:
                color = ContextCompat.getColor(getContext() , R.color.magnitude9);
                break;
            default:
                color =  ContextCompat.getColor(getContext() , R.color.magnitude10plus);
            break;
        }
        return color;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
