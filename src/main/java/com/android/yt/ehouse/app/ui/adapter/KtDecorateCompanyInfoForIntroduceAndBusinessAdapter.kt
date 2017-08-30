package com.android.yt.ehouse.app.ui.adapter

import android.text.TextUtils
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDetailBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by feng on 2017/8/29.
 */
class KtDecorateCompanyInfoForIntroduceAndBusinessAdapter(private var type: Int = 0, resId: Int, list: ArrayList<DecorateCompanyDetailBean>) : BaseQuickAdapter<DecorateCompanyDetailBean, BaseViewHolder>(resId, list) {


    override fun getItemCount(): Int {
        return if (0 == type) super.getItemCount() else 11
    }

    override fun convert(helper: BaseViewHolder?, item: DecorateCompanyDetailBean?) {
        helper?.setText(R.id.id_tv_adapter_decorate_company_info_for_introduce_and_business_item_key, if (type == 1) {
            item?.introduceKey
        } else {
            item?.businessKey
        })
        helper?.setText(R.id.id_tv_adapter_decorate_company_info_for_introduce_and_business_item_value, if (TextUtils.isEmpty(item?.value)) {
            "暂无"
        } else {
            item?.value
        })
    }

}