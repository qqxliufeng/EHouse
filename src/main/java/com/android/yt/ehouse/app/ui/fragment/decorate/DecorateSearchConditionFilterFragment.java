package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanySearchBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.utils.EncodeUtils;
import com.android.yt.ehouse.app.utils.MethodUtils;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by feng on 2017/7/3.
 */

public class DecorateSearchConditionFilterFragment extends LroidBaseNetFragment {

    public static DecorateSearchConditionFilterFragment newInstance() {
        return new DecorateSearchConditionFilterFragment();
    }

    @BindView(R.id.id_rv_fragment_decorate_search_condition_filter)
    RecyclerView rv_filter;

    private SectionedRecyclerViewAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_search_condition_filter_layout;
    }

    @Override
    protected void initView(View view) {
        adapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 4;
                    default:
                        return 1;
                }
            }
        });
        rv_filter.setLayoutManager(gridLayoutManager);
        rv_filter.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getSearchMap();
    }

    private void getSearchMap() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_ORGANIZATION.getDecoSearchMap());
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        if (requestID == 0x0){
            parseSearchConditionResult(result);
        }
    }

    private <T> void parseSearchConditionResult(T result) {
        if (result != null) {
            HashMap<String, Object> map = (HashMap<String, Object>) result;
            HashMap<String, Object> styleMap = (HashMap<String, Object>) map.get("style");
            HashMap<String, Object> priceMap = (HashMap<String, Object>) map.get("price");
            ArrayList<DecorateCompanySearchBean> styleBeans = new ArrayList<>();
            if (styleMap != null) {
                int[] sortKey = MethodUtils.sortKeys(styleMap.keySet());
                for (int key : sortKey) {
                    HashMap<String, Object> value = (HashMap<String, Object>) styleMap.get(Integer.toString(key));
                    DecorateCompanySearchBean companySearchBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(value), DecorateCompanySearchBean.class);
                    companySearchBean.setType("style");
                    styleBeans.add(companySearchBean);
                }
            }
            ArrayList<DecorateCompanySearchBean> priceBeans = new ArrayList<>();
            if (priceMap != null) {
                int[] sortKey = MethodUtils.sortKeys(priceMap.keySet());
                for (int key : sortKey){
                    String value = (String) priceMap.get(Integer.toString(key));
                    DecorateCompanySearchBean companySearchBean = new DecorateCompanySearchBean();
                    companySearchBean.setType("price");
                    companySearchBean.setName(value);
                    priceBeans.add(companySearchBean);
                }
            }
            Map<String,ArrayList<DecorateCompanySearchBean>> styleMapContent = new HashMap<>();
            Map<String,ArrayList<DecorateCompanySearchBean>> priceMapContent = new HashMap<>();
            styleMapContent.put("装修风格",styleBeans);
            priceMapContent.put("装修价格",priceBeans);
            refresh(styleMapContent,priceMapContent);
        }
    }


    public void refresh(Map<String, ArrayList<DecorateCompanySearchBean>> ...maps) {
        for (int i = 0; i < maps.length; i++) {
            Set<Map.Entry<String, ArrayList<DecorateCompanySearchBean>>> entries = maps[i].entrySet();
            for (Map.Entry<String, ArrayList<DecorateCompanySearchBean>> entry : entries) {
                adapter.addSection(new DecorateCompanySearchAdapter(entry.getKey(), entry.getValue()));
            }
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick({R.id.id_bt_fragment_decorate_list_search_condition_more_reset, R.id.id_view_decorate_list_search_condition_empty, R.id.id_ll_fragment_decorate_list_search_condition_more_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_bt_fragment_decorate_list_search_condition_more_reset:
//                resetView(ll_container);
                break;
            case R.id.id_ll_fragment_decorate_list_search_condition_more_container:
                break;
            case R.id.id_view_decorate_list_search_condition_empty:
                ((DecorateCompanyListFragment) getParentFragment()).onBackPressProcess();
                break;
        }
    }

    /**
     * 递归调用 重置CheckBox的选中状态
     *
     * @param container
     */
    private void resetView(LinearLayout container) {
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = container.getChildAt(i);
            if (childAt instanceof LinearLayout) {
                resetView((LinearLayout) childAt);
            } else if (childAt instanceof CheckBox) {
                ((CheckBox) childAt).setChecked(false);
            }
        }
    }


    public static class DecorateCompanySearchAdapter extends StatelessSection {

        private String title;
        private ArrayList<DecorateCompanySearchBean> list;

        public DecorateCompanySearchAdapter(String title, ArrayList<DecorateCompanySearchBean> list) {
            super(new SectionParameters.Builder(R.layout.adapter_decorate_company_search_item_layout).headerResourceId(android.R.layout.simple_list_item_1).build());
            this.title = title;
            this.list = list;
        }

        @Override
        public int getContentItemsTotal() {
            return list.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((ItemViewHolder) viewHolder).cb_item.setText(list.get(i).getName());
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            ((HeaderHolder) holder).tv_title.setText(title);
        }

        static class HeaderHolder extends RecyclerView.ViewHolder {

            TextView tv_title;

            public HeaderHolder(View itemView) {
                super(itemView);
                tv_title = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }

        static class ItemViewHolder extends RecyclerView.ViewHolder {

            CheckBox cb_item;

            public ItemViewHolder(View itemView) {
                super(itemView);
                cb_item = (CheckBox) itemView.findViewById(R.id.id_cb_adapter_decorate_company_search_item);
            }

        }


    }

}
