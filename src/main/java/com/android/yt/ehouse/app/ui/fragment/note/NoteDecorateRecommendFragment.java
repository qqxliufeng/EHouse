package com.android.yt.ehouse.app.ui.fragment.note;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.NoteDecorateRecommendAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/28.
 */

public class NoteDecorateRecommendFragment  extends BaseRecycleViewFragment<String>{

    public static NoteDecorateRecommendFragment newInstance() {
        return new NoteDecorateRecommendFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_note_decorate_recommend_layout;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new NoteDecorateRecommendAdapter(R.layout.adapter_index_decorate_note_item_layout,mArrayList);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMySimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        FragmentContainerActivity.startFragmentsActivity(mContext,"日记详情",FragmentContainerActivity.NOTE_DECORATE_INFO_FLAG);
    }
}
