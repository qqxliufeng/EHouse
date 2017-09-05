package com.android.yt.ehouse.app.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.bindView
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.application.EHouseApplication
import com.android.yt.ehouse.app.component.ApiService
import com.android.yt.ehouse.app.ui.fragment.base.ClassifySearchFragment
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment
import com.android.yt.ehouse.app.ui.fragment.base.TypeHallFragment
import com.android.yt.ehouse.app.ui.fragment.bbs.BBSCreateFragment
import com.android.yt.ehouse.app.ui.fragment.decorate.*
import com.android.yt.ehouse.app.ui.fragment.financing.FinancingListFragment
import com.android.yt.ehouse.app.ui.fragment.house.HouseHallFragment
import com.android.yt.ehouse.app.ui.fragment.house.HouseInfoFragment
import com.android.yt.ehouse.app.ui.fragment.house.HouseListFragment
import com.android.yt.ehouse.app.ui.fragment.house.HouseSellFragment
import com.android.yt.ehouse.app.ui.fragment.materials.MaterialsInfoFragment
import com.android.yt.ehouse.app.ui.fragment.materials.MaterialsListFragment
import com.android.yt.ehouse.app.ui.fragment.note.*
import com.android.yt.ehouse.app.ui.fragment.shoppingcar.ShoppingCarEmptyFragment
import com.android.yt.ehouse.app.ui.fragment.shoppingcar.ShoppingCarFragment
import com.android.yt.ehouse.app.ui.fragment.user.*
import javax.inject.Inject

/**
 * Created by feng on 2017/8/29.
 */
class KtFragmentContainerActivity : BaseActivity(){

    companion object {
        val TITLE_FLAG = "title_flag"
        val FRAGMENT_FLAG = "fragment_flag"
        val EXTRA_FLAG = "extra_flag"


        val WEB_CONTENT_CONTAINER_FLAG = 0x0
        @JvmStatic
        val CLASSIFY_SEARCH_FLAG = 0x1
        val HOUSE_HALL_FLAG = 0x2
        val TYPE_HALL_FLAG = 0x3
        val DECORATE_INDEX_FLAG = 0x4
        val HOUSE_LIST_FLAG = 0x5
        val DECORATE_COMPANY_LIST_FLAG = 0x6
        val MATERIALS_LIST_FLAG = 0x7
        val HOUSE_INFO_FLAG = 0x8
        val DECORATE_COMPANY_INFO_FLAG = 0x9
        val SHOPPING_CAR_FLAG = 0x10
        val SHOPPING_CAR_EMPTY_FLAG = 0x11
        val HOUSE_SELL_FLAG = 0x12
        val MATERIALS_INFO_FLAG = 0x13
        val LOGIN_FLAG = 0x14
        val REGISTER_FLAG = 0x15
        val DECORATE_VIDEO_LIST_FLAG = 0x16
        val DECORATE_FENG_SHUI_FLAG = 0x17
        val DECORATE_SELECT_MATERIAL_ARTICLE_FLAG = 0x18
        val NOTE_IMAGES_FLAG = 0x19
        val NOTE_DECORATE_STEP_FLAG = 0x20
        val NOTE_DECORATE_LIST_FLAG = 0x21
        val NOTE_EDIT_FlAG = 0x22
        val NOTE_DECORATE_TAG_FLAG = 0x23
        val NOTE_DECORATE_INFO_FLAG = 0x24
        val BBS_CREATE_FLAG = 0x25
        val DECORATE_CASE_LIST_FLAG = 0x26
        val DECORATE_CASE_INFO_FLAG = 0x27
        val FINANCING_LIST_FLAG = 0x28
        val MY_NEW_HOUSE_STEP_FLAG = 0x29
        val MY_MESSAGE_FLAG = 0x30
        val MY_INFO_FLAG = 0x31
        val MY_INFO_ADDRESS_FLAG = 0x32
        val DECORATE_COMPANY_INFO_INTRODUCE_AND_BUSINESS_FLAG = 0x33
        val DECORATE_COMPANY_INFO_CERTIFICATE_FLAG = 0x34
        val DECORATE_COMPANY_DESIGN_LIST_FRAGMENT_FLAG = 0x35
        val DECORATE_COMPANY_COMMENT_LIST_FRAGMENT_FLAG = 0x36
        val DECORATE_COMPANY_NOTE_LIST_FRAGMENT_FLAG = 0x37


        fun startFragmentsActivity(context: Context, title: String, id: Int, extra: Bundle) {
            val intent = Intent(context, KtFragmentContainerActivity::class.java)
            intent.putExtra(KtFragmentContainerActivity.FRAGMENT_FLAG, id)
            intent.putExtra(KtFragmentContainerActivity.TITLE_FLAG, title)
            intent.putExtra(KtFragmentContainerActivity.EXTRA_FLAG, extra)
            context.startActivity(intent)
        }

        fun startFragmentsActivity(context: Context, title: String, id: Int) {
            val intent = Intent(context, KtFragmentContainerActivity::class.java)
            intent.putExtra(KtFragmentContainerActivity.FRAGMENT_FLAG, id)
            intent.putExtra(KtFragmentContainerActivity.TITLE_FLAG, title)
            context.startActivity(intent)
        }

    }

