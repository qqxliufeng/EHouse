package com.android.yt.ehouse.app.ui.fragment.financing;


import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.FinancingListAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/8/1.
 */

public class FinancingListFragment extends BaseRecycleViewFragment<String> {

    public static FinancingListFragment newInstance() {
        return new FinancingListFragment();
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new FinancingListAdapter(R.layout.adapter_financing_list_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mSwipeRefreshLayout.setEnabled(false);
        mBaseQuickAdapter.addHeaderView(View.inflate(mContext, R.layout.layout_financing_list_top_layout, null));
        mBaseQuickAdapter.setEnableLoadMore(false);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        onRequestEnd(-1);
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
