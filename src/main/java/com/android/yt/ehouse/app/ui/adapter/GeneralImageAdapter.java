package com.android.yt.ehouse.app.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/7/27.
 */

public class GeneralImageAdapter extends BaseQuickAdapter<String,BaseViewHolder>{


    public GeneralImageAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
