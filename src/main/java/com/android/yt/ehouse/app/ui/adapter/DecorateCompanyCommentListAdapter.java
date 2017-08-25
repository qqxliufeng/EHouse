package com.android.yt.ehouse.app.ui.adapter;

import android.widget.RatingBar;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyCommentBean;
import com.android.yt.ehouse.app.ui.view.RoundedNoNetImageView;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyCommentListAdapter extends BaseQuickAdapter<DecorateCompanyCommentBean,BaseViewHolder>{

    public DecorateCompanyCommentListAdapter(int layoutResId, List<DecorateCompanyCommentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DecorateCompanyCommentBean item) {
        helper.setText(R.id.id_tv_fragment_decorate_company_info_comment_content,item.getContent());
        helper.setText(R.id.id_tv_fragment_decorate_company_info_comment_user_name,item.getNickname());
        helper.setText(R.id.id_tv_fragment_decorate_company_info_comment_time,item.getTime());

        String designScore = item.getGoods_score();
        String serviceScore = item.getService_score();
        float designScoreFloat = Float.parseFloat(designScore);
        float serviceScoreFloat = Float.parseFloat(serviceScore);
        RatingBar rb_design_score = helper.getView(R.id.id_rb_fragment_decorate_company_info_comment_design_score);
        RatingBar rb_work_score = helper.getView(R.id.id_rb_fragment_decorate_company_info_comment_work_score);
        RatingBar rb_service_score = helper.getView(R.id.id_rb_fragment_decorate_company_info_comment_service_score);
        rb_design_score.setRating(designScoreFloat);
        rb_work_score.setRating(designScoreFloat);
        rb_service_score.setRating(serviceScoreFloat);

        RoundedNoNetImageView iv_face = helper.getView(R.id.id_iv_fragment_decorate_comment_user_face);
        GlideManager.loadCircleImage(this.mContext, item.getAvatarUrl(), iv_face);
        iv_face.setOval(true);
    }
}
