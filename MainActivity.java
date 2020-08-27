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



/*
private Long      lastTime = 0L;
    private String    lastClassName = null;
    private int       lastEventType = 0;

@RequiresApi(api = Build.VERSION_CODES.Q)
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Application.registerActivityLifecycleCallbacks (new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {
            long time = System.currentTimeMillis();
            String className = activity.getComponentName().getClassName();
            Log.i("ActivityLifecycle", Long.toString(time) + "," + className);
        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {
            long activeTime = 0L;
            long time = System.currentTimeMillis();
            String className = activity.getComponentName().getClassName(); // 액티비티 이름을 받음
            if(lastTime > 0 && lastClassName != null && lastEventType > 0 && lastEventType == 1 && lastClassName.equals(className)){ // 홈버튼, 중지버튼
                activeTime = time - lastTime;
            }
            Log.i("ActivityLifecycle", Long.toString(time) + "," + className + "," + Long.toString(activeTime));
        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    });
 */
