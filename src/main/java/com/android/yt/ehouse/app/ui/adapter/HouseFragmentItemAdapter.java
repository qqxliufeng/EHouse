package com.android.yt.ehouse.app.ui.adapter;

import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.HouseItemBean;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.android.yt.ehouse.app.utils.KtUtilsKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/6/23.
 */

public class HouseFragmentItemAdapter extends BaseQuickAdapter<HouseItemBean, BaseViewHolder> {


    public HouseFragmentItemAdapter(int layoutResId, List<HouseItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HouseItemBean item) {
        GlideManager.loadImage(helper.getConvertView().getContext(), item.getPic(), (ImageView) helper.getView(R.id.id_iv_adapter_house_hall_item_pic));
        KtUtilsKt.setDefaultText(helper, R.id.id_tv_adapter_house_hall_item_title, item.getTitle());
        KtUtilsKt.setDefaultText(helper, R.id.id_tv_adapter_house_hall_item_des, item.getCompose());
        KtUtilsKt.setDefaultText(helper, R.id.id_tv_adapter_house_hall_item_price, item.getPrice() + "万");
        KtUtilsKt.setDefaultText(helper, R.id.id_tv_adapter_house_hall_item_tag1, item.getHouse_type_str());
        KtUtilsKt.setDefaultText(helper, R.id.id_tv_adapter_house_hall_item_tag2, item.getHouse_direction_str());
    }
}
