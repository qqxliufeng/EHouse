package com.android.yt.ehouse.app.ui.fragment.user

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.View

import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment

import com.android.yt.ehouse.app.utils.bindView

/**
 * Created by feng on 2017/7/26.
 */

class LoginFragment : LroidBaseFragment() {

    private val tl_title: TabLayout by bindView(R.id.id_tl_fragment_login_container_title)
    private val vp_content: ViewPager by bindView(R.id.id_vp_fragment_login_container_content)

    override fun getLayoutId(): Int {
        return R.layout.fragment_login_container_layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (mContext as KtFragmentContainerActivity).setAppBarVisibility(View.GONE)
    }

    override fun initView(view: View) {
        vp_content.adapter = LoginViewPagerAdapter(childFragmentManager)
        tl_title.setupWithViewPager(vp_content)
    }

    override fun setComponent() {}

    internal class LoginViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return if (position == 0) LoginByPhoneFragment.newInstance() else LoginByPasswordFragment.newInstance()
        }

        override fun getCount(): Int {
            return TITLE.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return TITLE[position]
        }
    }

    companion object {

        internal val TITLE = arrayOf("快速登录", "帐号登录")

        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

}
