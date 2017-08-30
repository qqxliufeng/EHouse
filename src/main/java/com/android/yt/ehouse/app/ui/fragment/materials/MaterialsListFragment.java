package com.android.yt.ehouse.app.ui.fragment.materials;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity.Companion;
import com.android.yt.ehouse.app.ui.adapter.MaterialsListItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/3.
 */

public class MaterialsListFragment extends BaseRecycleViewFragment<String> {

    public static MaterialsListFragment newInstance() {
        return new MaterialsListFragment();
    }

    @BindView(R.id.id_ll_materials_list_condition_zh_order)
    LinearLayout ll_zh_order;
    @BindView(R.id.id_ll_materials_list_condition_xl_order)
    LinearLayout ll_xl_order;
    @BindView(R.id.id_ll_materials_list_condition_price_order)
    LinearLayout ll_price_order;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_materials_list_layout;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new MaterialsListItemAdapter(mContext, R.layout.adapter_meterials_list_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        onRequestEnd(-1);
        mSwipeRefreshLayout.setEnabled(false);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.id_ll_materials_list_condition_zh_order,
            R.id.id_ll_materials_list_condition_xl_order,
            R.id.id_ll_materials_list_condition_price_order,
            R.id.id_iv_fragment_materials_list_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_ll_materials_list_condition_zh_order:
                ((CheckedTextView) ll_zh_order.getChildAt(0)).setChecked(true);
                ((CheckedTextView) ll_xl_order.getChildAt(0)).setChecked(false);
                ((CheckedTextView) ll_price_order.getChildAt(0)).setChecked(false);
                break;
            case R.id.id_ll_materials_list_condition_xl_order:
                ((CheckedTextView) ll_zh_order.getChildAt(0)).setChecked(false);
                ((CheckedTextView) ll_xl_order.getChildAt(0)).setChecked(true);
                ((CheckedTextView) ll_price_order.getChildAt(0)).setChecked(false);
                break;
            case R.id.id_ll_materials_list_condition_price_order:
                ((CheckedTextView) ll_zh_order.getChildAt(0)).setChecked(false);
                ((CheckedTextView) ll_xl_order.getChildAt(0)).setChecked(false);
                ((CheckedTextView) ll_price_order.getChildAt(0)).setChecked(true);
                break;
            case R.id.id_iv_fragment_materials_list_back:
                finishActivity();
                break;
        }
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,"", KtFragmentContainerActivity.Companion.getMATERIALS_INFO_FLAG());
    }
}
