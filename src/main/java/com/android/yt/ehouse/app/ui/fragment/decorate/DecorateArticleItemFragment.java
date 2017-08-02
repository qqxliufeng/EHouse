package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateArticleItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/27.
 */

public class DecorateArticleItemFragment extends BaseRecycleViewFragment<String> {

    public static DecorateArticleItemFragment newInstance() {
        Bundle args = new Bundle();
        DecorateArticleItemFragment fragment = new DecorateArticleItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private boolean isVisible = false;
    private boolean isPrepared = false;
    private boolean isLoad = false;

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateArticleItemAdapter(R.layout.adapter_decorate_article_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setItemDecoration();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    //    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (getUserVisibleHint()) {
//            isVisible = true;
//            lazyLoad();
//        } else {
//            isVisible = false;
//        }
//    }
//
//    @Override
//    public void initView(View view) {
//        super.initView(view);
//        isPrepared = true;
//        lazyLoad();
//    }
//
//    private void lazyLoad() {
//        if (isVisible && isPrepared && !isLoad) {
//            current_page = 1;
//            //加载
//            isLoad = true;
//        }
//    }
//
//    @Override
//    public void onRefresh() {
//        super.onRefresh();
//        if (isVisible && isPrepared) {
//            mArrayList.clear();
//            current_page = 1;
//            //加载
//        }
//    }
//
//    @Override
//    protected void onLoadMore() {
//        if (isVisible) {
//            //加载
//        }
//    }

}
