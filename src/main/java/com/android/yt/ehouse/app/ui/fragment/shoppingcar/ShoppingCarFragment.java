package com.android.yt.ehouse.app.ui.fragment.shoppingcar;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.GoodsItemBean;
import com.android.yt.ehouse.app.ui.adapter.ShoppingCarAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * Created by feng on 2017/7/5.
 */

public class ShoppingCarFragment extends BaseRecycleViewFragment<GoodsItemBean> {

    public static ShoppingCarFragment newInstance() {
        return new ShoppingCarFragment();
    }

    @BindView(R.id.id_bt_fragment_shopping_car_calculate)
    Button bt_calculate;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_shopping_car_layout;
    }

    @Override
    protected BaseQuickAdapter<GoodsItemBean, BaseViewHolder> createAdapter() {
        return new ShoppingCarAdapter(mContext, R.layout.adapter_shopping_car_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        ShoppingCarManager.getInstance().addTestItem();
        mArrayList.addAll(ShoppingCarManager.getInstance().getGoodsList());
        mBaseQuickAdapter.setEnableLoadMore(false);
        onRequestEnd(-1);
        mSwipeRefreshLayout.setEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemViewChildClick(BaseQuickAdapter adapter, View view, int position) {
        GoodsItemBean goodsItemBean = mArrayList.get(position);
        switch (view.getId()) {
            case R.id.id_tv_adapter_shopping_car_inner_item:
                ShoppingCarManager.getInstance().setSelectedByGoodItemFlag(goodsItemBean);
                break;
            case R.id.id_tv_adapter_shopping_car_header_shop:
                ShoppingCarManager.getInstance().setAllSelectedByGoodsItemFlag(goodsItemBean);
                break;
            case R.id.id_bt_adapter_shopping_car_inner_item_delete:
                ShoppingCarManager.getInstance().removeItem(goodsItemBean);
                mArrayList.remove(goodsItemBean);
                break;
        }
        refreshView();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }

    @OnCheckedChanged(R.id.id_cb_fragment_shopping_car_all_selected)
    public void onChecked(CompoundButton compoundButton, boolean isChecked) {
        ShoppingCarManager.getInstance().setAllSelected(isChecked);
        refreshView();
    }

    private void refreshView() {
        //刷新列表
        mBaseQuickAdapter.notifyDataSetChanged();
        ArrayList<GoodsItemBean> selectedItems = ShoppingCarManager.getInstance().getSelectedList();
        bt_calculate.setEnabled(!selectedItems.isEmpty());
        bt_calculate.setText("结算(" + selectedItems.size() + ")");
    }
}
