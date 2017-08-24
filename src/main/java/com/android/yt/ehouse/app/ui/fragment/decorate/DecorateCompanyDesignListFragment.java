package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDesignBean;
import com.android.yt.ehouse.app.ui.adapter.DecorateCompanyDesignListAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyDesignListFragment extends BaseRecycleViewFragment<DecorateCompanyDesignBean> {

    public static DecorateCompanyDesignListFragment newInstance(Bundle args) {
        DecorateCompanyDesignListFragment fragment = new DecorateCompanyDesignListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyDesignBean, BaseViewHolder> createAdapter() {
        return new DecorateCompanyDesignListAdapter(R.layout.adapter_decorate_company_info_design_item_layout, mArrayList);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    protected void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.REQUESTMOD_HOUSE.getDesignList(getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""), ""));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        try {
            defaultDealData((Map<String, Object>) result, DecorateCompanyDesignBean.class,false);
        } catch (Exception e) {
            showEmptyView();
        }
    }
}
