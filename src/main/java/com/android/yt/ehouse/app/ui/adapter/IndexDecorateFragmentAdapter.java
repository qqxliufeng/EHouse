package com.android.yt.ehouse.app.ui.adapter;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.RatingBar;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyItemBean;
import com.android.yt.ehouse.app.data.bean.DecorateSellerItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/6/26.
 */

public class IndexDecorateFragmentAdapter extends BaseQuickAdapter<DecorateCompanyItemBean, BaseViewHolder> {

    public IndexDecorateFragmentAdapter(int layoutId, ArrayList<DecorateCompanyItemBean> mArrayList) {
        super(layoutId, mArrayList);
    }


    @Override
    protected void convert(BaseViewHolder helper, DecorateCompanyItemBean item) {
        RatingBar ratingBar = helper.getView(R.id.id_rb_adapter_decorate_item_account);
        LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(ContextCompat.getColor(mContext, R.color.yellow), PorterDuff.Mode.SRC_ATOP);
    }
}
