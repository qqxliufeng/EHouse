package com.android.yt.ehouse.app.ui.fragment.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.BaseTypeItemBean;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.TypeHallFragmentAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/6/23.
 */

public class TypeHallFragment extends BaseRecycleViewFragment<BaseTypeItemBean> {

    public static TypeHallFragment newInstance() {
        return new TypeHallFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((FragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected BaseQuickAdapter<BaseTypeItemBean, BaseViewHolder> createAdapter() {
        return new TypeHallFragmentAdapter(mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        for (int i = 0; i < 5; i++) {
            BaseTypeItemBean typeItemBean = new BaseTypeItemBean();
            if (i % 2 == 0) {
                typeItemBean.setItemType(0);
            } else {
                typeItemBean.setItemType(1);
            }
            mArrayList.add(typeItemBean);
        }
        View headerView = View.inflate(mContext, R.layout.fragment_small_house_header_layout, null);
        mSwipeRefreshLayout.setEnabled(false);
        onRequestEnd(-1);
        mBaseQuickAdapter.addHeaderView(headerView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
