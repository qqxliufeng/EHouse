package com.android.yt.ehouse.app.ui.fragment.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.HouseItemBean;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.HouseFragmentItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseFragmentWithSearchConditionFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by feng on 2017/6/30.
 */

public class HouseListFragment extends BaseFragmentWithSearchConditionFragment<HouseItemBean> {

    public static HouseListFragment newInstance() {
        return new HouseListFragment();
    }

    @BindView(R.id.id_fl_fragment_house_list_condition_container)
    FrameLayout fl_condition_container;
    @BindView(R.id.id_ll_house_list_condition_area)
    LinearLayout ll_area;
    @BindView(R.id.id_ll_house_list_condition_price)
    LinearLayout ll_price;
    @BindView(R.id.id_ll_house_list_condition_fx)
    LinearLayout ll_fx;
    @BindView(R.id.id_ll_house_list_condition_more)
    LinearLayout ll_more;


    private HouseSearchConditionAreaFragment areaFragment;
    private HouseSearchConditionPriceFragment priceFragment;
    private HouseSearchConditionFXFragment fxFragment;
    private HouseSearchConditionMoreFragment moreFragment;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_house_list_layout;
    }

    @Override
    protected int getConditionFragmentContainer() {
        return R.id.id_fl_fragment_house_list_condition_container;
    }

    @Override
    protected BaseQuickAdapter<HouseItemBean, BaseViewHolder> createAdapter() {
        return new HouseFragmentItemAdapter(R.layout.adapter_house_fragment_item_layout, mArrayList);
    }

    @Override
    protected void addConditionFragments() {
        areaFragment = HouseSearchConditionAreaFragment.newInstance();
        priceFragment = HouseSearchConditionPriceFragment.newInstance();
        fxFragment = HouseSearchConditionFXFragment.newInstance();
        moreFragment = HouseSearchConditionMoreFragment.newInstance();
        fragments.add(areaFragment);
        fragments.add(priceFragment);
        fragments.add(fxFragment);
        fragments.add(moreFragment);
    }

    @Override
    protected void addLinearLayouts() {
        linearLayouts.add(ll_area);
        linearLayouts.add(ll_price);
        linearLayouts.add(ll_fx);
        linearLayouts.add(ll_more);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    @Override
    protected void fillDataFromNet() {
        super.fillDataFromNet();
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_HOUSE.getHouseList(current_page));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        try {
            defaultDealData((Map<String, Object>) result,HouseItemBean.class,false);
        } catch (Exception e) {
            showEmptyView();
        }
    }

    @OnClick({R.id.id_ll_house_list_condition_area,
            R.id.id_ll_house_list_condition_price,
            R.id.id_ll_house_list_condition_fx,
            R.id.id_ll_house_list_condition_more})
    public void onConditionClick(final LinearLayout view) {
        switch (view.getId()) {
            case R.id.id_ll_house_list_condition_area:
                currentFragment = areaFragment;
                break;
            case R.id.id_ll_house_list_condition_price:
                currentFragment = priceFragment;
                break;
            case R.id.id_ll_house_list_condition_fx:
                currentFragment = fxFragment;
                break;
            case R.id.id_ll_house_list_condition_more:
                currentFragment = moreFragment;
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


    @OnClick({R.id.id_iv_fragment_house_list_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_iv_fragment_house_list_back:
                finishActivity();
                break;
        }
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Bundle bundle = new Bundle();
        HouseItemBean houseItemBean = mArrayList.get(i);
        bundle.putString(HouseHallFragment.HOUSE_ID_FLAG, houseItemBean.getId());
        KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,houseItemBean.getTitle(),KtFragmentContainerActivity.Companion.getHOUSE_INFO_FLAG(),bundle);
    }


    /**
     * 选择房型
     *
     * @param condition
     */
    public void onFXSelected(String condition) {
        onBackPressProcess();
        mBaseQuickAdapter.addData(new HouseItemBean());
    }

    /**
     * 区域选择
     */
    public void onAreaSelected() {
        onBackPressProcess();
    }

    /**
     * 价格选择
     *
     * @param price
     */
    public void onPriceSelected(String price) {
        onBackPressProcess();
    }

    /**
     * 更多选择
     *
     * @param more
     */
    public void onMoreSelected(ArrayList<String> more) {
        onBackPressProcess();
    }

}
