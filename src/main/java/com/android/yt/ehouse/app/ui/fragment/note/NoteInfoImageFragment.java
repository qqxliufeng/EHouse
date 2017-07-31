package com.android.yt.ehouse.app.ui.fragment.note;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

/**
 * Created by feng on 2017/7/28.
 */

public class NoteInfoImageFragment extends LroidBaseFragment{

    public static NoteInfoImageFragment newInstance() {
        return new NoteInfoImageFragment();
    }

    @BindView(R.id.id_test_rv)
    RecyclerView recyclerView;

    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_image_layout;
    }

    @Override
    protected void initView(View view) {
        sectionAdapter = new SectionedRecyclerViewAdapter();
        for (int i = 0; i < 9; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                list.add(i+" content "+j);
            }
            sectionAdapter.addSection(new NoteImagesAdapter("item"+i, list));
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(sectionAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sectionAdapter);
    }

    @Override
    protected void setComponent() {
    }

}
