package com.android.yt.ehouse.app.ui.fragment.decorate;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyBean;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.IndexDecorateFragmentAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseFragmentWithSearchConditionFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/3.
 */

public class DecorateCompanyListFragment extends BaseFragmentWithSearchConditionFragment<DecorateCompanyBean> {

    public static DecorateCompanyListFragment newInstance() {
        return new DecorateCompanyListFragment();
    }

    private DecorateSearchConditionAreaFragment areaFragment;
    private DecorateSearchConditionFilterFragment filterFragment;
    private DecorateSearchConditionIntelligentOrderFragment intelligentOrderFragment;

    @BindView(R.id.id_ll_fragment_decorate_company_list_condition_area)
    LinearLayout ll_area;
    @BindView(R.id.id_ll_fragment_decorate_company_list_condition_filter)
    LinearLayout ll_filter;
    @BindView(R.id.id_ll_fragment_decorate_company_list_condition_intelligent_order)
    LinearLayout ll_intelligent_order;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_decorate_company_list_layout;
    }

    @Override
    protected int getConditionFragmentContainer() {
        return R.id.id_fl_fragment_decorate_company_list_condition_container;
    }

    @Override
    protected void addConditionFragments() {
        areaFragment = DecorateSearchConditionAreaFragment.newInstance();
        filterFragment = DecorateSearchConditionFilterFragment.newInstance();
        intelligentOrderFragment = DecorateSearchConditionIntelligentOrderFragment.newInstance();
        fragments.add(areaFragment);
        fragments.add(filterFragment);
        fragments.add(intelligentOrderFragment);
    }

    @Override
    protected void addLinearLayouts() {
        linearLayouts.add(ll_area);
        linearLayouts.add(ll_filter);
        linearLayouts.add(ll_intelligent_order);
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyBean, BaseViewHolder> createAdapter() {
        return new IndexDecorateFragmentAdapter(mContext,R.layout.adapter_decorate_list_item_layout, mArrayList);
    }

    @OnClick({R.id.id_ll_fragment_decorate_company_list_condition_area,
            R.id.id_ll_fragment_decorate_company_list_condition_filter,
            R.id.id_ll_fragment_decorate_company_list_condition_intelligent_order})
    public void onClick(final LinearLayout view) {
        switch (view.getId()) {
            case R.id.id_ll_fragment_decorate_company_list_condition_area:
                currentFragment = areaFragment;
                break;
            case R.id.id_ll_fragment_decorate_company_list_condition_filter:
                currentFragment = filterFragment;
                break;
            case R.id.id_ll_fragment_decorate_company_list_condition_intelligent_order:
                currentFragment = intelligentOrderFragment;
                break;
        }
        managerFragment();
        view.post(new Runnable() {
            @Override
            public void run() {
                refreshTextView(view);
            }
        });
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    private void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x1, RequestParamsHelper.RequestMod_ORGANIZATION.getDecoCompanyList(null, null, null, null, null, current_page));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        if (requestID == 0x1) {
            try {
                defaultDealData((Map<String, Object>) result, DecorateCompanyBean.class, false);
            } catch (Exception e) {
                showEmptyView();
            }
        }
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(DecorateCompanyInfoFragment.ORG_ID, mArrayList.get(i).getOrg_id());
        FragmentContainerActivity.startFragmentsActivity(mContext, "公司详情", FragmentContainerActivity.DECORATE_COMPANY_INFO_FLAG,bundle);
    }
}
