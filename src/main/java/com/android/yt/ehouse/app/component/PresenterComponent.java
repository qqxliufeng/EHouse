package com.android.yt.ehouse.app.component;

import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by feng on 2017/6/15.
 */

@ActivityScope
@Component(modules = {PresenterModules.class},dependencies = AppComponent.class)
public interface PresenterComponent {

    void inject(LroidBaseNetFragment baseNetFragment);

}
