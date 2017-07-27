package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.fragment.user.LoginByPasswordFragment;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/27.
 */

public class DecorateFengShuiFragment extends LroidBaseFragment{

    public static DecorateFengShuiFragment newInstance() {
        return new DecorateFengShuiFragment();
    }

    static final String[] TITLE = {"卧室风水","客厅风水","厨房风水","卫生间风水","餐厅风水"};


    @BindView(R.id.id_tl_fragment_decorate_feng_shui_title)
    TabLayout tb_title;
    @BindView(R.id.id_vp_fragment_decorate_feng_shui_content)
    ViewPager vp_content;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_fengshui_layout;
    }

    @Override
    protected void initView(View view) {
        vp_content.setAdapter(new FengShuiFragmentAdapter(getChildFragmentManager()));
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void setComponent() {
    }

    static class FengShuiFragmentAdapter extends FragmentStatePagerAdapter{

        public FengShuiFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DecorateArticleItemFragment.newInstance();
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
