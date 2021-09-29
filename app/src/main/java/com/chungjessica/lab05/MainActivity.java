package com.chungjessica.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int countonCreate = 0;
    int countonStart = 0;
    int countonResume = 0;
    int countonPause = 0;
    int countonStop = 0;
    int countonRestart = 0;
    int countonDestroy = 0;

    TextView textrun;
    TextView textlifetime;

    SharedPreferences sh;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sh = getSharedPreferences("Values", MODE_PRIVATE);
        editor = sh.edit();

        setInitialValues();

        countonCreate++;
        storeValues();


    }

    private void storeValues(){
        editor.putInt("onCreate", countonCreate);
        editor.putInt("onStart", countonStart);
        editor.putInt("onResume", countonResume);
        editor.putInt("onPause", countonPause);
        editor.putInt("onStop", countonStop);
        editor.putInt("onRestart", countonRestart);
        editor.putInt("onDestroy", countonDestroy);
        editor.apply();
        System.out.println("Values onCreate:" + countonCreate);
        System.out.println("Values onStart:" + countonStart);
        System.out.println("Values onResume:" + countonResume);
        System.out.println("Values onPause:" + countonPause);
        System.out.println("Values onStop:" + countonStop);
        System.out.println("Values onRestart:" + countonRestart);
        System.out.println("Values onDestroy:" + countonDestroy);
        System.out.println("Values ************************");

        textrun = findViewById(R.id.textbox_run);
        textrun.setText(getString(R.string.countInRun, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        textlifetime = findViewById(R.id.textbox_lifetime);
        textlifetime.setText(getString(R.string.countInLifetime, sh.getInt("onCreate", 0),
                sh.getInt("onStart", 0), sh.getInt("onResume", 0),
                sh.getInt("onPause", 0), sh.getInt("onStop", 0),
                sh.getInt("onRestart", 0), sh.getInt("onDestroy", 0)));
    }
    private void erase(){
        editor.remove("Values").commit();
    }

    private void setInitialValues(){
        countonCreate = sh.getInt("onCreate", 0);
        countonStart = sh.getInt("onStart", 0);
        countonResume = sh.getInt("onResume", 0);
        countonPause = sh.getInt("onPause", 0);
        countonStop = sh.getInt("onStop", 0);
        countonRestart = sh.getInt("onRestart", 0);
        countonDestroy = sh.getInt("onDestroy", 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        storeValues();
    }
}