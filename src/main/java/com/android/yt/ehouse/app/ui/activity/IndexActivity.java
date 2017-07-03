package com.android.yt.ehouse.app.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.ui.fragment.bottom.IndexFiveFragment;
import com.android.yt.ehouse.app.ui.fragment.bottom.IndexFourFragment;
import com.android.yt.ehouse.app.ui.fragment.bottom.IndexOneFragment;
import com.android.yt.ehouse.app.ui.fragment.bottom.IndexThreeFragment;
import com.android.yt.ehouse.app.ui.fragment.bottom.IndexTwoFragment;

import butterknife.BindView;

public class IndexActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    static final String[] INDEX_BOTTOM_TITLE = new String[]{"首页", "图库", "学装修", "论坛", "我的"};
    static final int[] INDEX_BOTTOM_IMGS = new int[]{R.drawable.img_index_bottom_one, R.drawable.img_index_bottom_two, R.drawable.img_index_bottom_three, R.drawable.img_index_bottom_four, R.drawable.img_index_bottom_five};

    @BindView(R.id.id_vp_activity_index_container)
    ViewPager mViewPager;

    @BindView(R.id.id_tl_activity_index_navigation)
    TabLayout mTabLayout;
    private long exitTime = 0L;

    @Override
    public int getLayoutId() {
        return R.layout.activity_index_layout;
    }

    @Override
    public void setPresentComponent() {
    }

    @Override
    public void initView() {
        setSwipeBackEnable(false);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setSelectedTabIndicatorHeight(0);
        mViewPager.setAdapter(new MyIndexViewPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(5);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(this);
        initTab();
    }

    private void initTab() {
        for (int i = 0; i < INDEX_BOTTOM_TITLE.length; i++) {
            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null) {
                View customBottomView = View.inflate(this, R.layout.layout_home_bottom_bar_item_layout, null);
                itemTab.setCustomView(customBottomView);
                ImageView iv_bottom = (ImageView) customBottomView.findViewById(R.id.id_iv_home_bottom_bar_img);
                TextView tv_bottom = (TextView) customBottomView.findViewById(R.id.id_tv_home_bottom_bar_title);
                tv_bottom.setText(INDEX_BOTTOM_TITLE[i]);
                iv_bottom.setImageResource(INDEX_BOTTOM_IMGS[i]);
                if (i == 0 && itemTab.getCustomView() != null) {
                    itemTab.getCustomView().setSelected(true);
                    iv_bottom.setColorFilter(ContextCompat.getColor(this, R.color.main_color));
                }
            }
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        for (int i = 0; i < INDEX_BOTTOM_TITLE.length; i++) {
            TabLayout.Tab mTab = mTabLayout.getTabAt(i);
            if (mTab != null) {
                ImageView iv = (ImageView) mTab.getCustomView().findViewById(R.id.id_iv_home_bottom_bar_img);
                if (tab.getPosition() == mTab.getPosition()) {
                    iv.setColorFilter(ContextCompat.getColor(this, R.color.main_color));
                } else {
                    iv.setColorFilter(ContextCompat.getColor(this, R.color.gray));
                }
            }
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private class MyIndexViewPagerAdapter extends FragmentStatePagerAdapter {

        public MyIndexViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return IndexOneFragment.newInstance();
                case 1:
                    return IndexTwoFragment.newInstance();
                case 2:
                    return IndexThreeFragment.newInstance();
                case 3:
                    return IndexFourFragment.newInstance();
                case 4:
                    return IndexFiveFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return INDEX_BOTTOM_TITLE.length;
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            exitTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出客户端", Toast.LENGTH_SHORT).show();
        } else {
            EHouseApplication.getInstance().onDestory();
            finish();
        }
    }
}
