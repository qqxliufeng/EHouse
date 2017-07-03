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

public class HouseSearchConditionFXFragment extends BaseRecycleViewFragment<String> {

    public static HouseSearchConditionFXFragment newInstance() {
        return new HouseSearchConditionFXFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_house_list_search_condition_fx_layout;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new HouseSearchConditionPriceAdapter(mContext, android.R.layout.simple_list_item_1, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mBaseQuickAdapter.setEnableLoadMore(false);
        mSwipeRefreshLayout.setEnabled(false);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        onRequestEnd(-1);
        for (int i = 0; i < 10; i++) {
            mArrayList.add("item" + 1);
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.id_view_house_list_search_condition_empty,R.id.id_ll_fragment_house_list_search_condition_fx_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_view_house_list_search_condition_empty:
                ((HouseListFragment) getParentFragment()).onBackPressProcess();
                break;
        }
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ((HouseListFragment) getParentFragment()).onFXSelected(mArrayList.get(i));
    }
}
