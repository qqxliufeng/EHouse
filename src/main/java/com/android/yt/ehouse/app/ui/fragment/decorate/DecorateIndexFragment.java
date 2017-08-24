package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyBean;
import com.android.yt.ehouse.app.interfaces.OnClassifySearchContentClickListener;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.IndexDecorateFragmentAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */

public class DecorateIndexFragment extends BaseRecycleViewFragment<DecorateCompanyBean> implements OnClassifySearchContentClickListener {

    public static DecorateIndexFragment newInstance() {
        return new DecorateIndexFragment();
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyBean, BaseViewHolder> createAdapter() {
        return new IndexDecorateFragmentAdapter(mContext,R.layout.adapter_decorate_list_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setItemDecoration();
        View headerView = View.inflate(mContext, R.layout.layout_index_decorate_header_layout, null);
        EHouseApplication.getInstance().setOnClassifySearchContentClickListener(this);
        headerView.findViewById(R.id.id_tv_fragment_decorate_index_note).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContainerActivity.startFragmentsActivity(mContext, "", FragmentContainerActivity.NOTE_DECORATE_LIST_FLAG);
            }
        });
        headerView.findViewById(R.id.id_tv_fragment_decorate_index_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContainerActivity.startFragmentsActivity(mContext, "日记图集", FragmentContainerActivity.NOTE_IMAGES_FLAG);
            }
        });
        headerView.findViewById(R.id.id_et_fragment_classify_search_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EHouseApplication.getInstance().setOnClassifySearchContentClickListener(DecorateIndexFragment.this);
                FragmentContainerActivity.startFragmentsActivity(mContext, "", FragmentContainerActivity.CLASSIFY_SEARCH_FLAG);
            }
        });
        headerView.findViewById(R.id.id_tv_fragment_decorate_index_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentContainerActivity.startFragmentsActivity(mContext, "装修公司", FragmentContainerActivity.DECORATE_COMPANY_LIST_FLAG);
            }
        });
        mBaseQuickAdapter.addHeaderView(headerView);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    protected void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_ORGANIZATION.getDecoCompanyList(
                "1",
                null,
                null,
                null,
                null,
                current_page));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        try {
            defaultDealData((Map<String, Object>) result, DecorateCompanyBean.class,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestFail(int requestID, Throwable e) {
    }

    @Override
    public <T> void onSearchContentClick(T t) {
        Toast.makeText(mContext, t + "" + this.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(DecorateCompanyInfoFragment.ORG_ID, mArrayList.get(i));
        FragmentContainerActivity.startFragmentsActivity(mContext, "公司详情", FragmentContainerActivity.DECORATE_COMPANY_INFO_FLAG,bundle);
    }
}
