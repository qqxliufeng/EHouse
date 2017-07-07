package com.android.yt.ehouse.app.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.GoodsItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;


/**
 * Created by feng on 2017/7/5.
 */

public class ShoppingCarAdapter extends BaseQuickAdapter<GoodsItemBean, BaseViewHolder> {


    private Drawable leftUnselectedDrawable;
    private Drawable leftSelectedDrawable;
    private Drawable rightDrawable;

    public ShoppingCarAdapter(Context mContext, int layoutId, ArrayList<GoodsItemBean> list) {
        super(layoutId, list);
        leftSelectedDrawable = ContextCompat.getDrawable(mContext, R.drawable.img_shopcart_selected);
        leftUnselectedDrawable = ContextCompat.getDrawable(mContext, R.drawable.img_shopcart_unselected);
        rightDrawable = ContextCompat.getDrawable(mContext, R.drawable.img_enter1_icon);
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsItemBean item) {
        LinearLayout ll_header_container = helper.getView(R.id.id_ll_adapter_shopping_car_header_container);
        helper.addOnClickListener(R.id.id_tv_adapter_shopping_car_header_shop_title);
        helper.addOnClickListener(R.id.id_tv_adapter_shopping_car_inner_item);
        helper.addOnClickListener(R.id.id_bt_adapter_shopping_car_inner_item_delete);
        helper.setText(R.id.id_tv_adapter_shopping_car_header_shop_title,item.getTitle());
        helper.setText(R.id.id_tv_adapter_shopping_car_inner_item_title, item.getAddTime().toString()+item.getTitle());
        if (item.getIndex() == 1) {
            ll_header_container.setVisibility(View.VISIBLE);
        } else {
            ll_header_container.setVisibility(View.GONE);
        }
        TextView tv_shop_title = helper.getView(R.id.id_tv_adapter_shopping_car_header_shop_title);
        TextView tv_item = helper.getView(R.id.id_tv_adapter_shopping_car_inner_item);
        if (item.isSectionSelected()) {
            tv_shop_title.setCompoundDrawablesWithIntrinsicBounds(leftSelectedDrawable, null, rightDrawable, null);
        } else {
            tv_shop_title.setCompoundDrawablesWithIntrinsicBounds(leftUnselectedDrawable, null, rightDrawable, null);
        }
        if (item.isItemSelected()) {
            tv_item.setCompoundDrawablesWithIntrinsicBounds(leftSelectedDrawable, null, null, null);
        } else {
            tv_item.setCompoundDrawablesWithIntrinsicBounds(leftUnselectedDrawable, null, null, null);
        }
    }

//    @Override
//    public long getHeaderId(int i) {
//        GoodsItemBean goodsItemBean = mData.get(i);
//        long index = goodsItemBean.getFlag();
//        if (index != currentIndex) {
//            currentIndex = index;
//        }
//        return currentIndex;
//    }
//
//    @Override
//    public ShoppingCarAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
//        View headerView = inflater.inflate(R.layout.adapter_shopping_car_item_inner_layout, viewGroup, false);
//        return new HeaderViewHolder(headerView);
//    }
//
//    @Override
//    public void onBindHeaderViewHolder(ShoppingCarAdapter.HeaderViewHolder viewHolder, final int i) {
//        viewHolder.textView.setText(String.valueOf(mData.get(i).getTitle()));
////        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////            @Override
////            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////
////            }
////        });
//    }
//
//    static class HeaderViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView textView;
//        public CheckBox checkBox;
//
//        public HeaderViewHolder(View itemView) {
//            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.id_tv_adapter_shopping_car_item_header_title);
//            checkBox = (CheckBox) itemView.findViewById(R.id.id_cb_adapter_shopping_car_item_header_selected);
//        }
//    }
}
