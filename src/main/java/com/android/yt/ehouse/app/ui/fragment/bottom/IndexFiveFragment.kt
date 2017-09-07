package com.android.yt.ehouse.app.ui.fragment.bottom

import android.view.View
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment
import kotlinx.android.synthetic.main.fragment_bottom_five_layout.*

/**
 * Created by feng on 2017/6/15.
 */

class IndexFiveFragment : LroidBaseNetFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): IndexFiveFragment {
            return IndexFiveFragment()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_bottom_five_layout
    }

    override fun initView(view: View) {
        id_rl_fragment_bottom_five_step.setOnClickListener {
            KtFragmentContainerActivity.startFragmentsActivity(mContext, "", KtFragmentContainerActivity.MY_NEW_HOUSE_STEP_FLAG)
        }
        id_rl_fragment_bottom_five_message.setOnClickListener {
            KtFragmentContainerActivity.startFragmentsActivity(mContext, "消息", KtFragmentContainerActivity.MY_MESSAGE_FLAG)
        }
        id_iv_fragment_bottom_five_face.setOnClickListener {
            KtFragmentContainerActivity.startFragmentsActivity(mContext, "个人中心", KtFragmentContainerActivity.MY_INFO_FLAG)
        }
    }

}
