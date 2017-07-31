package com.android.yt.ehouse.app.ui.fragment.note;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.NoteDecorateTagAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

/**
 * Created by feng on 2017/7/29.
 */

public class NoteDecorateTagFragment extends BaseRecycleViewFragment<String> {

    public static NoteDecorateTagFragment newInstance() {
        return new NoteDecorateTagFragment();
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new NoteDecorateTagAdapter(R.layout.adapter_note_decorate_tag_item_layout, mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        View topView = View.inflate(mContext, R.layout.layout_note_decorate_tag_top_layout, null);
        mBaseQuickAdapter.addHeaderView(topView, 0);
        mRecyclerView.setBackgroundColor(Color.WHITE);
        mRecyclerView.setLayoutManager(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 4 : 1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mSwipeRefreshLayout.setEnabled(false);
        mBaseQuickAdapter.setEnableLoadMore(false);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) topView.findViewById(R.id.id_tfl_note_decorate_tag_container);
        ArrayList<String> tagList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
           tagList.add("item"+1);
        }
        tagFlowLayout.setAdapter(new TagAdapter<String>(tagList) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                return View.inflate(mContext,R.layout.adapter_note_decorate_tag_item_layout,null);
            }
        });
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        onRequestEnd(-1);
        for (int i = 0; i < 50; i++) {
            mArrayList.add("item" + i);
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
