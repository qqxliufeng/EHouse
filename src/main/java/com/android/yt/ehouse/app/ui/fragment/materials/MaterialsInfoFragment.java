package com.android.yt.ehouse.app.ui.fragment.materials;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.fragment.base.WebContentFragment;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/8.
 */

public class MaterialsInfoFragment extends LroidBaseNetFragment implements AppBarLayout.OnOffsetChangedListener {


    public static final String FORMAT_DIALOG_FLAG = "formatDialog";
    public static final String PARAMETERS_DIALOG_FLAG = "parametersDialog";

    public static MaterialsInfoFragment newInstance() {
        Bundle args = new Bundle();
        MaterialsInfoFragment fragment = new MaterialsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_abl_materials_info_container)
    AppBarLayout al_container;
    @BindView(R.id.id_iv_fragment_materials_info_back)
    ImageView iv_back;
    @BindView(R.id.id_iv_fragment_materials_info_message)
    ImageView iv_message;
    @BindView(R.id.id_tv_fragment_materials_info_title)
    TextView tv_title;

    @BindView(R.id.id_tv_fragment_materials_info_old_price)
    TextView tv_old_price;

    private MaterialsInfoParametersDialogFragment parametersDialogFragment;
    private MaterialsInfoFormatDialogFragment formatDialogFragment;

    private WebContentFragment webContentFragment;
    private BannerFragment bannerFragment;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((FragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_materials_info_layout;
    }

    @Override
    protected void initView(View view) {
        al_container.addOnOffsetChangedListener(this);
        Bundle bundle = new Bundle();
        bundle.putString(WebContentFragment.WEB_LOAD_URL, "http://www.baidu.com");
//        webContentFragment = WebContentFragment.newInstance(bundle);
        bannerFragment = BannerFragment.newInstance();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_index_banner_layout, bannerFragment)
//                .replace(R.id.id_fl_fragment_materials_info_web_container, webContentFragment)
                .commit();
        tv_old_price.getPaint().setFlags(TextPaint.ANTI_ALIAS_FLAG | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @OnClick({R.id.id_ll_fragment_materials_info_guige,
            R.id.id_tv_fragment_materials_info_parameters})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_ll_fragment_materials_info_guige:
                if (formatDialogFragment == null) {
                    formatDialogFragment = new MaterialsInfoFormatDialogFragment();
                }
                formatDialogFragment.show(getChildFragmentManager(), FORMAT_DIALOG_FLAG);
                break;
            case R.id.id_tv_fragment_materials_info_parameters:
                if (parametersDialogFragment == null) {
                    parametersDialogFragment = new MaterialsInfoParametersDialogFragment();
                }
                parametersDialogFragment.show(getChildFragmentManager(), PARAMETERS_DIALOG_FLAG);
                break;
        }
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
