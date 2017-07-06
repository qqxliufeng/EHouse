package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoIntroduceFragment extends LroidBaseFragment{

    public static DecorateCompanyInfoIntroduceFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCompanyInfoIntroduceFragment fragment = new DecorateCompanyInfoIntroduceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_introduce_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void setComponent() {

    }
}
