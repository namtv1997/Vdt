package com.vpdt.vpdt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class App extends Application implements Application.ActivityLifecycleCallbacks {

    private static Context context;
    private static Context currentContext;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        App.context = getApplicationContext();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public static Context getAppContext() {
        return App.context;
    }

    public static Context getCurrentContext(){
        return App.currentContext;
    }

    public static void setCurrentContext(Context context){
        App.currentContext = context;
    }

}
