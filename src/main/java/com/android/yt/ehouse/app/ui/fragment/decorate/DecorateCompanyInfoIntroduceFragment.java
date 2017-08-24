package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.utils.GlideManager;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoIntroduceFragment extends LroidBaseFragment {

    public static DecorateCompanyInfoIntroduceFragment newInstance(DecorateCompanyBean decorateCompanyBean) {
        Bundle args = new Bundle();
        args.putParcelable(DecorateCompanyInfoFragment.ORG_ID, decorateCompanyBean);
        DecorateCompanyInfoIntroduceFragment fragment = new DecorateCompanyInfoIntroduceFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @BindView(R.id.id_tv_fragment_decorate_company_info_base_name)
    TextView tv_name;
    @BindView(R.id.id_tv_fragment_decorate_company_info_base_koubei)
    TextView tv_koubei;
    @BindView(R.id.id_tv_fragment_decorate_company_info_base_pcount)
    TextView tv_pcount;
    @BindView(R.id.id_tv_fragment_decorate_company_info_base_address)
    TextView tv_address;
    @BindView(R.id.id_iv_fragment_decorate_company_info_base_image)
    ImageView iv_image;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_introduce_layout;
    }

    @Override
    protected void initView(View view) {
        DecorateCompanyBean decorateCompanyBean = getArguments().getParcelable(DecorateCompanyInfoFragment.ORG_ID);
        if (decorateCompanyBean != null) {
            tv_name.setText(decorateCompanyBean.getOrg_name());
            tv_address.setText(decorateCompanyBean.getOrg_addr());
            tv_pcount.setText(decorateCompanyBean.getPcount());
            tv_koubei.setText(decorateCompanyBean.getKoubei());
            GlideManager.loadImage(mContext, decorateCompanyBean.getOrg_thumb(), iv_image);
        }
    }

    @Override
    protected void setComponent() {
    }
}
