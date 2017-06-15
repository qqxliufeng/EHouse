package com.android.yt.ehouse.app.application;

import android.app.Application;

import com.android.yt.ehouse.app.component.AppComponent;
import com.android.yt.ehouse.app.component.AppModule;
import com.android.yt.ehouse.app.component.DaggerAppComponent;

/**
 * Created by feng on 2017/6/15.
 */

public class EHouseApplication extends Application {

    private static AppComponent appComponent;

    private static EHouseApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(instance)).build();
    }

    public static EHouseApplication getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
