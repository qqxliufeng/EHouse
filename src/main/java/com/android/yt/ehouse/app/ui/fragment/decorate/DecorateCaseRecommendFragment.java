package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateCaseRecommendAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseRecommendFragment extends BaseRecycleViewFragment<String> {

    public static DecorateCaseRecommendFragment newInstance() {
        return new DecorateCaseRecommendFragment();
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateCaseRecommendAdapter(R.layout.adapter_decorate_case_recommend_item_layout, mArrayList);
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
