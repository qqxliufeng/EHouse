package com.android.yt.ehouse.app.ui.fragment.index;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

/**
 * Created by feng on 2017/6/15.
 */

public class MallSpecialFragment extends LroidBaseNetFragment{

    public static MallSpecialFragment newInstance() {
        return new MallSpecialFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_mall_special_layout;
    }

    @Override
    protected void initView(View view) {
    }
}
