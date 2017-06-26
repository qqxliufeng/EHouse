package com.android.yt.ehouse.app.ui.adapter;

import com.android.yt.ehouse.app.data.bean.DecorateSellerItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/6/26.
 */

public class IndexDecorateFragmentAdapter extends BaseQuickAdapter<DecorateSellerItemBean, BaseViewHolder> {

    public IndexDecorateFragmentAdapter(int layoutId, ArrayList<DecorateSellerItemBean> mArrayList) {
        super(layoutId,mArrayList);
    }


    @Override
    protected void convert(BaseViewHolder helper, DecorateSellerItemBean item) {

    }
}
