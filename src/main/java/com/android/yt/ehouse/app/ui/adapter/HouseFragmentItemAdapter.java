package com.android.yt.ehouse.app.ui.adapter;

import com.android.yt.ehouse.app.data.bean.HouseItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/6/23.
 */

public class HouseFragmentItemAdapter extends BaseQuickAdapter<HouseItemBean,BaseViewHolder> {


    public HouseFragmentItemAdapter(int layoutResId, List<HouseItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HouseItemBean item) {
    }
}
