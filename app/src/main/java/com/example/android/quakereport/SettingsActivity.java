package com.example.android.quakereport;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    Spinner mOrderBy;
    EditText mDays , mMag;
    Button mSave;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        prefs = getSharedPreferences("com.example.android.quakereport" , MODE_PRIVATE);
        mOrderBy = (Spinner)findViewById(R.id.orderbySpinner);
        mDays = (EditText)findViewById(R.id.editTextDays);
        mMag = (EditText)findViewById(R.id.editTextMag);
        mOrderBy.setSelection(prefs.getInt("orderby" , 0));
        mDays.setText(""+prefs.getInt("days" , 30));
        mMag.setText(""+prefs.getInt("minmag" , 3));
        mSave = (Button)findViewById(R.id.buttonSave);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                 editor.putInt("orderby" , (int)mOrderBy.getSelectedItemPosition());
                 editor.putInt("minmag" , Integer.parseInt(mMag.getText().toString()));
                editor.putInt("days" , Integer.parseInt(mDays.getText().toString()));
                editor.commit();
                finish();
            }
        });
    }
}
