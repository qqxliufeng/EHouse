package com.android.yt.ehouse.app.ui.adapter;

import android.text.TextUtils;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyInfoForIntroduceAndBusinessAdapter extends BaseQuickAdapter<DecorateCompanyDetailBean, BaseViewHolder> {

    private int type;

    public DecorateCompanyInfoForIntroduceAndBusinessAdapter(int layoutResId, List<DecorateCompanyDetailBean> data, int type) {
        super(layoutResId, data);
        this.type = type;
    }

    @Override
    public int getItemCount() {
        return type == 0 ? super.getItemCount() : 11;
    }

    @Override
    protected void convert(BaseViewHolder helper, DecorateCompanyDetailBean item) {
        helper.setText(R.id.id_tv_adapter_decorate_company_info_for_introduce_and_business_item_key, type == 1 ? item.getIntroduceKey() : item.getBusinessKey());
        helper.setText(R.id.id_tv_adapter_decorate_company_info_for_introduce_and_business_item_value, TextUtils.isEmpty(item.getValue()) ? "暂无" : item.getValue());
    }
}
