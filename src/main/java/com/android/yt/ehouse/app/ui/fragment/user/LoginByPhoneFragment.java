package com.android.yt.ehouse.app.ui.fragment.user;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import butterknife.OnClick;

/**
 * Created by feng on 2017/7/26.
 */

public class LoginByPhoneFragment extends LroidBaseNetFragment{

    public static LoginByPhoneFragment newInstance() {
        return new LoginByPhoneFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_by_code_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @OnClick(R.id.id_tv_fragment_login_register)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.id_tv_fragment_login_register:
                FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.REGISTER_FLAG);
                break;
        }
    }

}
