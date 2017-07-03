package com.android.yt.ehouse.app.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/7/3.
 */

public class HouseSearchConditionPriceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HouseSearchConditionPriceAdapter(Context mContext, int layoutID, ArrayList<String> list) {
        super(layoutID, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(android.R.id.text1,item);
    }
}
