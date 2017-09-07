package com.android.yt.ehouse.app.ui.fragment.index

import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.KtIndexBannerBean
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment
import com.android.yt.ehouse.app.ui.view.AutoScrollViewPager
import com.android.yt.ehouse.app.ui.view.IndicatorView
import com.android.yt.ehouse.app.utils.bindView
import java.util.*

/**
 * Created by feng on 2017/8/28.
 */
class KtBannerFragment : LroidBaseFragment(), ViewPager.OnPageChangeListener {

    companion object {
        fun newInstance(): KtBannerFragment {
            return KtBannerFragment()
        }
    }

    val vp_banner: AutoScrollViewPager by bindView(R.id.id_vp_fragment_index_banner)

    val mIndicatorContainer: LinearLayout by bindView(R.id.id_ll_fragment_index_indicator)


    private var bannerAdapter: BannerViewPagerAdapter? = null

    private val imageUrlList = ArrayList<String>()


    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        val count = mIndicatorContainer.childCount
        for (i in 0 until count) {
            if (position % count == i) {
                (mIndicatorContainer.getChildAt(i) as IndicatorView).setSelect(true)
            } else {
                (mIndicatorContainer.getChildAt(i) as IndicatorView).setSelect(false)
            }
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_index_banner_layout
    }


    override fun initView(view: View?) {
        bannerAdapter = BannerViewPagerAdapter(childFragmentManager)
        vp_banner.isCycle = true
        vp_banner.direction = AutoScrollViewPager.RIGHT
        vp_banner.interval = 5000
        vp_banner.setScrollDurationFactor(4.0)
        vp_banner.startAutoScroll()
        vp_banner.addOnPageChangeListener(this)
        vp_banner.offscreenPageLimit = 3
    }

    private fun initIndicator() {
        for (i in imageUrlList.indices) {
            val indicatorView = IndicatorView(mContext)
            val params = LinearLayout.LayoutParams(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6f, resources.displayMetrics).toInt(), TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6f, resources.displayMetrics).toInt())
            params.leftMargin = 10
            params.rightMargin = 10
            indicatorView.layoutParams = params
            indicatorView.setDefaultIndicatorColor(Color.WHITE)
            indicatorView.setFocusedIndicatorColor(ContextCompat.getColor(mContext, R.color.blue))
            mIndicatorContainer.addView(indicatorView, i)
            if (i == 0) {
                indicatorView.setSelect(true)
            }
        }
    }

    fun refresh(tempList: ArrayList<KtIndexBannerBean>) {
        for (indexBanner in tempList) {
            imageUrlList.add(indexBanner.url!!)
        }
        vp_banner.setAdapter(bannerAdapter)
        initIndicator()
    }


    override fun onResume() {
        super.onResume()
        if (!vp_banner.isAutoScroll()) {
            vp_banner.startAutoScroll()
        }
    }

    override fun onStop() {
        super.onStop()
        vp_banner.stopAutoScroll()
    }


    override fun setComponent() {
    }

    inner class BannerViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return ImageRequestFragment.newInstance(imageUrlList.get(position % imageUrlList.size), position == 0)
        }

        override fun getCount(): Int {
            return if (imageUrlList.size == 1) {
                1
            } else Integer.MAX_VALUE
        }
    }

}