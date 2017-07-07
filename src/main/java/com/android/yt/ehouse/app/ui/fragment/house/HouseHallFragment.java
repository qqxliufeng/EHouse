package com.android.yt.ehouse.app.ui.fragment.house;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.HouseItemBean;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.HouseFragmentItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import butterknife.OnClick;

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
        return new HouseFragmentItemAdapter(R.layout.adapter_house_fragment_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        for (int i = 0; i < 10; i++) {
            mArrayList.add(new HouseItemBean());
        }
        View headerView = View.inflate(mContext, R.layout.adapter_layout_house_hall_top_layout, null);
        headerView.findViewById(R.id.id_tv_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.HOUSE_LIST_FLAG);
            }
        });
        headerView.findViewById(R.id.id_rl_fragment_adapter_house_hall_top_sell).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContainerActivity.startFragmentsActivity(mContext,"我要卖房",FragmentContainerActivity.HOUSE_SELL_FLAG);
            }
        });
        mBaseQuickAdapter.addHeaderView(headerView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }


    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.HOUSE_INFO_FLAG);
    }
}
