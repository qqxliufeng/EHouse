package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateVideoListAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/27.
 */

public class DecorateVideoListFragment extends BaseRecycleViewFragment<String>{

    public static DecorateVideoListFragment newInstance() {
        return new DecorateVideoListFragment();
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateVideoListAdapter(R.layout.adapter_decorate_video_list_item_layout,mArrayList);
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
