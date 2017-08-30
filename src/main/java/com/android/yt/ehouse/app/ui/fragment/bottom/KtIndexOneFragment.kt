package com.android.yt.ehouse.app.ui.fragment.bottom

import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.*
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment
import com.android.yt.ehouse.app.ui.fragment.base.TypeHallFragment
import com.android.yt.ehouse.app.ui.fragment.house.HouseHallFragment
import com.android.yt.ehouse.app.ui.fragment.index.*
import com.android.yt.ehouse.app.utils.EncodeUtils
import com.android.yt.ehouse.app.utils.MethodUtils
import com.android.yt.ehouse.app.utils.RequestParamsHelper
import java.util.*

/**
 * Created by feng on 2017/8/28.
 */
class KtIndexOneFragment : LroidBaseNetFragment() {

    companion object {
        fun newInstance(): KtIndexOneFragment {
            return KtIndexOneFragment()
        }
    }

    private val nestedScrollView: NestedScrollView by bindView(R.id.id_sv_fragment_bottom_one_container)

    private val tv_fcdt: TextView by bindView(R.id.id_tv_fragment_bottom_one_fcdt)
    private val tv_jc: TextView by bindView(R.id.id_tv_fragment_bottom_one_jiancai)
    private val tv_decorate: TextView by bindView(R.id.id_tv_fragment_bottom_one_decorate)
    private val tv_jz: TextView by bindView(R.id.id_tv_fragment_bottom_one_jiazheng)
    private val tv_lc: TextView by bindView(R.id.id_tv_fragment_bottom_one_licai)
    private val tv_zh: TextView by bindView(R.id.id_tv_fragment_bottom_one_zhanhui)
    private val tv_tsjy: TextView by bindView(R.id.id_tv_fragment_bottom_one_tsjy)
    private val ll_fs: LinearLayout by bindView(R.id.id_ll_fragment_bottom_one_fengshui)


    private var decorateNoteFragment: DecorateNoteFragment? = null
    private var decorateStrategyFragment: DecorateStrategyFragment? = null
    private var decorateResultFragment: DecorateResultFragment? = null
    private var bannerFragment: KtBannerFragment? = null


    override fun getLayoutId(): Int {
        return R.layout.fragment_bottom_one_layout
    }

