package com.android.yt.ehouse.app.component;

import com.android.yt.ehouse.app.presenter.GetDataFromNetPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by feng on 2017/6/15.
 */
@Module
public class PresenterModules {

    @Provides
    @ActivityScope
    public GetDataFromNetPresenter createPreseneter() {
        return new GetDataFromNetPresenter();
    }
}
