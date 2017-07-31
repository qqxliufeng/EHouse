package com.android.yt.ehouse.app.ui.fragment.bbs;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

/**
 * Created by feng on 2017/7/31.
 */

public class BBSCreateFragment extends LroidBaseNetFragment{

    public static BBSCreateFragment newInstance() {
        return new BBSCreateFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bbs_create_layout;
    }

    @Override
    protected void initView(View view) {

    }
}
