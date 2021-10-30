package com.example.kazim.mohaqeqkabuli;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.webkit.WebSettings;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    public static SeekBar seekbar;
    public TextView edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        seekbar = (SeekBar) findViewById(R.id.seekBar1);
        edittext = (TextView) findViewById(R.id.textView1);

        prefs = getPreferences(MODE_PRIVATE);
        float fs = prefs.getFloat("fontsize", 16);
        seekbar.setProgress((int) fs);
        edittext.setTextSize(TypedValue.COMPLEX_UNIT_PX,seekbar.getProgress());


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
                prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();
                ed.putFloat("fontsize", edittext.getTextSize());
                ed.commit();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser){

                edittext.setTextSize(TypedValue.COMPLEX_UNIT_PX,seekbar.getProgress());
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity(1);
    }
}

