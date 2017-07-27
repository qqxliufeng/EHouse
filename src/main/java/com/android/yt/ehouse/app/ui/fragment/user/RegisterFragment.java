package com.android.yt.ehouse.app.ui.fragment.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import butterknife.OnClick;

/**
 * Created by feng on 2017/7/26.
 */

public class RegisterFragment extends LroidBaseNetFragment{

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((FragmentContainerActivity)mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @OnClick(R.id.id_tv_fragment_register_to_login)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_tv_fragment_register_to_login:
                finishActivity();
                break;
        }
    }
}
