package com.android.yt.ehouse.app.ui.fragment.house

import android.os.Bundle
import android.view.View

import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.HouseItemDetailInfoBean
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment
import com.android.yt.ehouse.app.utils.setDefaultText
import kotlinx.android.synthetic.main.fragment_house_info_house_generalize_layout.*

/**
 * Created by feng on 2017/7/4.
 */

class HouseInfoHouseGeneralizeFragment : LroidBaseFragment() {

    override fun initView(view: View?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_house_info_house_generalize_layout
    }

    override fun setComponent() {}

    fun onRefresh(infoForInfoBean: HouseItemDetailInfoBean.HouseItemDetailInfoForInfoBean,
                  descriptionBean: HouseItemDetailInfoBean.HouseItemDetailInfoForCommunityBeanDescription) {
        id_iv_fragment_house_info_generalize_title.setDefaultText(infoForInfoBean.title)
        id_iv_fragment_house_info_generalize_price.setDefaultText(infoForInfoBean.price + "万")
        id_iv_fragment_house_info_generalize_house_type.setDefaultText(infoForInfoBean.compose)
        id_iv_fragment_house_info_generalize_area.setDefaultText(infoForInfoBean.area + "㎡")
        id_iv_fragment_house_info_generalize_single_price.setDefaultText(infoForInfoBean.unitprice + "元")
        id_iv_fragment_house_info_generalize_floor_count.setDefaultText(infoForInfoBean.floor_num + "(共" + infoForInfoBean.floor_max + "层)")
        id_iv_fragment_house_info_generalize_address1.setDefaultText(infoForInfoBean.area_name + "-" + infoForInfoBean.address)
        id_iv_fragment_house_info_generalize_house_year_old.setDefaultText(descriptionBean.building_time)
        id_iv_fragment_house_info_generalize_chanquan.setDefaultText(descriptionBean.property_rights)
        id_iv_fragment_house_info_generalize_decorate.setDefaultText(descriptionBean.decoration_str)
        id_iv_fragment_house_info_generalize_house_type1.setDefaultText(descriptionBean.house_type_str)
        id_iv_fragment_house_info_generalize_description.setDefaultText(descriptionBean.describe)
    }

    companion object {
        fun newInstance(): HouseInfoHouseGeneralizeFragment {
            val args = Bundle()
            val fragment = HouseInfoHouseGeneralizeFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
