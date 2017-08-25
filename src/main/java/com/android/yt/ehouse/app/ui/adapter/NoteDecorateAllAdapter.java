package com.android.yt.ehouse.app.ui.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyNoteBean;
import com.android.yt.ehouse.app.ui.view.RoundedNoNetImageView;
import com.android.yt.ehouse.app.utils.GlideManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2017/7/29.
 */

public class NoteDecorateAllAdapter extends BaseQuickAdapter<DecorateCompanyNoteBean, BaseViewHolder> {

    public NoteDecorateAllAdapter(int layoutResId, List<DecorateCompanyNoteBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DecorateCompanyNoteBean item) {
        RoundedNoNetImageView iv_face = helper.getView(R.id.id_iv_adapter_note_decorate_all_item_face);
        iv_face.setOval(true);
        GlideManager.loadCircleImage(this.mContext, item.getAvatarUrl(), iv_face);

        String nickname = item.getNickname();
        helper.setText(R.id.id_iv_adapter_note_decorate_all_item_name, TextUtils.isEmpty(nickname) ? "暂无" : nickname);
        helper.setText(R.id.id_iv_adapter_note_decorate_all_item_subname, (TextUtils.isEmpty(item.getStr()) ? "暂无" : item.getStr()));
        helper.setText(R.id.id_iv_adapter_note_decorate_all_item_content, item.getContent());
        helper.setText(R.id.id_iv_adapter_note_decorate_all_item_tag, item.getSclassname());
        helper.setText(R.id.id_tv_adapter_note_decorate_all_item_see,item.getHits());
        helper.setText(R.id.id_tv_adapter_note_decorate_all_item_collection,item.getFav_num());
        helper.setText(R.id.id_tv_adapter_note_decorate_all_item_common,item.getComment_num());
        helper.setText(R.id.id_tv_adapter_note_decorate_all_item_time,item.getCreatetime());

        LinearLayout ll_image_container = helper.getView(R.id.id_ll_adapter_note_decorate_all_item_image_container);
        ImageView imageView1 = helper.getView(R.id.id_iv_adapter_note_decorate_all_item_image1);
        ImageView imageView2 = helper.getView(R.id.id_iv_adapter_note_decorate_all_item_image2);
        ImageView imageView3 = helper.getView(R.id.id_iv_adapter_note_decorate_all_item_image3);

        ArrayList<String> imageList = item.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            ll_image_container.setVisibility(View.GONE);
        } else {
            ll_image_container.setVisibility(View.VISIBLE);
            switch (imageList.size()) {
                case 1:
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                    GlideManager.loadImage(this.mContext, imageList.get(0), imageView1);
                    break;
                case 2:
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                    GlideManager.loadImage(this.mContext, imageList.get(0), imageView1);
                    GlideManager.loadImage(this.mContext, imageList.get(1), imageView2);
                    break;
                case 3:
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.VISIBLE);
                    GlideManager.loadImage(this.mContext, imageList.get(0), imageView1);
                    GlideManager.loadImage(this.mContext, imageList.get(1), imageView2);
                    GlideManager.loadImage(this.mContext, imageList.get(2), imageView3);
                    break;
            }
        }
    }
}
