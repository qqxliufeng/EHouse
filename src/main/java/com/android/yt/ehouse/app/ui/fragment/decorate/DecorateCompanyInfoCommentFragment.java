package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoCommentFragment extends LroidBaseFragment{

    public static DecorateCompanyInfoCommentFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCompanyInfoCommentFragment fragment = new DecorateCompanyInfoCommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_iv_fragment_decorate_comment_user_face)
    ImageView iv_face;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_comment_layout;
    }

    @Override
    protected void initView(View view) {
        Glide.with(this).load(R.drawable.img_test_bg).bitmapTransform(new CropCircleTransformation(mContext)).into(iv_face);
    }

    @Override
    protected void setComponent() {
    }
}
