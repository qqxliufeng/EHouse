package com.android.yt.ehouse.app.ui.fragment.images;

import android.graphics.Color;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.MapImageAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * Created by feng on 2017/7/27.
 *  套图Fragment
 */

public class MapImageFragment extends BaseRecycleViewFragment{

    public static MapImageFragment newInstance() {
        return new MapImageFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_single_image_layout;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        int dimension = (int) getResources().getDimension(R.dimen.dp_10);
        mRecyclerView.setPadding(dimension/2,dimension,dimension/2,0);
        mRecyclerView.setBackgroundColor(Color.parseColor("#eeeeee"));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }


    @Override
    protected BaseQuickAdapter createAdapter() {
        return new MapImageAdapter(R.layout.adapter_map_image_item_layout,mArrayList);
    }



}
