package com.android.yt.ehouse.app.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by feng on 2017/8/1.
 */

public class GlideManager {

    public static <T> void loadCircleImage(Fragment fragment, T t, ImageView targetImageView) {
        if (t != null && fragment != null && targetImageView != null) {
            Glide.with(fragment)
                    .load(t)
                    .placeholder(R.drawable.img_test_bg)
                    .error(R.drawable.img_test_bg)
                    .bitmapTransform(new CenterCrop(fragment.getContext()), new CropCircleTransformation(fragment.getContext()))
                    .into(targetImageView);
        }
    }

    public static <T> void loadImage(Fragment fragment, T t, ImageView targetImageView) {
        if (t != null && fragment != null && targetImageView != null) {
            Glide.with(fragment)
                    .load(t)
                    .asBitmap()
                    .placeholder(R.drawable.shape_default_image)
                    .error(R.drawable.shape_default_image)
                    .into(targetImageView);
        }
    }

    public static void loadImage(Context context, String url, int errorImg, int emptyImg, ImageView iv) {
        //原生 API  
        Glide.with(context).load(TextUtils.isEmpty(url) ? Constants.INSTANCE.DEFAULT_IMAGE_URL : url).placeholder(emptyImg).error(errorImg).into(iv);
    }

    public static void loadImage(Context context, String url, ImageView iv) {
        //原生 API
        Glide.with(context).load(TextUtils.isEmpty(url) ? Constants.INSTANCE.DEFAULT_IMAGE_URL : url).placeholder(R.drawable.shape_default_image).error(R.drawable.shape_default_image).into(iv);
    }

    public static void loadGifImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(TextUtils.isEmpty(url) ? Constants.INSTANCE.DEFAULT_IMAGE_URL : url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.drawable.shape_default_image).error(R.drawable.shape_default_image).into(iv);
    }


    public static void loadCircleImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(TextUtils.isEmpty(url) ? Constants.INSTANCE.DEFAULT_IMAGE_URL : url).placeholder(R.drawable.shape_default_image).error(R.drawable.shape_default_image).transform(new GlideCircleTransform(context)).into(iv);
    }

    public static void loadRoundCornerImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(TextUtils.isEmpty(url) ? Constants.INSTANCE.DEFAULT_IMAGE_URL : url).placeholder(R.drawable.shape_default_image).error(R.drawable.shape_default_image).transform(new GlideRoundTransform(context, 10)).into(iv);
    }


    public static void loadImage(Context context, final File file, final ImageView imageView) {
        Glide.with(context)
                .load(file)
                .into(imageView);
    }

    public static void loadImage(Context context, final int resourceId, final ImageView imageView) {
        Glide.with(context)
                .load(resourceId)
                .into(imageView);
    }

}
