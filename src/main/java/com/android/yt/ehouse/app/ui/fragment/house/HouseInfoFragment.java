package com.android.yt.ehouse.app.ui.fragment.house;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.HouseItemDetailInfoBean;
import com.android.yt.ehouse.app.data.bean.KtIndexBannerBean;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;
import com.android.yt.ehouse.app.utils.EncodeUtils;
import com.android.yt.ehouse.app.utils.MethodUtils;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/4.
 */

public class HouseInfoFragment extends LroidBaseNetFragment implements AppBarLayout.OnOffsetChangedListener {


    public static HouseInfoFragment newInstance(Bundle args) {
        HouseInfoFragment houseInfoFragment = new HouseInfoFragment();
        houseInfoFragment.setArguments(args);
        return houseInfoFragment;
    }

    @BindView(R.id.id_abl_house_info_container)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.id_iv_fragment_house_info_back)
    ImageView iv_back;
    @BindView(R.id.id_iv_fragment_house_info_message)
    ImageView iv_message;
    @BindView(R.id.id_tv_fragment_house_info_title)
    TextView tv_title;

    private BannerFragment bannerFragment;
    private HouseInfoVillageGeneralizeFragment houseInfoVillageGeneralizeFragment;
    private HouseInfoHouseGeneralizeFragment houseInfoHouseGeneralizeFragment;

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
        bannerFragment = BannerFragment.newInstance();
        houseInfoHouseGeneralizeFragment = HouseInfoHouseGeneralizeFragment.Companion.newInstance();
        houseInfoVillageGeneralizeFragment = HouseInfoVillageGeneralizeFragment.Companion.newInstance();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_index_banner_layout, bannerFragment)
                .replace(R.id.id_fl_fragment_house_info_house_generalize_container, houseInfoHouseGeneralizeFragment)
                .replace(R.id.id_fl_fragment_house_info_village_generalize_container, houseInfoVillageGeneralizeFragment)
                .commit();

        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_HOUSE.getHouseDetail(getArguments().getString(HouseHallFragment.HOUSE_ID_FLAG, "")));

    }

    @Override
    public void onRequestStart(int requestID) {
        super.onRequestStart(requestID);
        mProgressDialog = ProgressDialog.show(mContext, null, "正在加载详情……");
    }

    @Override
    public void onRequestEnd(int requestID) {
        super.onRequestEnd(requestID);
        mProgressDialog.dismiss();
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        parseData((HashMap<String, Object>) result);
    }

    private void parseData(HashMap<String, Object> result) {
        if (result != null && !result.isEmpty()) {
            HashMap<String, Object> infoMap = (HashMap<String, Object>) result.get("info");
            HouseItemDetailInfoBean.HouseItemDetailInfoForInfoBean houseInfo = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(infoMap), HouseItemDetailInfoBean.HouseItemDetailInfoForInfoBean.class);
            HashMap<String, Object> pic = (HashMap<String, Object>) infoMap.get("pic");
            int[] sortKey = MethodUtils.sortKeys(pic.keySet());
            ArrayList<KtIndexBannerBean> picBannerList = new ArrayList<>();
            for (int key : sortKey) {
                String value = (String) pic.get(Integer.toString(key));
                KtIndexBannerBean ktIndexBannerBean = new KtIndexBannerBean();
                ktIndexBannerBean.setUrl(value);
                picBannerList.add(ktIndexBannerBean);
            }

            bannerFragment.refresh(picBannerList);

            HashMap<String, Object> communityMap = (HashMap<String, Object>) result.get("community");
            HouseItemDetailInfoBean.HouseItemDetailInfoForCommunityBean communityBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(communityMap), HouseItemDetailInfoBean.HouseItemDetailInfoForCommunityBean.class);


            HashMap<String, Object> descriptionMap = (HashMap<String, Object>) result.get("description");
            HouseItemDetailInfoBean.HouseItemDetailInfoForCommunityBeanDescription descriptionBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(descriptionMap), HouseItemDetailInfoBean.HouseItemDetailInfoForCommunityBeanDescription.class);

            houseInfoHouseGeneralizeFragment.onRefresh(houseInfo, descriptionBean);
            houseInfoVillageGeneralizeFragment.onRefresh(communityBean);

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
