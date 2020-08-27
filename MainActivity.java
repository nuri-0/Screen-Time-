package com.example.onoff_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
    intentFilter.addAction(Intent.ACTION_SCREEN_ON);

    BroadcastReceiver screenOnOff = new BroadcastReceiver() {
        public static final String ScreenOff = "android.intent.action.SCREEN_OFF";
        public static final String ScreenOn = "android.intent.action.SCREEN_ON";
        long startTime  = 0L;
        long endTime    = 0L;
        long runningTime = 0L;

        TextView TextView = (TextView) findViewById(R.id.run_time);
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                Toast toast = Toast.makeText(context, "Screen off.",Toast.LENGTH_LONG);
                endTime = System.currentTimeMillis();
                runningTime = endTime - startTime;
                toast.show();

            } else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                startTime =  System.currentTimeMillis();
                Toast toast = Toast.makeText(context,"Screen on.", Toast.LENGTH_LONG);
                //TextView.setText("Time calculate");
                TextView.setText(Long.toString(runningTime));
                toast.show();

            }

        }
    };
}
}
