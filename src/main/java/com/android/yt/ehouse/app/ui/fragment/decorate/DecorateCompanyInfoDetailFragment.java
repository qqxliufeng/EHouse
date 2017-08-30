package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.OnClick;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoDetailFragment extends LroidBaseFragment {

    public static DecorateCompanyInfoDetailFragment newInstance(String orgId) {
        DecorateCompanyInfoDetailFragment decorateCompanyInfoDetailFragment = new DecorateCompanyInfoDetailFragment();
        Bundle args = new Bundle();
        args.putString(DecorateCompanyInfoFragment.ORG_ID, orgId);
        decorateCompanyInfoDetailFragment.setArguments(args);
        return decorateCompanyInfoDetailFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_detail_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void setComponent() {
    }

    @OnClick({R.id.id_tv_fragment_decorate_company_info_jiajie, R.id.id_tv_fragment_decorate_company_info_gongshang, R.id.id_tv_fragment_decorate_company_info_zhengshu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tv_fragment_decorate_company_info_jiajie:
                Bundle introduceBundle = new Bundle();
                introduceBundle.putString(DecorateCompanyInfoForIntroduceAndBusinessFragment.ORG_ID_FLAG, getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""));
                introduceBundle.putString(DecorateCompanyInfoForIntroduceAndBusinessFragment.ACTION_FLAG, "intro");
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "公司简介", KtFragmentContainerActivity.Companion.getDECORATE_COMPANY_INFO_INTRODUCE_AND_BUSINESS_FLAG(), introduceBundle);
                break;
            case R.id.id_tv_fragment_decorate_company_info_zhengshu:
                Bundle certificateBundle = new Bundle();
                certificateBundle.putString(DecorateCompanyInfoFragment.ORG_ID, getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""));
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "企业证书", KtFragmentContainerActivity.Companion.getDECORATE_COMPANY_INFO_CERTIFICATE_FLAG(), certificateBundle);
                break;
            case R.id.id_tv_fragment_decorate_company_info_gongshang:
                Bundle businessBundle = new Bundle();
                businessBundle.putString(DecorateCompanyInfoForIntroduceAndBusinessFragment.ORG_ID_FLAG, getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""));
                businessBundle.putString(DecorateCompanyInfoForIntroduceAndBusinessFragment.ACTION_FLAG, "business");
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "工商注册信息", KtFragmentContainerActivity.Companion.getDECORATE_COMPANY_INFO_INTRODUCE_AND_BUSINESS_FLAG(), businessBundle);
                break;
        }
    }
}
