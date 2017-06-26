package com.android.yt.ehouse.app.ui.adapter;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.BaseTypeItemBean;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/6/23.
 */

public class TypeHallFragmentAdapter extends BaseMultiItemQuickAdapter<BaseTypeItemBean,BaseViewHolder>{

    public static final int LEFT_FLAG = 0;
    public static final int RIGHT_FLAG = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TypeHallFragmentAdapter(List<BaseTypeItemBean> data) {
        super(data);
        addItemType(LEFT_FLAG,R.layout.adapter_small_fragment_left_item_layout);
        addItemType(RIGHT_FLAG,R.layout.adapter_small_fragment_right_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseTypeItemBean item) {
    }
}
