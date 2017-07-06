package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoDetailFragment extends LroidBaseFragment{

    public static DecorateCompanyInfoDetailFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCompanyInfoDetailFragment fragment = new DecorateCompanyInfoDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_detail_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void setComponent() {

    }
}
