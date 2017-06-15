package com.android.yt.ehouse.app.ui.fragment.base;


import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.component.DaggerPresenterComponent;
import com.android.yt.ehouse.app.component.PresenterModules;
import com.android.yt.ehouse.app.presenter.GetDataFromNetPresenter;

import javax.inject.Inject;

/**
 * Created by feng on 2017/1/4.
 */

public abstract class LroidBaseNetFragment extends LroidBaseFragment {

    @Inject
    protected GetDataFromNetPresenter mGetDataFromNetPresenter;


    @Override
    protected void setComponent() {
        DaggerPresenterComponent.builder().appComponent(EHouseApplication.getAppComponent()).presenterModules(new PresenterModules()).build().inject(this);
        mGetDataFromNetPresenter.setFragment(this);
    }

    @Override
    public void onDestroy() {
        if (mGetDataFromNetPresenter != null) {
            mGetDataFromNetPresenter.unSubscribeOn();
        }
        super.onDestroy();
    }
}
