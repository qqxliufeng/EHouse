package com.android.yt.ehouse.app.ui.fragment.house;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/4.
 */

public class HouseInfoFragment extends LroidBaseNetFragment implements AppBarLayout.OnOffsetChangedListener {

    public static HouseInfoFragment newInstance() {
        return new HouseInfoFragment();
    }

    @BindView(R.id.id_abl_house_info_container)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.id_iv_fragment_house_info_back)
    ImageView iv_back;
    @BindView(R.id.id_iv_fragment_house_info_message)
    ImageView iv_message;
    @BindView(R.id.id_tv_fragment_house_info_title)
    TextView tv_title;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_house_info_layout;
    }

    @Override
    protected void initView(View view) {
        mAppBarLayout.addOnOffsetChangedListener(this);
        iv_back.setColorFilter(Color.WHITE);
        iv_message.setColorFilter(Color.WHITE);
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_index_banner_layout, BannerFragment.newInstance())
                .replace(R.id.id_fl_fragment_house_info_house_generalize_container, HouseInfoHouseGeneralizeFragment.newInstance())
                .replace(R.id.id_fl_fragment_house_info_village_generalize_container, HouseInfoVillageGeneralizeFragment.newInstance())
                .commit();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float factor = (float) Math.abs(verticalOffset) / (float) appBarLayout.getTotalScrollRange();
        setImageBack(factor, iv_back);
        setImageBack(factor, iv_message);
        tv_title.setAlpha(factor);
    }

    private void setImageBack(float factor, ImageView imageView) {
        GradientDrawable gradientDrawable = (GradientDrawable) imageView.getBackground();
        int alpha = (int) (factor * 255);
        gradientDrawable.setAlpha(255 - alpha);
        if (alpha == 255) {
            imageView.setColorFilter(Color.parseColor("#444444"));
        }
        if (alpha == 0) {
            imageView.setColorFilter(Color.WHITE);
        }
    }
}
