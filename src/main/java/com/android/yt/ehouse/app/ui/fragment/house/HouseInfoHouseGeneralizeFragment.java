package com.android.yt.ehouse.app.ui.fragment.house;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

/**
 * Created by feng on 2017/7/4.
 */

public class HouseInfoHouseGeneralizeFragment extends LroidBaseFragment{

    public static HouseInfoHouseGeneralizeFragment newInstance() {
        Bundle args = new Bundle();
        HouseInfoHouseGeneralizeFragment fragment = new HouseInfoHouseGeneralizeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_house_info_house_generalize_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void setComponent() {

    }
}
