package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateSellerItemBean;
import com.android.yt.ehouse.app.ui.adapter.IndexDecorateFragmentAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/6/26.
 */

public class DecorateIndexFragment extends BaseRecycleViewFragment<DecorateSellerItemBean> {

    public static DecorateIndexFragment newInstance() {
        return new DecorateIndexFragment();
    }

    @Override
    protected BaseQuickAdapter<DecorateSellerItemBean, BaseViewHolder> createAdapter() {
        return new IndexDecorateFragmentAdapter(R.layout.adapter_decorate_list_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        for (int i = 0; i < 10; i++) {
            mArrayList.add(new DecorateSellerItemBean());
        }
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        View headerView = View.inflate(mContext, R.layout.layout_index_decorate_header_layout, null);
        mBaseQuickAdapter.addHeaderView(headerView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

}
