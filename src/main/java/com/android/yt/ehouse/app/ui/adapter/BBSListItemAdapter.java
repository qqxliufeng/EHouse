package com.android.yt.ehouse.app.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/7/28.
 */

public class BBSListItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public BBSListItemAdapter(int resId, ArrayList<String> list) {
        super(resId,list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
