package com.android.yt.ehouse.app.application;

import android.app.Application;

import com.android.yt.ehouse.app.component.AppComponent;
import com.android.yt.ehouse.app.component.AppModule;
import com.android.yt.ehouse.app.component.DaggerAppComponent;
import com.android.yt.ehouse.app.interfaces.OnClassifySearchContentClickListener;

/**
 * Created by feng on 2017/6/15.
 */

public class EHouseApplication extends Application {

    private static AppComponent appComponent;

    private static EHouseApplication instance = null;
    private OnClassifySearchContentClickListener onClassifySearchContentClickListener;

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

    public void setOnClassifySearchContentClickListener(OnClassifySearchContentClickListener onClassifySearchContentClickListener) {
        this.onClassifySearchContentClickListener = onClassifySearchContentClickListener;
    }

    public OnClassifySearchContentClickListener getOnClassifySearchContentClickListener() {
        return onClassifySearchContentClickListener;
    }

    public void onDestory() {
        onClassifySearchContentClickListener = null;
        instance = null;
        appComponent = null;
    }


}
