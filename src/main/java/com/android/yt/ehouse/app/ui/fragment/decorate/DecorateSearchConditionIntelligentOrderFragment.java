package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;


import butterknife.OnClick;

/**
 * Created by feng on 2017/7/3.
 */

public class DecorateSearchConditionIntelligentOrderFragment extends LroidBaseFragment {


    public static DecorateSearchConditionIntelligentOrderFragment newInstance() {
        return new DecorateSearchConditionIntelligentOrderFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_search_condition_intelligent_order_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void setComponent() {
    }

    @OnClick({R.id.id_view_decorate_list_search_condition_empty, R.id.id_ll_fragment_decorate_search_condition_intelligent_order_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_view_decorate_list_search_condition_empty:
                ((DecorateCompanyListFragment) getParentFragment()).onBackPressProcess();
                break;
            case R.id.id_ll_fragment_decorate_search_condition_intelligent_order_container:
                break;
        }
    }
}
