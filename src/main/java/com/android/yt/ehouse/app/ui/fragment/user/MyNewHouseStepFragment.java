package com.android.yt.ehouse.app.ui.fragment.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

/**
 * Created by feng on 2017/8/22.
 */

public class MyNewHouseStepFragment extends LroidBaseFragment{

    public static MyNewHouseStepFragment newInstance() {
        return new MyNewHouseStepFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity)mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_new_house_step_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void setComponent() {

    }
}
