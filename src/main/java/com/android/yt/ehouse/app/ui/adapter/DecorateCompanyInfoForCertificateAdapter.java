package com.android.yt.ehouse.app.ui.adapter;

import android.widget.ImageView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyInfoForCertificateAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public DecorateCompanyInfoForCertificateAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView imageView = helper.getView(R.id.id_iv_adapter_decorate_company_info_for_certificate_image);
        GlideManager.loadImage(this.mContext, item, imageView);
    }
}
