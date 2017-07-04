package com.android.yt.ehouse.app.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/7/3.
 */

public class MaterialsListItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MaterialsListItemAdapter(Context context, int layout, ArrayList<String> list) {
        super(layout, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
