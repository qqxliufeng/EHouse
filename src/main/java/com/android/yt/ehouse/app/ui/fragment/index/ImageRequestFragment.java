package com.android.yt.ehouse.app.ui.fragment.index;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.bumptech.glide.Glide;

import butterknife.BindView;

/**
 * Created by feng on 2016/9/5.
 */

public class ImageRequestFragment extends LroidBaseFragment {

    public static final String IMAGE_URL_FLAG = "image_url_flag";
    public static final String IS_FIRST_FLAG = "is_first_flag";

    public static ImageRequestFragment newInstance(String imageUrl, boolean isFirst) {
        Bundle args = new Bundle();
        args.putString(IMAGE_URL_FLAG, imageUrl);
        args.putBoolean(IS_FIRST_FLAG, isFirst);
        ImageRequestFragment fragment = new ImageRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_niv_fragment_image_request)
    ImageView niv_image;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image_request_layout;
    }

    @Override
    protected void initView(View view) {
        Glide.with(this)
                .load(getArguments().getString(IMAGE_URL_FLAG))
                .placeholder(R.drawable.img_banner_default_img)
                .error(R.drawable.img_banner_default_img)
                .into(niv_image);
    }

    @Override
    protected void setComponent() {
    }

    @Override
    public void onClick(View view) {
    }
}
