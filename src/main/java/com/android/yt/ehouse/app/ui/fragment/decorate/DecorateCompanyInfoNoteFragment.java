package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyNoteBean;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.view.RoundedNoNetImageView;
import com.android.yt.ehouse.app.utils.GlideManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoNoteFragment extends LroidBaseFragment {

    public static DecorateCompanyInfoNoteFragment newInstance(String orgId) {
        Bundle args = new Bundle();
        args.putString(DecorateCompanyInfoFragment.ORG_ID, orgId);
        DecorateCompanyInfoNoteFragment fragment = new DecorateCompanyInfoNoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_tv_fragment_decorate_company_info_note_all_count)
    TextView tv_count;
    @BindView(R.id.id_tv_fragment_decorate_company_info_note_user_name)
    TextView tv_user_name;
    @BindView(R.id.id_tv_fragment_decorate_company_info_note_tag)
    TextView tv_tag;
    @BindView(R.id.id_tv_fragment_decorate_company_info_note_style)
    TextView tv_style;
    @BindView(R.id.id_tv_fragment_decorate_company_info_note_content)
    TextView tv_content;
    @BindView(R.id.id_iv_fragment_decorate_note_user_face)
    RoundedNoNetImageView iv_face;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_note_layout;
    }

    @Override
    protected void initView(View view) {
        iv_face.setOval(true);
    }

    @Override
    protected void setComponent() {
    }

    @OnClick(R.id.id_tv_fragment_decorate_company_info_note_all_count)
    public void onClick() {
        FragmentContainerActivity.startFragmentsActivity(mContext, "业主日记", FragmentContainerActivity.DECORATE_COMPANY_NOTE_LIST_FRAGMENT_FLAG, getArguments());
    }

    public void refresh(DecorateCompanyNoteBean decorateCompanyNoteBean) {
        String count = decorateCompanyNoteBean.getCount();
        SpannableString spannableString = new SpannableString("全部" + (TextUtils.isEmpty(count) ? "0" : count) + "篇");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.main_color)), 2, 2 + count.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_count.setText(spannableString);
        String content = decorateCompanyNoteBean.getDecorateCompanyNoteInfoBean().getContent();
        tv_content.setText(TextUtils.isEmpty(content) ? "暂无" : content);
        String area = decorateCompanyNoteBean.getArea();
        String styleStr = decorateCompanyNoteBean.getDecoration_style_str();
        tv_style.setText((TextUtils.isEmpty(area) ? "暂无" : area) + "/" + (TextUtils.isEmpty(styleStr) ? "暂无" : styleStr));
        String tag = decorateCompanyNoteBean.getTag();
        tv_tag.setText(TextUtils.isEmpty(tag) ? "暂无" : tag);
        String nickname = decorateCompanyNoteBean.getDecorateCompanyNoteUserInfoBean().getNickname();
        tv_user_name.setText(TextUtils.isEmpty(nickname) ? "暂无" : nickname);
        GlideManager.loadImage(this, decorateCompanyNoteBean.getDecorateCompanyNoteUserInfoBean().getAvatar_file(), iv_face);
    }
}
