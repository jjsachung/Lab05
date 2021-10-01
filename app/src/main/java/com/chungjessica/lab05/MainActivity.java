package com.chungjessica.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int countonCreate = 0;
    int countonStart = 0;
    int countonResume = 0;
    int countonPause = 0;
    int countonStop = 0;
    int countonRestart = 0;
    int countonDestroy = 0;

    int countonCreateRun = 0;
    int countonStartRun = 0;
    int countonResumeRun = 0;
    int countonPauseRun = 0;
    int countonStopRun = 0;
    int countonRestartRun = 0;
    int countonDestroyRun = 0;

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
        countonCreateRun++;
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

        textrun = findViewById(R.id.textbox_run);
        textrun.setText(getString(R.string.countInRun, countonCreateRun, countonStartRun,
                countonResumeRun, countonPauseRun, countonStopRun, countonRestartRun,
                countonDestroyRun));
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
        countonCreateRun = 0;
        countonStartRun = 0;
        countonResumeRun = 0;
        countonPauseRun = 0;
        countonStopRun = 0;
        countonRestartRun = 0;
        countonDestroyRun = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        countonStartRun++;
        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        countonResumeRun++;
        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        countonPauseRun++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        countonStopRun++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        countonRestartRun++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        countonDestroyRun++;
        storeValues();
    }

    public void reset(View view) {
        countonCreate = 0;
        countonStart = 0;
        countonResume = 0;
        countonPause = 0;
        countonStop = 0;
        countonRestart = 0;
        countonDestroy = 0;
        countonCreateRun = 0;
        countonStartRun = 0;
        countonResumeRun = 0;
        countonPauseRun = 0;
        countonStopRun = 0;
        countonRestartRun = 0;
        countonDestroyRun = 0;
        storeValues();
    }
}