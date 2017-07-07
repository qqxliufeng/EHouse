package com.android.yt.ehouse.app.ui.fragment.base;


import android.support.annotation.CallSuper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.utils.EncodeUtils;
import com.android.yt.ehouse.app.utils.MethodUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by feng on 2016/9/14.
 */

public abstract class BaseRecycleViewFragment<T> extends LroidBaseNetFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    public static final String COUNT = "count";

    @BindView(R.id.id_rv_fragment_base_recycle_view_content)
    protected RecyclerView mRecyclerView;
    @BindView(R.id.id_srl_fragment_base_recycle_view_content)
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.id_fl_fragment_base_recycle_view_container)
    protected FrameLayout mFrameLayoutContainer;

    protected LinearLayout mEmptyView;
    protected View mErrorView;

    protected BaseQuickAdapter<T, BaseViewHolder> mBaseQuickAdapter;
    protected ArrayList<T> mArrayList = new ArrayList<>();

    protected int MAX_PAGE_COUNT = -1;
    protected int PAGE_SIZE = 15;
    protected int current_page = 1;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_recycle_view_layout;
    }

    @CallSuper
    @Override
    public void initView(View view) {
        mBaseQuickAdapter = createAdapter();
        if (mBaseQuickAdapter == null) {
            return;
        }
        mEmptyView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.layout_base_recycle_empty_layout, mFrameLayoutContainer, false);
        mErrorView = LayoutInflater.from(mContext).inflate(R.layout.layout_base_recycle_error_layout, mFrameLayoutContainer, false);
        mEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPostRefresh();
            }
        });
        mErrorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPostRefresh();
            }
        });
        mBaseQuickAdapter.openLoadAnimation();
        mBaseQuickAdapter.setOnLoadMoreListener(this);
        mRecyclerView.setAdapter(mBaseQuickAdapter);
        mRecyclerView.setLayoutManager(createLayoutManager());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mContext, android.R.color.holo_blue_dark), ContextCompat.getColor(mContext, android.R.color.holo_green_dark), ContextCompat.getColor(mContext, android.R.color.holo_orange_dark));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                onMySimpleItemClick(adapter, view, position);
            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                onItemViewChildClick(adapter, view, position);
            }
        });
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        onRefresh();
    }

    protected void setItemDecoration() {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ActivityCompat.getDrawable(mContext, R.drawable.recyclerview_devider_one));
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    protected void onPostRefreshFalse() {
        mSwipeRefreshLayout.setEnabled(false);
    }

    protected abstract BaseQuickAdapter<T, BaseViewHolder> createAdapter();

    protected RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void onRequestStart(int requestID) {
    }

    @CallSuper
    @Override
    public void onRequestFail(int requestID, Throwable e) {
        super.onRequestFail(requestID, e);
        showErrorView();
    }

    @CallSuper
    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
    }

    @Override
    @CallSuper
    public void onRequestEnd(int requestID) {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }

    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
    }

    public void onItemViewChildClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onLoadMoreRequested() {
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                if (current_page >= MAX_PAGE_COUNT) {
                    mBaseQuickAdapter.loadMoreEnd();
                } else {
                    current_page++;
                    onLoadMore();
                }
            }
        });
    }

    protected void setPagerParam(String total) {
        if (MAX_PAGE_COUNT == -1) {
            int count = Integer.parseInt(total);
            if (count % PAGE_SIZE == 0) {
                MAX_PAGE_COUNT = count / PAGE_SIZE;
            } else {
                MAX_PAGE_COUNT = count / PAGE_SIZE + 1;
            }
        }
    }

    /**
     * 子类若需下拉刷新功能，则直接重写方法
     * 下拉刷新
     */
    @Override
    @CallSuper
    public void onRefresh() {
        if (!mArrayList.isEmpty()) {
            mArrayList.clear();
        }
    }

    public void onPostRefresh() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        onRefresh();
    }

    /**
     * 子类若需上拉加载功能，则直接重写方法
     * 上拉加载
     */
    protected void onLoadMore() {
    }


    /**
     * 处理后台返回的数据
     *
     * @param result    数据源
     * @param clazz     对应的JavaBean.class
     * @param isReverse 是否要进行逆向排序
     * @throws Exception 抛出异常
     */
    protected void defaultDealData(Map<String, Object> result, Class<T> clazz, boolean isReverse) throws Exception {
        try {
            HashMap<String, Object> map = (HashMap<String, Object>) result;
            if (map != null && !map.isEmpty()) {
                HashMap<String, Object> listMap = (HashMap<String, Object>) map.get("list");
                if (listMap != null && !listMap.isEmpty()) {
                    int[] sortKey = MethodUtils.sortKeys(listMap.keySet());
                    ArrayList<T> tempList = new ArrayList<>();
                    for (int key : sortKey) {
                        HashMap<String, Object> value = (HashMap<String, Object>) listMap.get(Integer.toString(key));
                        tempList.add(MethodUtils.jsonToBean(EncodeUtils.jsonEncode(value), clazz));
                    }
                    if (isReverse) {
                        Collections.reverse(tempList);
                    }
                    mBaseQuickAdapter.addData(tempList);
                    mBaseQuickAdapter.loadMoreComplete();
                } else {
                    if (current_page > 1) { //已经加载几页了，没有更多数据了
                        mBaseQuickAdapter.loadMoreEnd();
                    } else {//第一在页就没有数据
                        showEmptyView();
                    }
                }
                if (map.containsKey(COUNT)) {
                    setPagerParam((String) map.get(COUNT));
                }
            } else {
                showEmptyView();
            }
        } catch (Exception e) {
            showErrorView();
        }
    }


    public void showEmptyView() {
        mBaseQuickAdapter.setEmptyView(mEmptyView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    public TextView getEmptyView() {
        return (TextView) mEmptyView.getChildAt(0);
    }

    public void showErrorView() {
        mBaseQuickAdapter.setEmptyView(mErrorView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

}
