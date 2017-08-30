package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyCommentBean;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.view.RoundedNoNetImageView;
import com.android.yt.ehouse.app.utils.GlideManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoCommentFragment extends LroidBaseFragment {

    public static DecorateCompanyInfoCommentFragment newInstance(String orgId) {
        Bundle args = new Bundle();
        args.putString(DecorateCompanyInfoFragment.ORG_ID,orgId);
        DecorateCompanyInfoCommentFragment fragment = new DecorateCompanyInfoCommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_tv_fragment_decorate_company_info_comment_all_count)
    TextView tv_count;
    @BindView(R.id.id_tv_fragment_decorate_company_info_comment_time)
    TextView tv_time;
    @BindView(R.id.id_tv_fragment_decorate_company_info_comment_user_name)
    TextView tv_name;
    @BindView(R.id.id_tv_fragment_decorate_company_info_comment_content)
    TextView tv_content;
    @BindView(R.id.id_rb_fragment_decorate_company_info_comment_design_score)
    RatingBar rb_design_score;
    @BindView(R.id.id_rb_fragment_decorate_company_info_comment_service_score)
    RatingBar rb_service_score;
    @BindView(R.id.id_rb_fragment_decorate_company_info_comment_work_score)
    RatingBar rb_work_score;


    @BindView(R.id.id_iv_fragment_decorate_comment_user_face)
    RoundedNoNetImageView iv_face;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_comment_layout;
    }

    @Override
    protected void initView(View view) {
        iv_face.setOval(true);
    }

    @Override
    protected void setComponent() {
    }

    @OnClick(R.id.id_tv_fragment_decorate_company_info_comment_all_count)
    public void onClick() {
        KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "业主评价", KtFragmentContainerActivity.Companion.getDECORATE_COMPANY_COMMENT_LIST_FRAGMENT_FLAG(), getArguments());
    }

    public void refresh(DecorateCompanyCommentBean decorateCompanyCommentBean) {
        String count = decorateCompanyCommentBean.getCount();
        SpannableString spannableString = new SpannableString("全部" + (TextUtils.isEmpty(count) ? "0" : count) + "条");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.main_color)),2, 2 + count.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_count.setText(spannableString);

        tv_content.setText(decorateCompanyCommentBean.getContent());
        tv_name.setText(decorateCompanyCommentBean.getNickname());
        tv_time.setText(decorateCompanyCommentBean.getTime());
        String designScore = decorateCompanyCommentBean.getGoods_score();
        String serviceScore = decorateCompanyCommentBean.getService_score();
        float designScoreFloat = Float.parseFloat(designScore);
        float serviceScoreFloat = Float.parseFloat(serviceScore);
        rb_design_score.setRating(designScoreFloat);
        rb_work_score.setRating(designScoreFloat);
        rb_service_score.setRating(serviceScoreFloat);
        GlideManager.loadImage(this, decorateCompanyCommentBean.getAvatarUrl(), iv_face);
    }
}
