package com.android.yt.ehouse.app.ui.fragment.house;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

/**
 * Created by feng on 2017/7/4.
 */

public class HouseInfoVillageGeneralizeFragment extends LroidBaseFragment{

    public static HouseInfoVillageGeneralizeFragment newInstance() {
        Bundle args = new Bundle();

        HouseInfoVillageGeneralizeFragment fragment = new HouseInfoVillageGeneralizeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_house_info_village_generalize_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void setComponent() {

    }
}
