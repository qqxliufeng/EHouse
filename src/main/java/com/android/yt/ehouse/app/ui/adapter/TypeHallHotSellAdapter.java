package com.android.yt.ehouse.app.ui.adapter;

import com.android.yt.ehouse.app.data.bean.TypeHallSellBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/6/26.
 */

public class TypeHallHotSellAdapter extends BaseQuickAdapter<TypeHallSellBean,BaseViewHolder>{

    public TypeHallHotSellAdapter(int layoutResId, List<TypeHallSellBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TypeHallSellBean item) {

    }
}
