package com.android.yt.ehouse.app.ui.fragment.decorate

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDetailBean
import com.android.yt.ehouse.app.ui.adapter.KtDecorateCompanyInfoForIntroduceAndBusinessAdapter
import com.android.yt.ehouse.app.ui.fragment.base.KtBaseRecycleViewFragment
import com.android.yt.ehouse.app.utils.RequestParamsHelper
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import java.util.*

/**
 * Created by feng on 2017/8/29.
 */
class KtDecorateCompanyInfoForIntroduceAndBusinessFragment : KtBaseRecycleViewFragment<DecorateCompanyDetailBean>() {

    companion object {
        fun newInstance(args: Bundle): KtDecorateCompanyInfoForIntroduceAndBusinessFragment {
            val ktDecorateCompanyInfoForIntroduceAndBusinessFragment = KtDecorateCompanyInfoForIntroduceAndBusinessFragment()
            ktDecorateCompanyInfoForIntroduceAndBusinessFragment.arguments = args
            return ktDecorateCompanyInfoForIntroduceAndBusinessFragment
        }
    }

    val ORG_ID_FLAG = "org_id_flag"
    val ACTION_FLAG = "action_flag"
    private var action: String? = null

    override fun createAdapter(): BaseQuickAdapter<DecorateCompanyDetailBean, BaseViewHolder> {
        action = arguments.getString(ACTION_FLAG)
        return KtDecorateCompanyInfoForIntroduceAndBusinessAdapter(if ("business" == action) 0 else 1, R.layout.adapter_decorate_company_info_for_introduce_and_business_item_layout, mArrayList)
    }


    public override fun initView(view: View?) {
        super.initView(view)
        setItemDecoration()
    }

    override fun onRefresh() {
        super.onRefresh()
        fillDataFromNet()
    }


    override fun onRequestEnd(requestID: Int) {
        super.onRequestEnd(requestID)
        mSwipeRefreshLayout.isEnabled = false
        mBaseQuickAdapter!!.setEnableLoadMore(false)
    }

    override fun fillDataFromNet() {
        val orgId = arguments.getString(ORG_ID_FLAG)
        action = arguments.getString(ACTION_FLAG)
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_ORGANIZATION.getBaseCompanyInfo(orgId, action))
    }

    override fun <T> onRequestSuccess(requestID: Int, result: T) {
        super.onRequestSuccess(requestID, result)
        if (requestID == 0x0) {
            parseData(result as MutableMap<String, Any>)
        }
    }

    private fun parseData(resultMap: MutableMap<String, Any>) {
        if (!resultMap.isEmpty()) {
            val entries = resultMap.entries
            if (resultMap.containsKey("creatorid")) resultMap.remove("creatorid")
            if (resultMap.containsKey("createtime")) resultMap.remove("createtime")
            if (resultMap.containsKey("service_num")) resultMap.remove("service_num")
            if (resultMap.containsKey("org_id")) resultMap.remove("org_id")
            if (resultMap.containsKey("home_deco")) resultMap.remove("home_deco")
            val tempList = ArrayList<DecorateCompanyDetailBean>()
            for ((key, value) in entries) {
                val decorateCompanyDetailBean = DecorateCompanyDetailBean()
                if ("business" == action) {
                    decorateCompanyDetailBean.businessKey = key
                } else {
                    decorateCompanyDetailBean.introduceKey = key
                }
                decorateCompanyDetailBean.value = value as String
                tempList.add(decorateCompanyDetailBean)
            }
            Collections.sort(tempList) { o1, o2 -> o1.index.compareTo(o2.index) }

            if ("business" != action) {
                val subList = tempList.subList(0, 8)
                val headerView = View.inflate(mContext, R.layout.layout_decorate_company_introduce_header_layout, null)
                val footView = View.inflate(mContext, R.layout.layout_decorate_company_introduce_foot_layout, null)
                val tv_header_content = headerView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_header_content) as TextView
                tv_header_content.text = resultMap["intro"] as String
                val tv_foot_fwqy = footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_fwqy_content) as TextView
                val tv_foot_fwzc = footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_fwzc_content) as TextView
                val tv_foot_cjjw = footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_cjjw_content) as TextView
                val tv_foot_zcfg = footView.findViewById(R.id.id_tv_adapter_decorate_company_introduce_foot_zcfg_content) as TextView
                tv_foot_fwqy.text = resultMap["range_service"] as String
                tv_foot_fwzc.text = resultMap["public_deco"] as String
                tv_foot_cjjw.text = resultMap["accept_price"] as String
                tv_foot_zcfg.text = resultMap["focus_style"] as String
                mBaseQuickAdapter!!.addHeaderView(headerView)
                mBaseQuickAdapter!!.addFooterView(footView)
                mArrayList.addAll(subList)
            } else {
                mArrayList.addAll(tempList)
            }
            mBaseQuickAdapter!!.notifyDataSetChanged()
        }
    }

}