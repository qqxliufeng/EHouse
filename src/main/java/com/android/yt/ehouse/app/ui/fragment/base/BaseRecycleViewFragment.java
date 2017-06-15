//package com.android.yt.ehouse.app.ui.fragment.base;
//
//import android.support.annotation.CallSuper;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
//
//import com.android.sdyt.lawapponline.R;
//import com.android.sdyt.lawapponline.utils.EncodeUtils;
//import com.android.sdyt.lawapponline.utils.MethodUtils;
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.chad.library.adapter.base.listener.OnItemClickListener;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//import butterknife.BindView;
//
///**
// * Created by feng on 2016/9/14.
// */
//
//public abstract class BaseRecycleViewFragment<T> extends LroidBaseNetFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
//
//    public static final String COUNT = "count";
//    @BindView(R.id.id_bt_fragment_base_recycle_view_empty)
//    protected Button mEmptyView;
//    @BindView(R.id.id_rv_fragment_base_recycle_view_content)
//    protected RecyclerView mRecyclerView;
//    @BindView(R.id.id_srl_fragment_base_recycle_view_content)
//    protected SwipeRefreshLayout mSwipeRefreshLayout;
//    @BindView(R.id.id_fl_fragment_base_recycle_view_container)
//    protected FrameLayout mFrameLayoutContainer;
//
//    protected BaseQuickAdapter<T> mBaseQuickAdapter;
//    protected ArrayList<T> mArrayList = new ArrayList<>();
//
//    protected int MAX_PAGE_COUNT = -1;
//    protected int PAGE_SIZE = 15;
//    protected int current_page = 1;
//
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.fragment_base_recycle_view_layout;
//    }
//
//    @CallSuper
//    @Override
//    protected void initView(View view) {
//        mBaseQuickAdapter = createAdapter();
//        if (mBaseQuickAdapter == null) {
//            return;
//        }
//        mBaseQuickAdapter.openLoadAnimation();
//        mBaseQuickAdapter.openLoadMore(PAGE_SIZE);
//        mBaseQuickAdapter.setOnLoadMoreListener(this);
//        mRecyclerView.setAdapter(mBaseQuickAdapter);
//        mRecyclerView.setLayoutManager(createLayoutManager());
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
//        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mContext, android.R.color.holo_blue_dark), ContextCompat.getColor(mContext, android.R.color.holo_green_dark), ContextCompat.getColor(mContext, android.R.color.holo_orange_dark));
//        mSwipeRefreshLayout.setOnRefreshListener(this);
//        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
//            @Override
//            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//                onSimpleItemClick(baseQuickAdapter, view, i);
//            }
//
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                onItemViewChildClick(adapter, view, position);
//            }
//        });
//        mSwipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mSwipeRefreshLayout.setRefreshing(true);
//            }
//        });
//        onRefresh();
//    }
//
//    protected void setItemDecoration() {
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
//        itemDecoration.setDrawable(ActivityCompat.getDrawable(mContext, R.drawable.recyclerview_devider_one));
//        mRecyclerView.addItemDecoration(itemDecoration);
//    }
//
//    protected void onPostRefreshFalse() {
//        mSwipeRefreshLayout.setEnabled(false);
//    }
//
//    protected abstract BaseQuickAdapter<T> createAdapter();
//
//    protected RecyclerView.LayoutManager createLayoutManager() {
//        return new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
//    }
//
//    @Override
//    public void onRequestStart(int requestID) {
//        mEmptyView.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void onRequestFail(int requestID, Throwable e) {
//        if (e != null && !TextUtils.isEmpty(e.getMessage())) {
//            if (e instanceof IllegalStateException) {
//                mEmptyView.setText(e.getMessage());
//            }
//        }
//        mEmptyView.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    @CallSuper
//    public <T> void onRequestSuccess(int requestID, T result) {
//        mEmptyView.setVisibility(View.GONE);
//        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    @CallSuper
//    public void onRequestEnd(int requestID) {
//        if (mSwipeRefreshLayout.isRefreshing()) {
//            mSwipeRefreshLayout.post(new Runnable() {
//                @Override
//                public void run() {
//                    mSwipeRefreshLayout.setRefreshing(false);
//                }
//            });
//        }
//    }
//
//    public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//    }
//
//    public void onItemViewChildClick(BaseQuickAdapter adapter, View view, int position) {
//    }
//
//    @Override
//    public void onLoadMoreRequested() {
//        if (current_page >= MAX_PAGE_COUNT) {
//            mRecyclerView.post(new Runnable() {
//                @Override
//                public void run() {
//                    mBaseQuickAdapter.loadComplete();
//                }
//            });
//        } else {
//            current_page++;
//            onLoadMore();
//        }
//    }
//
//    protected void setPagerParam(String total) {
//        if (MAX_PAGE_COUNT == -1) {
//            int count = Integer.parseInt(total);
//            if (count % PAGE_SIZE == 0) {
//                MAX_PAGE_COUNT = count / PAGE_SIZE;
//            } else {
//                MAX_PAGE_COUNT = count / PAGE_SIZE + 1;
//            }
//        }
//    }
//
//    /**
//     * 子类若需下拉刷新功能，则直接重写方法
//     * 下拉刷新
//     */
//    @Override
//    public void onRefresh() {
//    }
//
//    public void onPostRefresh() {
//        mSwipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mSwipeRefreshLayout.setRefreshing(true);
//            }
//        });
//        onRefresh();
//    }
//
//    /**
//     * 子类若需上拉加载功能，则直接重写方法
//     * 上拉加载
//     */
//    protected void onLoadMore() {
//    }
//
//    protected void defaultDealData(Map<String, Object> result, Class<T> clazz, boolean isReverse) throws Exception {
//        try {
//            HashMap<String, Object> map = (HashMap<String, Object>) result;
//            if (map != null && !map.isEmpty()) {
//                HashMap<String, Object> listMap = (HashMap<String, Object>) map.get("list");
//                if (listMap != null && !listMap.isEmpty()) {
//                    int[] sortKey = MethodUtils.sortKeys(listMap.keySet());
//                    ArrayList<T> tempList = new ArrayList<>();
//                    for (int key : sortKey) {
//                        HashMap<String, Object> value = (HashMap<String, Object>) listMap.get(Integer.toString(key));
//                        tempList.add(MethodUtils.jsonToBean(EncodeUtils.jsonEncode(value), clazz));
//                    }
//                    if (isReverse) {
//                        Collections.reverse(tempList);
//                    }
//                    mBaseQuickAdapter.addData(tempList);
//                } else {
//                    showEmptyView();
//                }
//                if (map.containsKey(COUNT)) {
//                    setPagerParam((String) map.get(COUNT));
//                }
//            } else {
//                showEmptyView();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            showEmptyView();
//        }
//    }
//
//    public void showEmptyView() {
//        mEmptyView.setVisibility(View.VISIBLE);
//        mSwipeRefreshLayout.setVisibility(View.GONE);
//    }
//
//    public void showEmptyView(String emptyMessage) {
//        mEmptyView.setText(emptyMessage);
//        mEmptyView.setVisibility(View.VISIBLE);
//        mSwipeRefreshLayout.setVisibility(View.GONE);
//    }
//
//}
