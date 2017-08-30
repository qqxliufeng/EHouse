package com.android.yt.ehouse.app.ui.fragment.index;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.KtIndexBannerBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.view.AutoScrollViewPager;
import com.android.yt.ehouse.app.ui.view.IndicatorView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by feng on 2017/6/15.
 */

public class BannerFragment extends LroidBaseFragment implements ViewPager.OnPageChangeListener {

    public static BannerFragment newInstance() {
        return new BannerFragment();
    }

    @BindView(R.id.id_vp_fragment_index_banner)
    AutoScrollViewPager vp_banner;

    @BindView(R.id.id_ll_fragment_index_indicator)
    LinearLayout mIndicatorContainer;

    private BannerViewPagerAdapter bannerAdapter;
    private ArrayList<String> imageUrlList = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_banner_layout;
    }

    @Override
    protected void initView(View view) {
        bannerAdapter = new BannerViewPagerAdapter(getChildFragmentManager());
        vp_banner.setCycle(true);
        vp_banner.setDirection(AutoScrollViewPager.RIGHT);
        vp_banner.setInterval(5000);
        vp_banner.setScrollDurationFactor(4.0);
        vp_banner.startAutoScroll();
        vp_banner.addOnPageChangeListener(this);
        vp_banner.setOffscreenPageLimit(3);
    }

    @Override
    protected void setComponent() {
    }

    private void initIndicator() {
        for (int i = 0; i < imageUrlList.size(); i++) {
            IndicatorView indicatorView = new IndicatorView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6, getResources().getDisplayMetrics()));
            params.leftMargin = 10;
            params.rightMargin = 10;
            indicatorView.setLayoutParams(params);
            indicatorView.setDefaultIndicatorColor(Color.WHITE);
            indicatorView.setFocusedIndicatorColor(ContextCompat.getColor(mContext, R.color.blue));
            mIndicatorContainer.addView(indicatorView, i);
            if (i == 0) {
                indicatorView.setSelect(true);
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        int count = mIndicatorContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            if (position % count == i) {
                ((IndicatorView) mIndicatorContainer.getChildAt(i)).setSelect(true);
            } else {
                ((IndicatorView) mIndicatorContainer.getChildAt(i)).setSelect(false);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!vp_banner.isAutoScroll()) {
            vp_banner.startAutoScroll();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        vp_banner.stopAutoScroll();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void refresh(ArrayList<KtIndexBannerBean> tempList) {
        for (KtIndexBannerBean indexBanner : tempList) {
            imageUrlList.add(indexBanner.getUrl());
        }
        vp_banner.setAdapter(bannerAdapter);
        initIndicator();
    }

    private class BannerViewPagerAdapter extends FragmentStatePagerAdapter {

        public BannerViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ImageRequestFragment.newInstance(imageUrlList.get(position % imageUrlList.size()), position == 0);
        }

        @Override
        public int getCount() {
            if (imageUrlList.size() == 1) {
                return 1;
            }
            return Integer.MAX_VALUE;
        }
    }
}
