package com.android.yt.ehouse.app.ui.fragment.house

import android.os.Bundle
import android.view.View

import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.HouseItemDetailInfoBean
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment
import com.android.yt.ehouse.app.utils.setDefaultText
import kotlinx.android.synthetic.main.fragment_house_info_village_generalize_layout.*

/**
 * Created by feng on 2017/7/4.
 */

class HouseInfoVillageGeneralizeFragment : LroidBaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_house_info_village_generalize_layout
    }

    override fun initView(view: View) {}

    override fun setComponent() {

    }

    fun onRefresh(communityBean: HouseItemDetailInfoBean.HouseItemDetailInfoForCommunityBean?) {

        id_tv_fragment_house_info_village_generalize_address.setDefaultText(communityBean?.address)

        id_tv_fragment_house_info_village_generalize_area.setDefaultText(communityBean?.floor_area)
        id_tv_fragment_house_info_village_generalize_house_count.setDefaultText(communityBean?.households_num)
        id_tv_fragment_house_info_village_generalize_rjl.setDefaultText(communityBean?.plot_ratio)

        id_tv_fragment_house_info_village_generalize_car_park_count.setDefaultText(communityBean?.parking_space)
        id_tv_fragment_house_info_village_generalize_lhl.setDefaultText(communityBean?.greening_rate)
        id_tv_fragment_house_info_village_generalize_wyf.setDefaultText(communityBean?.property_fee)

    }

    companion object {

        fun newInstance(): HouseInfoVillageGeneralizeFragment {
            val args = Bundle()

            val fragment = HouseInfoVillageGeneralizeFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
