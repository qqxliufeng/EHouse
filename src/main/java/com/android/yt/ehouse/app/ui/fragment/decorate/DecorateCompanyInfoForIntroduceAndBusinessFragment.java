package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyBean;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDetailBean;
import com.android.yt.ehouse.app.ui.adapter.DecorateCompanyInfoForIntroduceAndBusinessAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyInfoForIntroduceAndBusinessFragment extends BaseRecycleViewFragment<DecorateCompanyDetailBean> {

    public static final String ORG_ID_FLAG = "org_id_flag";
    public static final String ACTION_FLAG = "action_flag";
    private String action;


    public static DecorateCompanyInfoForIntroduceAndBusinessFragment newInstance(Bundle args) {
        DecorateCompanyInfoForIntroduceAndBusinessFragment fragment = new DecorateCompanyInfoForIntroduceAndBusinessFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyDetailBean, BaseViewHolder> createAdapter() {
        action = getArguments().getString(ACTION_FLAG);
        return new DecorateCompanyInfoForIntroduceAndBusinessAdapter(R.layout.adapter_decorate_company_info_for_introduce_and_business_item_layout, mArrayList, "business".equals(action) ? 0 : 1);
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

    @Override
    public void onRequestEnd(int requestID) {
        super.onRequestEnd(requestID);
        mSwipeRefreshLayout.setEnabled(false);
        mBaseQuickAdapter.setEnableLoadMore(false);
    }

    private void fillDataFromNet() {
        String orgId = getArguments().getString(ORG_ID_FLAG);
        action = getArguments().getString(ACTION_FLAG);
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_ORGANIZATION.getBaseCompanyInfo(orgId, action));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        if (requestID == 0x0) {
            parseData((Map<String, Object>) result);
        }
    }

    private void parseData(Map<String, Object> resultMap) {
        if (resultMap != null && !resultMap.isEmpty()) {
            Set<Map.Entry<String, Object>> entries = resultMap.entrySet();
            if (resultMap.containsKey("creatorid")) resultMap.remove("creatorid");
            if (resultMap.containsKey("createtime")) resultMap.remove("createtime");
            if (resultMap.containsKey("service_num")) resultMap.remove("service_num");
            if (resultMap.containsKey("org_id")) resultMap.remove("org_id");
            if (resultMap.containsKey("home_deco")) resultMap.remove("home_deco");
            ArrayList<DecorateCompanyDetailBean> tempList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : entries) {
                DecorateCompanyDetailBean decorateCompanyDetailBean = new DecorateCompanyDetailBean();
                if ("business".equals(action)) {
                    decorateCompanyDetailBean.setBusinessKey(entry.getKey());
                } else {
                    decorateCompanyDetailBean.setIntroduceKey(entry.getKey());
                }
                decorateCompanyDetailBean.setValue((String) entry.getValue());
                tempList.add(decorateCompanyDetailBean);
            }
            Collections.sort(tempList, new Comparator<DecorateCompanyDetailBean>() {
                @Override
                public int compare(DecorateCompanyDetailBean o1, DecorateCompanyDetailBean o2) {
                    return Integer.valueOf(o1.getIndex()).compareTo(o2.getIndex());
                }
            });

            if (!"business".equals(action)) {
                List<DecorateCompanyDetailBean> subList = tempList.subList(0,8);
                View headerView = View.inflate(mContext, R.layout.layout_decorate_company_introduce_header_layout, null);
                View footView = View.inflate(mContext, R.layout.layout_decorate_company_introduce_foot_layout, null);
                TextView tv_header_content = (TextView) headerView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_header_content);
                tv_header_content.setText((String) resultMap.get("intro"));
                TextView tv_foot_fwqy = (TextView) footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_fwqy_content);
                TextView tv_foot_fwzc = (TextView) footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_fwzc_content);
                TextView tv_foot_cjjw = (TextView) footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_cjjw_content);
                TextView tv_foot_zcfg = (TextView) footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_zcfg_content);
                tv_foot_fwqy.setText((String) resultMap.get("range_service"));
                tv_foot_fwzc.setText((String) resultMap.get("public_deco"));
                tv_foot_cjjw.setText((String) resultMap.get("accept_price"));
                tv_foot_zcfg.setText((String) resultMap.get("focus_style"));
                mBaseQuickAdapter.addHeaderView(headerView);
                mBaseQuickAdapter.addFooterView(footView);
                mArrayList.addAll(subList);
            }else {
                mArrayList.addAll(tempList);
            }

            mBaseQuickAdapter.notifyDataSetChanged();
        }
    }
}
