package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateCompanyInfoForCertificateAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.MethodUtils;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyInfoForCertificateFragment extends BaseRecycleViewFragment<String> {

    public static DecorateCompanyInfoForCertificateFragment newInstance(Bundle args) {
        DecorateCompanyInfoForCertificateFragment fragment = new DecorateCompanyInfoForCertificateFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateCompanyInfoForCertificateAdapter(R.layout.adapter_decorate_company_info_for_certificate_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mRecyclerView.setLayoutManager(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mSwipeRefreshLayout.setEnabled(false);
        mBaseQuickAdapter.setEnableLoadMore(false);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    private void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_ORGANIZATION.getBaseCompanyInfo(getArguments().getString(DecorateCompanyInfoFragment.ORG_ID), "cert"));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        Map<String, Object> certMap = (Map<String, Object>) ((Map<String, Object>) result).get("cert");
        int[] sortKey = MethodUtils.sortKeys(certMap.keySet());
        for (int key : sortKey) {
            String value = (String) certMap.get(Integer.toString(key));
            mArrayList.add(value);
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
