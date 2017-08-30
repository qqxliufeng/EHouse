package com.android.yt.ehouse.app.ui.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDesignBean;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.android.yt.ehouse.app.utils.KtUtilsKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyDesignListAdapter extends BaseQuickAdapter<DecorateCompanyDesignBean, BaseViewHolder> {

    public DecorateCompanyDesignListAdapter(int layoutResId, List<DecorateCompanyDesignBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DecorateCompanyDesignBean item) {
        helper.setText(R.id.id_tv_fragment_decorate_company_info_design_name, TextUtils.isEmpty(item.getName()) ? "暂无" : item.getName());
        ImageView iv_image = helper.getView(R.id.id_iv_fragment_decorate_company_info_design_image);
        GlideManager.loadImage(mContext, item.getThumb(), R.drawable.img_banner_default_img, R.drawable.img_banner_default_img, iv_image);
        String str = item.getStr();
        KtUtilsKt.setDefaultText(helper, R.id.id_tv_fragment_decorate_company_info_design_desc, str);
    }
}
