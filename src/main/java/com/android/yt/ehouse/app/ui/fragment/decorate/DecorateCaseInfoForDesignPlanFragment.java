package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateCaseInfoForDesignAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseInfoForDesignPlanFragment extends BaseRecycleViewFragment<String>{

    public static DecorateCaseInfoForDesignPlanFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCaseInfoForDesignPlanFragment fragment = new DecorateCaseInfoForDesignPlanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateCaseInfoForDesignAdapter(R.layout.adapter_decorate_case_info_for_design_item_layout,mArrayList);
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
