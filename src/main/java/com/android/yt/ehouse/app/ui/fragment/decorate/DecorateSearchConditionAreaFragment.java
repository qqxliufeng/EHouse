package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanySearchBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/3.
 */

public class DecorateSearchConditionAreaFragment extends LroidBaseNetFragment {


    public static DecorateSearchConditionAreaFragment newInstance() {
        return new DecorateSearchConditionAreaFragment();
    }

    @BindView(R.id.id_rv_fragment_decorate_search_condition_area)
    RecyclerView rv_area;
    private ArrayList<DecorateCompanySearchBean> mArrayList = new ArrayList<>();

    private MyRecyclerAreaAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_search_condition_area_layout;
    }

    @Override
    protected void initView(View view) {
        rv_area.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyRecyclerAreaAdapter(R.layout.fragment_decorate_search_condition_area_item_layout, mArrayList);
        rv_area.setAdapter(adapter);
    }

    public void refresh(ArrayList<DecorateCompanySearchBean> styleList) {
        if (styleList != null) {
            mArrayList.clear();
            mArrayList.addAll(styleList);
            adapter.notifyDataSetChanged();
        }
    }


    @OnClick({R.id.id_view_decorate_list_search_condition_empty, R.id.id_ll_fragment_decorate_company_list_condition_area_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_view_decorate_list_search_condition_empty:
                ((DecorateCompanyListFragment) getParentFragment()).onBackPressProcess();
                break;
            case R.id.id_ll_fragment_decorate_company_list_condition_area_container:
                break;
        }
    }


    static class MyRecyclerAreaAdapter extends BaseQuickAdapter<DecorateCompanySearchBean, BaseViewHolder> {

        public MyRecyclerAreaAdapter(int layoutResId, List<DecorateCompanySearchBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, DecorateCompanySearchBean item) {
            helper.setText(R.id.id_cb_adapter_area_item, item.getName());
        }
    }
}
