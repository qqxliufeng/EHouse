package com.android.yt.ehouse.app.ui.fragment.shoppingcar;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.GoodsItemBean;
import com.android.yt.ehouse.app.ui.adapter.ShoppingCarEmptyAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/6.
 */

public class ShoppingCarEmptyFragment extends BaseRecycleViewFragment<GoodsItemBean>{

    public static ShoppingCarEmptyFragment newInstance() {
        return new ShoppingCarEmptyFragment();
    }

    @Override
    protected BaseQuickAdapter<GoodsItemBean, BaseViewHolder> createAdapter() {
        return new ShoppingCarEmptyAdapter(R.layout.adapter_shopping_car_empty_item_layout,mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        View emptyHeaderView = View.inflate(mContext,R.layout.layout_shopping_car_empty_header_layout,null);
        mBaseQuickAdapter.addHeaderView(emptyHeaderView);
        for (int i = 0; i < 10; i++) {
            mArrayList.add(new GoodsItemBean());
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