    override fun initView(view: View?) {
        tv_fcdt.setOnClickListener(this)
        tv_jc.setOnClickListener(this)
        tv_decorate.setOnClickListener(this)
        tv_jz.setOnClickListener(this)
        tv_lc.setOnClickListener(this)
        tv_zh.setOnClickListener(this)
        tv_tsjy.setOnClickListener(this)
        ll_fs.setOnClickListener(this)
        nestedScrollView.post { nestedScrollView.fullScroll(NestedScrollView.FOCUS_UP) }
        decorateNoteFragment = DecorateNoteFragment.newInstance()
        decorateStrategyFragment = DecorateStrategyFragment.newInstance()
        decorateResultFragment = DecorateResultFragment.newInstance()
        bannerFragment = KtBannerFragment.newInstance()
        childFragmentManager
                .beginTransaction()
                .replace(R.id.id_fl_fragment_index_banner_layout, bannerFragment)
                .replace(R.id.id_fl_fragment_index_zxal_container, DecorateCaseFragment.newInstance())
                .replace(R.id.id_fl_fragment_index_zxxg_container, decorateResultFragment)
                .replace(R.id.id_fl_fragment_index_zxrj_container, decorateNoteFragment)
                .replace(R.id.id_fl_fragment_index_zxgl_container, decorateStrategyFragment)
                .replace(R.id.id_fl_fragment_index_sctm_container, MallSpecialFragment.newInstance())
                .commit()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_COMMON.getCommonIndex())
    }


    override fun <T> onRequestSuccess(requestID: Int, result: T) {
        super.onRequestSuccess(requestID, result)
        val resultMap = result as HashMap<String, Any>
        val adMap = resultMap["ad"] as HashMap<String, Any>
        val pictureMap = resultMap["picture"] as HashMap<String, Any>
        val diaryMap = resultMap["diary"] as HashMap<String, Any>
        val articleMap = resultMap["article"] as HashMap<String, Any>
        val goodsMap = resultMap["goods"] as HashMap<String, Any>
        val indexBannerBeanArrayList = parseData(adMap, KtIndexBannerBean::class.java)
        if (indexBannerBeanArrayList != null) {
            bannerFragment?.refresh(indexBannerBeanArrayList)
        }
        val decorateImageBeanArrayList = parseData(pictureMap, DecorateImageBean::class.java)
        if (decorateImageBeanArrayList != null) {
            decorateResultFragment?.refresh(decorateImageBeanArrayList)
        }
        val decorateNoteBeanArrayList = parseData(diaryMap, IndexDecorateNoteBean::class.java)
        if (decorateNoteBeanArrayList != null) {
            decorateNoteFragment?.refresh(decorateNoteBeanArrayList)
        }
        val decorateStrategyBeanArrayList = parseData(articleMap, DecorateStrategyBean::class.java)
        if (decorateStrategyBeanArrayList != null) {
            decorateStrategyFragment?.refresh(decorateStrategyBeanArrayList)
        }
        val goodsBeanArrayList = parseData(goodsMap, KtIndexGoodsBean::class.java)
        if (goodsBeanArrayList != null) {
            //待开发功能
        }
    }

    private fun <T> parseData(map: HashMap<String, Any>?, clazz: Class<T>): ArrayList<T>? {
        if (map != null && !map.isEmpty()) {
            val listMap = map["list"] as HashMap<String, Any>
            if (!listMap.isEmpty()) {
                return  MethodUtils.sortKeys(listMap.keys).map { listMap[Integer.toString(it)] as HashMap<String, Any> }.mapTo(ArrayList<T>()) { MethodUtils.jsonToBean(EncodeUtils.jsonEncode(it), clazz) }
            }
        }
        return null
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.id_tv_fragment_bottom_one_fcdt -> KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, HouseHallFragment.TITLE, KtFragmentContainerActivity.Companion.HOUSE_HALL_FLAG)
            R.id.id_tv_fragment_bottom_one_jiancai -> {
                val bundle = Bundle()
                bundle.putInt(TypeHallFragment.CURRENT_TYPE_FLAG, TypeHallFragment.MATERIALS_FLAG)
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, getString(R.string.string_empty), KtFragmentContainerActivity.Companion.TYPE_HALL_FLAG, bundle)
            }
            R.id.id_tv_fragment_bottom_one_jiaju -> {
                val bundle1 = Bundle()
                bundle1.putInt(TypeHallFragment.CURRENT_TYPE_FLAG, TypeHallFragment.HOUSE_HOME_FLAG)
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, getString(R.string.string_empty), KtFragmentContainerActivity.Companion.TYPE_HALL_FLAG, bundle1)
            }
            R.id.id_tv_fragment_bottom_one_jiazheng -> {
                val bundle2 = Bundle()
                bundle2.putInt(TypeHallFragment.CURRENT_TYPE_FLAG, TypeHallFragment.HOUSEKEEPING_FLAG)
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, getString(R.string.string_empty), KtFragmentContainerActivity.Companion.TYPE_HALL_FLAG, bundle2)
            }
            R.id.id_tv_fragment_bottom_one_decorate -> KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, getString(R.string.string_decorate), KtFragmentContainerActivity.Companion.DECORATE_INDEX_FLAG)
            R.id.id_tv_fragment_bottom_one_licai ->
                //                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "购物车", KtFragmentContainerActivity.Companion.SHOPPING_CAR_FLAG);
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "理财", KtFragmentContainerActivity.Companion.FINANCING_LIST_FLAG)
            R.id.id_tv_fragment_bottom_one_zhanhui -> KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "购物车", KtFragmentContainerActivity.Companion.SHOPPING_CAR_EMPTY_FLAG)
            R.id.id_tv_fragment_bottom_one_tsjy -> KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "", KtFragmentContainerActivity.Companion.LOGIN_FLAG)
            R.id.id_ll_fragment_bottom_one_fengshui -> KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "", KtFragmentContainerActivity.Companion.NOTE_DECORATE_STEP_FLAG)
        }
    }


}
