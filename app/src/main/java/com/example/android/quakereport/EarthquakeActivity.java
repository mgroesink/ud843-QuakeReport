/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        try {
            earthquakes.add(new Earthquake("San Francisco", 7.2, formatter.parse("02-feb-2016")));
            earthquakes.add(new Earthquake("Tokyo", 3.9, formatter.parse("02-feb-2016")));
            earthquakes.add(new Earthquake("Mexico City", 5.4, formatter.parse("02-feb-2016")));
            earthquakes.add(new Earthquake("Moscow", 2.8, formatter.parse("02-feb-2016")));
            earthquakes.add(new Earthquake("Rio de Janeiro", 4.9, formatter.parse("02-feb-2016")));
            earthquakes.add(new Earthquake("Paris", 1.6, formatter.parse("02-feb-2016")));
            earthquakes.add(new Earthquake("London", 6.1, formatter.parse("02-feb-2016")));

        } catch (Exception ex){

            Log.e("RSK01.Earthquake" , "Error creating earthquake data");
        }

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        ArrayAdapter<String> adapter = new EarthquakeAdaper(getApplicationContext(), earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
