package com.android.yt.ehouse.app.ui.adapter

import android.widget.RatingBar

import com.android.yt.ehouse.app.R
import com.android.yt.ehouse.app.data.bean.DecorateCompanyCommentBean
import com.android.yt.ehouse.app.ui.view.RoundedNoNetImageView
import com.android.yt.ehouse.app.utils.GlideManager
import com.android.yt.ehouse.app.utils.setDefaultText
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder


/**
 * Created by feng on 2017/8/24.
 */

class DecorateCompanyCommentListAdapter(layoutResId: Int, data: List<DecorateCompanyCommentBean>) : BaseQuickAdapter<DecorateCompanyCommentBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: DecorateCompanyCommentBean) {

        helper.setDefaultText(R.id.id_tv_fragment_decorate_company_info_comment_content, item.content)

        helper.setDefaultText(R.id.id_tv_fragment_decorate_company_info_comment_content, item.content)
        helper.setDefaultText(R.id.id_tv_fragment_decorate_company_info_comment_user_name, item.nickname)
        helper.setDefaultText(R.id.id_tv_fragment_decorate_company_info_comment_time, item.time)

        val designScore = item.goods_score
        val serviceScore = item.service_score
        val designScoreFloat = java.lang.Float.parseFloat(designScore)
        val serviceScoreFloat = java.lang.Float.parseFloat(serviceScore)
        val rb_design_score = helper.getView<RatingBar>(R.id.id_rb_fragment_decorate_company_info_comment_design_score)
        val rb_work_score = helper.getView<RatingBar>(R.id.id_rb_fragment_decorate_company_info_comment_work_score)
        val rb_service_score = helper.getView<RatingBar>(R.id.id_rb_fragment_decorate_company_info_comment_service_score)
        rb_design_score.rating = designScoreFloat
        rb_work_score.rating = designScoreFloat
        rb_service_score.rating = serviceScoreFloat

        val iv_face = helper.getView<RoundedNoNetImageView>(R.id.id_iv_fragment_decorate_comment_user_face)
        GlideManager.loadCircleImage(this.mContext, item.avatarUrl, iv_face)
        iv_face.isOval = true
    }
}
