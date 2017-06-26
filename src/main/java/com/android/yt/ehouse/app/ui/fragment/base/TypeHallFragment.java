package com.android.yt.ehouse.app.ui.fragment.base;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.BaseTypeItemBean;
import com.android.yt.ehouse.app.data.bean.TypeHallSellBean;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.TypeHallFragmentAdapter;
import com.android.yt.ehouse.app.ui.adapter.TypeHallHotSellAdapter;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;
import com.android.yt.ehouse.app.ui.view.MyLinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/6/23.
 */

public class TypeHallFragment extends BaseRecycleViewFragment<BaseTypeItemBean> implements AppBarLayout.OnOffsetChangedListener {

    private RecyclerView rv_hot_sell;
    private ArrayList<TypeHallSellBean> hotList = new ArrayList<>();

    @BindView(R.id.id_abl_home_tool_bar_container)
    AppBarLayout al_container;
    @BindView(R.id.id_cv_fragment_type_hall_search)
    CardView cv_search;
    @BindView(R.id.id_iv_fragment_type_hall_message)
    ImageView iv_message;
    @BindView(R.id.id_iv_fragment_type_hall_back)
    ImageView iv_back;

    public static TypeHallFragment newInstance() {
        return new TypeHallFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type_hall_layout;
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
        al_container.addOnOffsetChangedListener(this);
        for (int i = 0; i < 5; i++) {
            BaseTypeItemBean typeItemBean = new BaseTypeItemBean();
            if (i % 2 == 0) {
                typeItemBean.setItemType(0);
            } else {
                typeItemBean.setItemType(1);
            }
            mArrayList.add(typeItemBean);
            hotList.add(new TypeHallSellBean());
        }
        View headerView = View.inflate(mContext, R.layout.fragment_small_house_header_layout, null);
        rv_hot_sell = (RecyclerView) headerView.findViewById(R.id.id_rv_fragment_type_hall);
        rv_hot_sell.setNestedScrollingEnabled(false);
        rv_hot_sell.setLayoutManager(new MyLinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rv_hot_sell.setAdapter(new TypeHallHotSellAdapter(R.layout.adapter_type_hall_hot_sell_item_layout, hotList));
        mBaseQuickAdapter.addHeaderView(headerView);
        mSwipeRefreshLayout.setEnabled(false);
        onRequestEnd(-1);
        getChildFragmentManager().beginTransaction().replace(R.id.id_fl_fragment_index_banner_layout, BannerFragment.newInstance()).commit();
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float alpha = ((float) Math.abs(verticalOffset)) / (float) appBarLayout.getTotalScrollRange();
        cv_search.setAlpha(alpha);
        if (Math.abs(verticalOffset) > appBarLayout.getTotalScrollRange() / 2) {
            iv_message.setColorFilter(Color.GRAY);
            iv_back.setColorFilter(Color.GRAY);
        } else {
            iv_message.setColorFilter(Color.WHITE);
            iv_back.setColorFilter(Color.WHITE);
        }
    }


    @OnClick({R.id.id_iv_fragment_type_hall_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.id_iv_fragment_type_hall_back:
                finishActivity();
                break;
        }
    }
}
