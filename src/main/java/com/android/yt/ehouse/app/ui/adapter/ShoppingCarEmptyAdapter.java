package com.android.yt.ehouse.app.ui.adapter;

import com.android.yt.ehouse.app.data.bean.GoodsItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/7/6.
 */

public class ShoppingCarEmptyAdapter extends BaseQuickAdapter<GoodsItemBean,BaseViewHolder> {

    public ShoppingCarEmptyAdapter(int layoutResId, List<GoodsItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsItemBean item) {
    }
}
