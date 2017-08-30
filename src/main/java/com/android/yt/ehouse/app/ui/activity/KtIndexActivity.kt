package com.android.yt.ehouse.app.ui.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.ui.fragment.bottom.*
import kotlinx.android.synthetic.main.activity_index_layout.*

/**
 * Created by feng on 2017/8/29.
 */

val INDEX_BOTTOM_TITLE = arrayOf("首页", "图库", "学装修", "论坛", "我的")
val INDEX_BOTTOM_IMGS = intArrayOf(R.drawable.img_index_bottom_one, R.drawable.img_index_bottom_two, R.drawable.img_index_bottom_three, R.drawable.img_index_bottom_four, R.drawable.img_index_bottom_five)

public class MyIndexViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return KtIndexOneFragment.newInstance()
            1 -> return IndexTwoFragment.newInstance()
            2 -> return IndexThreeFragment.newInstance()
            3 -> return IndexFourFragment.newInstance()
            4 -> return IndexFiveFragment.newInstance()
        }
        return null
    }

    override fun getCount(): Int {
        return INDEX_BOTTOM_TITLE.size
    }
}

class KtIndexActivity : BaseActivity(), TabLayout.OnTabSelectedListener {


    private var exitTime = 0L

    override fun setPresentComponent() {
    }

    override fun initView() {
        setSwipeBackEnable(false)
        id_tl_activity_index_navigation.tabMode = TabLayout.MODE_FIXED
        id_tl_activity_index_navigation.setSelectedTabIndicatorHeight(0)
        id_vp_activity_index_container.adapter = MyIndexViewPagerAdapter(supportFragmentManager)
        id_vp_activity_index_container.offscreenPageLimit = 5
        id_tl_activity_index_navigation.setupWithViewPager(id_vp_activity_index_container)
        id_tl_activity_index_navigation.addOnTabSelectedListener(this)
        initTab()
    }

    private fun initTab() {
        for (i in INDEX_BOTTOM_TITLE.indices) {
            val itemTab = id_tl_activity_index_navigation.getTabAt(i)
            if (itemTab != null) {
                val customBottomView = View.inflate(this, R.layout.layout_home_bottom_bar_item_layout, null)
                itemTab!!.customView = customBottomView
                val iv_bottom = customBottomView.findViewById(R.id.id_iv_home_bottom_bar_img) as ImageView
                val tv_bottom = customBottomView.findViewById(R.id.id_tv_home_bottom_bar_title) as TextView
                tv_bottom.text = INDEX_BOTTOM_TITLE[i]
                iv_bottom.setImageResource(INDEX_BOTTOM_IMGS[i])
                if (i == 0 && itemTab!!.customView != null) {
                    itemTab!!.customView!!.isSelected = true
                    iv_bottom.setColorFilter(ContextCompat.getColor(this, R.color.main_color))
                }
            }
        }
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        for (i in INDEX_BOTTOM_TITLE.indices) {
            val mTab = id_tl_activity_index_navigation.getTabAt(i)
            if (mTab != null) {
                val iv = mTab!!.getCustomView()!!.findViewById(R.id.id_iv_home_bottom_bar_img) as ImageView
                if (tab.position == mTab!!.getPosition()) {
                    iv.setColorFilter(ContextCompat.getColor(this, R.color.main_color))
                } else {
                    iv.setColorFilter(ContextCompat.getColor(this, R.color.gray))
                }
            }
        }
    }


    override fun onTabUnselected(tab: TabLayout.Tab) {}

    override fun onTabReselected(tab: TabLayout.Tab) {}


    override fun getLayoutId(): Int {
        return R.layout.activity_index_layout
    }



    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            exitTime = System.currentTimeMillis()
            Toast.makeText(this, "再按一次退出客户端", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }
    }


}