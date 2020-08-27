package com.example.onoff_test;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Test extends Application {
    private Long lastTime = 0L;
    private String lastClassName = null;
    private int lastEventType = 0;

    //@RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void run(){
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
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
                if (lastTime > 0 && lastClassName != null && lastEventType > 0 && lastEventType == 1 && lastClassName.equals(className)) { // 홈버튼, 중지버튼
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
    }
}
