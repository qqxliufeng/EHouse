package com.android.yt.ehouse.app.ui.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyBean;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/6/26.
 */

public class IndexDecorateFragmentAdapter extends BaseQuickAdapter<DecorateCompanyBean, BaseViewHolder> {

    private Context context;

    public IndexDecorateFragmentAdapter(Context context, int layoutId, ArrayList<DecorateCompanyBean> mArrayList) {
        super(layoutId, mArrayList);
        this.context = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, DecorateCompanyBean item) {
        RatingBar ratingBar = helper.getView(R.id.id_rb_adapter_decorate_item_account);
        LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(ContextCompat.getColor(mContext, R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        helper.setText(R.id.id_tv_adapter_decorate_list_item_name, item.getOrg_name());
        helper.setText(R.id.id_tv_adapter_decorate_list_item_koubei_count, item.getKoubei());
        helper.setText(R.id.id_tv_adapter_decorate_list_item_address, item.getOrg_addr());
        helper.setText(R.id.id_tv_adapter_decorate_list_item_design_count, "设计方案：" + item.getPcount());
        helper.setText(R.id.id_tv_adapter_decorate_list_item_note_count, "业主日记：" + item.getEcount());
        GlideManager.loadImage(context, item.getOrg_logo(), (ImageView) helper.getView(R.id.id_iv_adapter_decorate_list_item_logo));
    }
}
