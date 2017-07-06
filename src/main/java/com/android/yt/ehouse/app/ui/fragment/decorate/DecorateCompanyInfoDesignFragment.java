package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoDesignFragment extends LroidBaseFragment {

    public static DecorateCompanyInfoDesignFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCompanyInfoDesignFragment fragment = new DecorateCompanyInfoDesignFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_tv_fragment_decorate_company_info_design_all_design)
    TextView tv_all_design;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_design_layout;
    }

    @Override
    protected void initView(View view) {
        SpannableString spannableString = new SpannableString("全部34个");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.main_color)),
                2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_all_design.setText(spannableString);
    }

    @Override
    protected void setComponent() {
    }
}
