package com.android.yt.ehouse.app.component;

import com.android.yt.ehouse.app.presenter.BasePresenter;
import com.android.yt.ehouse.app.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by feng on 2017/6/15.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(BaseActivity baseActivity);

    void inject(BasePresenter basePresenter);

}
