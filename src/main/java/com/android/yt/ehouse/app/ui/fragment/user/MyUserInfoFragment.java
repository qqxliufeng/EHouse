package com.android.yt.ehouse.app.ui.fragment.user;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/8/22.
 */

public class MyUserInfoFragment extends LroidBaseNetFragment{

    public static MyUserInfoFragment newInstance() {
        return new MyUserInfoFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save_info_menu,menu);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_user_info_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @OnClick(R.id.id_rl_fragment_my_user_info_address)
    public void onAddress(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"收货地址",FragmentContainerActivity.MY_INFO_ADDRESS_FLAG);
    }


}
