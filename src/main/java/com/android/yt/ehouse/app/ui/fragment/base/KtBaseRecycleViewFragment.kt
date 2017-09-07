package com.android.yt.ehouse.app.ui.fragment.base

import android.support.annotation.CallSuper
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.utils.EncodeUtils
import com.android.yt.ehouse.app.utils.MethodUtils
import com.android.yt.ehouse.app.utils.bindView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.listener.OnItemClickListener
import java.util.*

/**
 * Created by feng on 2017/8/29.
 */
abstract class KtBaseRecycleViewFragment<T> : LroidBaseNetFragment(), SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    companion object {
        val COUNT = "count"
    }

    val mRecyclerView: RecyclerView by bindView(R.id.id_rv_fragment_base_recycle_view_content)
    val mSwipeRefreshLayout: SwipeRefreshLayout by bindView(R.id.id_srl_fragment_base_recycle_view_content)
    protected val mFrameLayoutContainer: FrameLayout by bindView(R.id.id_fl_fragment_base_recycle_view_container)


    var mEmptyView: LinearLayout? = null
    var mErrorView: View? = null
    var mBaseQuickAdapter: BaseQuickAdapter<T, BaseViewHolder>? = null
    var mArrayList = ArrayList<T>()

    var MAX_PAGE_COUNT = -1
    var PAGE_SIZE = 15
    var current_page = 1

    override fun getLayoutId(): Int {
        return R.layout.fragment_base_recycle_view_layout
    }

    override fun initView(view: View?) {
        mBaseQuickAdapter = createAdapter()
        if (mBaseQuickAdapter == null) {
            return
        }
        mEmptyView = LayoutInflater.from(mContext).inflate(R.layout.layout_base_recycle_empty_layout, mFrameLayoutContainer, false) as LinearLayout
        mErrorView = LayoutInflater.from(mContext).inflate(R.layout.layout_base_recycle_error_layout, mFrameLayoutContainer, false)
        mEmptyView!!.setOnClickListener(View.OnClickListener { onPostRefresh() })
        mErrorView!!.setOnClickListener(View.OnClickListener { onPostRefresh() })
        mBaseQuickAdapter!!.openLoadAnimation()
        mBaseQuickAdapter!!.setOnLoadMoreListener(this)
        mRecyclerView.adapter = mBaseQuickAdapter
        mRecyclerView.layoutManager = createLayoutManager()
        mRecyclerView.itemAnimator = DefaultItemAnimator()
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mContext, android.R.color.holo_blue_dark), ContextCompat.getColor(mContext, android.R.color.holo_green_dark), ContextCompat.getColor(mContext, android.R.color.holo_orange_dark))
        mSwipeRefreshLayout.setOnRefreshListener(this)
        mRecyclerView.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                onMySimpleItemClick(adapter, view, position)
            }

            override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                onItemViewChildClick(adapter, view, position)
            }
        })
        mSwipeRefreshLayout.post { mSwipeRefreshLayout.isRefreshing = true }
        onRefresh()
    }

    protected fun setItemDecoration() {
        val itemDecoration = DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL)
        //        itemDecoration.setDrawable(ActivityCompat.getDrawable(mContext, R.drawable.divider_bg));
        mRecyclerView.addItemDecoration(itemDecoration)
    }

    protected fun createLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
    }

    protected fun onPostRefreshFalse() {
        mSwipeRefreshLayout.isEnabled = false
    }


    open protected fun fillDataFromNet() {}


    override fun onRequestStart(requestID: Int) {}


    abstract fun createAdapter(): BaseQuickAdapter<T, BaseViewHolder>

    override fun onRequestFail(requestID: Int, e: Throwable) {
        super.onRequestFail(requestID, e)
        showErrorView()
    }

    @CallSuper
    override fun <T> onRequestSuccess(requestID: Int, result: T) {
        super.onRequestSuccess(requestID, result)
    }

    @CallSuper
    override fun onRequestEnd(requestID: Int) {
        mSwipeRefreshLayout.post {
            if (mSwipeRefreshLayout.isRefreshing) {
                mSwipeRefreshLayout.isRefreshing = false
            }
        }
    }

    fun onMySimpleItemClick(baseQuickAdapter: BaseQuickAdapter<*, *>?, view: View?, i: Int) {}

    fun onItemViewChildClick(baseQuickAdapter: BaseQuickAdapter<*, *>?, view: View?, i: Int) {}


    override fun onLoadMoreRequested() {
        mRecyclerView.post {
            if (current_page >= MAX_PAGE_COUNT) {
                mBaseQuickAdapter!!.loadMoreEnd()
            } else {
                current_page++
                onLoadMore()
            }
        }
    }

    protected fun setPagerParam(total: String) {
        if (MAX_PAGE_COUNT == -1) {
            val count = Integer.parseInt(total)
            MAX_PAGE_COUNT = if (count % PAGE_SIZE == 0) count / PAGE_SIZE else count / PAGE_SIZE + 1
        }
    }

    /**
     * 子类若需下拉刷新功能，则直接重写方法
     * 下拉刷新
     */
    @CallSuper
    override fun onRefresh() {
        if (!mArrayList.isEmpty()) {
            mArrayList.clear()
        }
    }

    fun onPostRefresh() {
        mSwipeRefreshLayout.post { mSwipeRefreshLayout.isRefreshing = true }
        onRefresh()
    }

    /**
     * 子类若需上拉加载功能，则直接重写方法
     * 上拉加载
     */
    open protected fun onLoadMore() {}


    /**
     * 处理后台返回的数据
     *
     * @param result    数据源
     * @param clazz     对应的JavaBean.class
     * @param isReverse 是否要进行逆向排序
     * @throws Exception 抛出异常
     */
    @Throws(Exception::class)
    protected fun defaultDealData(result: Map<String, Any>, clazz: Class<T>, isReverse: Boolean) {
        try {
            val map = result as HashMap<String, Any>
            if (map != null && !map.isEmpty()) {
                val listMap = map["list"] as HashMap<String, Any>
                if (listMap != null && !listMap.isEmpty()) {
                    val sortKey = MethodUtils.sortKeys(listMap.keys)
                    val tempList = ArrayList<T>()
                    for (key in sortKey) {
                        val value = listMap[Integer.toString(key)] as HashMap<String, Any>
                        tempList.add(MethodUtils.jsonToBean(EncodeUtils.jsonEncode(value), clazz))
                    }
                    if (isReverse) {
                        Collections.reverse(tempList)
                    }
                    mBaseQuickAdapter!!.addData(tempList)
                    mBaseQuickAdapter!!.loadMoreComplete()
                } else {
                    if (current_page > 1) { //已经加载几页了，没有更多数据了
                        mBaseQuickAdapter!!.loadMoreEnd()
                    } else {//第一在页就没有数据
                        showEmptyView()
                    }
                }
                if (map.containsKey(COUNT)) {
                    setPagerParam(map[COUNT] as String)
                }
            } else {
                showEmptyView()
            }
        } catch (e: Exception) {
            showErrorView()
        }

    }


    fun showEmptyView() {
        mBaseQuickAdapter!!.setEmptyView(mEmptyView)
        mBaseQuickAdapter!!.notifyDataSetChanged()
    }

    fun getEmptyView(): TextView {
        return mEmptyView!!.getChildAt(0) as TextView
    }

    fun showErrorView() {
        mBaseQuickAdapter!!.emptyView = mErrorView
        mBaseQuickAdapter!!.notifyDataSetChanged()
    }

}