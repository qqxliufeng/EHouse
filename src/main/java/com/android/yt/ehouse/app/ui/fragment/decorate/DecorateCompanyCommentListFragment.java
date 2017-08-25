package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyCommentBean;
import com.android.yt.ehouse.app.ui.adapter.DecorateCompanyCommentListAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyCommentListFragment extends BaseRecycleViewFragment<DecorateCompanyCommentBean> {

    public static DecorateCompanyCommentListFragment newInstance(Bundle args) {
        DecorateCompanyCommentListFragment fragment = new DecorateCompanyCommentListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyCommentBean, BaseViewHolder> createAdapter() {
        return new DecorateCompanyCommentListAdapter(R.layout.adapter_decorate_company_info_comment_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setItemDecoration();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    protected void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_HOUSE.getEvaluateList(getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""), ""));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        try {
            defaultDealData((Map<String, Object>) result, DecorateCompanyCommentBean.class,false);
        } catch (Exception e) {
            showEmptyView();
        }
    }
}
