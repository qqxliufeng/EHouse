package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseInfoFragment extends LroidBaseNetFragment {

    public static DecorateCaseInfoFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCaseInfoFragment fragment = new DecorateCaseInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_tl_fragment_decorate_case_title)
    TabLayout tl_title;
    @BindView(R.id.id_vp_fragment_decorate_case_container)
    ViewPager vp_container;
    @BindView(R.id.id_iv_fragment_decorate_case_info_sjs_face)
    ImageView iv_sjs_face;
    @BindView(R.id.id_iv_fragment_decorate_case_info_gz_face)
    ImageView iv_gz_face;
    @BindView(R.id.id_iv_fragment_decorate_case_info_zj_face)
    ImageView iv_zj_face;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_case_info_layout;
    }

    @Override
    protected void initView(View view) {
        GlideManager.loadCircleImage(this,R.drawable.img_test_bg,iv_sjs_face);
        GlideManager.loadCircleImage(this,R.drawable.img_test_bg,iv_gz_face);
        GlideManager.loadCircleImage(this,R.drawable.img_test_bg,iv_zj_face);

        vp_container.setAdapter(new DecorateCaseViewPagerAdapter(getChildFragmentManager()));
        tl_title.setupWithViewPager(vp_container);
    }

    static class DecorateCaseViewPagerAdapter extends FragmentStatePagerAdapter {

        private String[] TITLE = new String[]{"设计方案", "质检记录", "材料清单"};

        public DecorateCaseViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return DecorateCaseInfoForDesignPlanFragment.newInstance();
                case 1:
                    return DecorateCaseInfoForQualityFragment.newInstance();
                default:
                    return DecorateCaseInfoForMaterialListFragment.newInstance();
            }
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
