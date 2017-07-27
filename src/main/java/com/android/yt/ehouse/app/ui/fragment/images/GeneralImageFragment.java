package com.android.yt.ehouse.app.ui.fragment.images;

import android.graphics.Color;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.GeneralImageAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * Created by feng on 2017/7/27.
 * 全景图Fragment
 */

public class GeneralImageFragment extends BaseRecycleViewFragment{

    public static GeneralImageFragment newInstance() {
        return new GeneralImageFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_image_general_layout;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mRecyclerView.setBackgroundColor(Color.parseColor("#eeeeee"));
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    protected BaseQuickAdapter createAdapter() {
        return new GeneralImageAdapter(R.layout.adapter_general_image_item_layout,mArrayList);
    }
}
