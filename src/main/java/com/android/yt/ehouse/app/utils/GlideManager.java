package com.android.yt.ehouse.app.utils;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by feng on 2017/8/1.
 */

public class GlideManager {

    public static <T> void loadCircleImage(Fragment fragment, T t, ImageView targetImageView) {
        if (t != null && fragment != null && targetImageView != null) {
            Glide.with(fragment)
                    .load(t)
                    .placeholder(R.drawable.shape_default_image)
                    .error(R.drawable.shape_default_image)
                    .bitmapTransform(new CropCircleTransformation(fragment.getContext()))
                    .into(targetImageView);
        }
    }

    public static <T> void loadImage(Fragment fragment, T t, ImageView targetImageView) {
        if (t != null && fragment != null && targetImageView != null) {
            Glide.with(fragment)
                    .load(t)
                    .placeholder(R.drawable.shape_default_image)
                    .error(R.drawable.shape_default_image)
                    .into(targetImageView);
        }
    }

}
