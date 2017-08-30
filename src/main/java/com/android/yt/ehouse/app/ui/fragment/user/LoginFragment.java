package com.android.yt.ehouse.app.ui.fragment.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/26.
 */

public class LoginFragment extends LroidBaseFragment {

    static final String[] TITLE = {"快速登录", "帐号登录"};

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @BindView(R.id.id_tl_fragment_login_container_title)
    TabLayout tl_title;
    @BindView(R.id.id_vp_fragment_login_container_content)
    ViewPager vp_content;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_container_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected void initView(View view) {
        vp_content.setAdapter(new LoginViewPagerAdapter(getChildFragmentManager()));
        tl_title.setupWithViewPager(vp_content);
    }

    @Override
    protected void setComponent() {
    }

    static class LoginViewPagerAdapter extends FragmentStatePagerAdapter {

        public LoginViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return position == 0 ? LoginByPhoneFragment.newInstance() : LoginByPasswordFragment.newInstance();
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position];
        }
    }

}
