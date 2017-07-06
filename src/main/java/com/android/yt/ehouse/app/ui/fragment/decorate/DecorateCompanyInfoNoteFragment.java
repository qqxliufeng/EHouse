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

public class DecorateCompanyInfoNoteFragment extends LroidBaseFragment{

    public static DecorateCompanyInfoNoteFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCompanyInfoNoteFragment fragment = new DecorateCompanyInfoNoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_iv_fragment_decorate_note_user_face)
    ImageView iv_face;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_note_layout;
    }

    @Override
    protected void initView(View view) {
        Glide.with(this).load(R.drawable.img_test_bg).bitmapTransform(new CropCircleTransformation(mContext)).into(iv_face);
    }

    @Override
    protected void setComponent() {

    }
}
