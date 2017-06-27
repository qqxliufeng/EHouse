package com.android.yt.ehouse.app.ui.fragment.house;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.HouseItemBean;
import com.android.yt.ehouse.app.ui.adapter.HouseHallAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/6/23.
 */

public class HouseHallFragment extends BaseRecycleViewFragment<HouseItemBean> {

    public static final String TITLE = "房产大厅";

    public static HouseHallFragment newInstance() {
        return new HouseHallFragment();
    }

    @Override
    protected BaseQuickAdapter<HouseItemBean, BaseViewHolder> createAdapter() {
        return new HouseHallAdapter(R.layout.adapter_house_hall_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        for (int i = 0; i < 10; i++) {
            mArrayList.add(new HouseItemBean());
        }
        View headerView = View.inflate(mContext, R.layout.adapter_layout_house_hall_top_layout, null);
        mBaseQuickAdapter.addHeaderView(headerView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }
}
