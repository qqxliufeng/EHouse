package com.android.yt.ehouse.app.ui.fragment.house;

import android.support.v7.widget.DividerItemDecoration;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.HouseSearchConditionPriceAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import butterknife.OnClick;

/**
 * Created by feng on 2017/7/1.
 */

public class HouseSearchConditionPriceFragment extends BaseRecycleViewFragment<String> {

    public static HouseSearchConditionPriceFragment newInstance() {
        return new HouseSearchConditionPriceFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_house_list_search_condition_price_layout;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        onRequestEnd(-1);
        mSwipeRefreshLayout.setEnabled(false);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        for (int i = 0; i < 10; i++) {
            mArrayList.add("item " + i);
        }
        mBaseQuickAdapter.setEnableLoadMore(false);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new HouseSearchConditionPriceAdapter(mContext, android.R.layout.simple_list_item_1, mArrayList);
    }

    @OnClick({R.id.id_view_house_list_search_condition_empty,R.id.id_ll_fragment_house_list_search_condition_price_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_view_house_list_search_condition_empty:
                ((HouseListFragment) getParentFragment()).onBackPressProcess();
                break;
            case R.id.id_ll_fragment_house_list_search_condition_price_container:
                break;
        }
    }
}