   private val mToolBar: Toolbar by bindView(R.id.id_tl_home_tool_bar)
   private val mAppBarLayout: AppBarLayout by bindView(R.id.id_abl_home_tool_bar_container)

   private val fl_container: FrameLayout by bindView(R.id.id_fl_activity_fragment_container)

    private var currentFragment: LroidBaseFragment? = null


    override fun getLayoutId(): Int = R.layout.activity_fragment_container_layout

    fun setAppBarVisibility(visibility: Int) {
        mAppBarLayout.visibility = visibility
        setSupportActionBar(null)
    }

    override fun setPresentComponent() {
    }

    override fun initView() {
        initFragment()
    }

    private fun initFragment() {
        mToolBar.title = intent.getStringExtra(TITLE_FLAG)
        mToolBar.setTitleTextColor(Color.parseColor("#666666"))
        setSupportActionBar(mToolBar)
        val bar = supportActionBar
        bar?.setDisplayHomeAsUpEnabled(true)
        mToolBar.setNavigationOnClickListener { scrollToFinishActivity() }
        val fragmentId = intent.getIntExtra(FRAGMENT_FLAG, 0x0)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when (fragmentId) {
            WEB_CONTENT_CONTAINER_FLAG -> {
            }
            CLASSIFY_SEARCH_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, ClassifySearchFragment.newInstance())
            HOUSE_HALL_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, HouseHallFragment.newInstance())
            TYPE_HALL_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, TypeHallFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            DECORATE_INDEX_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateIndexFragment.newInstance())
            HOUSE_LIST_FLAG -> {
                val houseListFragment = HouseListFragment.newInstance()
                currentFragment = houseListFragment
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, houseListFragment)
            }
            DECORATE_COMPANY_LIST_FLAG -> {
                val decorateCompanyListFragment = DecorateCompanyListFragment.newInstance()
                currentFragment = decorateCompanyListFragment
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, decorateCompanyListFragment)
            }
            MATERIALS_LIST_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MaterialsListFragment.newInstance())
            MATERIALS_INFO_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MaterialsInfoFragment.newInstance())
            HOUSE_INFO_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, HouseInfoFragment.newInstance())
            DECORATE_COMPANY_INFO_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCompanyInfoFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            SHOPPING_CAR_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, ShoppingCarFragment.newInstance())
            SHOPPING_CAR_EMPTY_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, ShoppingCarEmptyFragment.newInstance())
            HOUSE_SELL_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, HouseSellFragment.newInstance())
            LOGIN_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, LoginFragment.newInstance())
            REGISTER_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, RegisterFragment.newInstance())
            DECORATE_VIDEO_LIST_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateVideoListFragment.newInstance())
            DECORATE_FENG_SHUI_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateFengShuiFragment.newInstance())
            DECORATE_SELECT_MATERIAL_ARTICLE_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateSelectMaterialFragment.newInstance())
            NOTE_IMAGES_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, NoteInfoImageFragment.newInstance())
            NOTE_DECORATE_STEP_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, NoteDecorateStepFragment.newInstance())
            NOTE_DECORATE_LIST_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, NoteDecorateListFragment.newInstance())
            NOTE_EDIT_FlAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, NoteEditFragment.newInstance())
            NOTE_DECORATE_TAG_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, NoteDecorateTagFragment.newInstance())
            NOTE_DECORATE_INFO_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, NoteInfoFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            BBS_CREATE_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, BBSCreateFragment.newInstance())
            DECORATE_CASE_LIST_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCaseListFragment.newInstance())
            DECORATE_CASE_INFO_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCaseInfoFragment.newInstance())
            FINANCING_LIST_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, FinancingListFragment.newInstance())
            MY_NEW_HOUSE_STEP_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MyNewHouseStepFragment.newInstance())
            MY_MESSAGE_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MyMessageFragment.newInstance())
            MY_INFO_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MyUserInfoFragment.newInstance())
            MY_INFO_ADDRESS_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MyUserInfoAddressFragment.newInstance())
            DECORATE_COMPANY_INFO_INTRODUCE_AND_BUSINESS_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, KtDecorateCompanyInfoForIntroduceAndBusinessFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            DECORATE_COMPANY_INFO_CERTIFICATE_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCompanyInfoForCertificateFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            DECORATE_COMPANY_DESIGN_LIST_FRAGMENT_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCompanyDesignListFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            DECORATE_COMPANY_NOTE_LIST_FRAGMENT_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCompanyNoteListFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
            DECORATE_COMPANY_COMMENT_LIST_FRAGMENT_FLAG -> fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateCompanyCommentListFragment.newInstance(intent.getBundleExtra(EXTRA_FLAG)))
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (currentFragment != null) {
            if (currentFragment?.onBackPress()!!) {
                currentFragment?.onBackPressProcess()
                return
            }
        }
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (currentFragment != null) {
            currentFragment = null
        }
    }

}