package com.android.yt.ehouse.app.ui.fragment.house;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.HouseItemBean;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.HouseFragmentItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

/**
 * Created by feng on 2017/6/23.
 */

public class HouseHallFragment extends BaseRecycleViewFragment<HouseItemBean> {

    public static final String TITLE = "房产大厅";
    public static final String HOUSE_ID_FLAG = "house_id_flag";

    public static HouseHallFragment newInstance() {
        return new HouseHallFragment();
    }

    @Override
    protected BaseQuickAdapter<HouseItemBean, BaseViewHolder> createAdapter() {
        return new HouseFragmentItemAdapter(R.layout.adapter_house_fragment_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setItemDecoration();
        View headerView = View.inflate(mContext, R.layout.adapter_layout_house_hall_top_layout, null);
        headerView.findViewById(R.id.id_tv_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,"",KtFragmentContainerActivity.Companion.getHOUSE_LIST_FLAG());
            }
        });
        headerView.findViewById(R.id.id_rl_fragment_adapter_house_hall_top_sell).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,"我要卖房",KtFragmentContainerActivity.Companion.getHOUSE_SELL_FLAG());
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

    @Override
    protected void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_HOUSE.getHouseList(current_page));
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Bundle bundle = new Bundle();
        HouseItemBean houseItemBean = mArrayList.get(i);
        bundle.putString(HOUSE_ID_FLAG, houseItemBean.getId());
        KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,houseItemBean.getTitle(),KtFragmentContainerActivity.Companion.getHOUSE_INFO_FLAG(),bundle);
    }

    @Override
    public void onRequestFail(int requestID, Throwable e) {
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        try {
            defaultDealData((Map<String, Object>) result,HouseItemBean.class,false);
        } catch (Exception e) {
            Toast.makeText(mContext, "列表加载失败！", Toast.LENGTH_SHORT).show();
        }
    }
}
