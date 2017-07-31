package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateCaseAllAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseAllFragment extends BaseRecycleViewFragment<String>{

    public static DecorateCaseAllFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCaseAllFragment fragment = new DecorateCaseAllFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateCaseAllAdapter(R.layout.adapter_decorate_case_all_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mRecyclerView.setLayoutManager(null);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

}
