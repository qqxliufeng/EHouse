package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDesignBean;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.utils.GlideManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoDesignFragment extends LroidBaseFragment {

    public static DecorateCompanyInfoDesignFragment newInstance(String orgId) {
        Bundle args = new Bundle();
        args.putString(DecorateCompanyInfoFragment.ORG_ID,orgId);
        DecorateCompanyInfoDesignFragment fragment = new DecorateCompanyInfoDesignFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_tv_fragment_decorate_company_info_design_all_design)
    TextView tv_all_design;
    @BindView(R.id.id_tv_fragment_decorate_company_info_design_name)
    TextView tv_name;
    @BindView(R.id.id_tv_fragment_decorate_company_info_design_desc)
    TextView tv_desc;
    @BindView(R.id.id_iv_fragment_decorate_company_info_design_image)
    ImageView iv_image;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_design_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void setComponent() {
    }

    @OnClick(R.id.id_tv_fragment_decorate_company_info_design_all_design)
    public void onClick(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"全部设计方案",FragmentContainerActivity.DECORATE_COMPANY_DESIGN_LIST_FRAGMENT_FLAG,getArguments());
    }

    public void refresh(DecorateCompanyDesignBean decorateCompanyDesignBean) {
        String count = decorateCompanyDesignBean.getCount();
        SpannableString spannableString = new SpannableString("全部" + (TextUtils.isEmpty(count) ? "0" : count) + "篇");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.main_color)),
                2, 2 + count.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_all_design.setText(spannableString);
        tv_name.setText(decorateCompanyDesignBean.getName());
        GlideManager.loadImage(mContext, decorateCompanyDesignBean.getThumb(), R.drawable.img_banner_default_img, R.drawable.img_banner_default_img, iv_image);
        tv_desc.setText(decorateCompanyDesignBean.getStr());
    }
}
