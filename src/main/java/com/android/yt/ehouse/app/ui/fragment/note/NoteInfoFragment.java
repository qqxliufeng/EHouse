package com.android.yt.ehouse.app.ui.fragment.note;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.NoteInfoAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

/**
 * Created by feng on 2017/7/29.
 */

public class NoteInfoFragment extends LroidBaseFragment {


    public static NoteInfoFragment newInstance() {
        return new NoteInfoFragment();
    }

    @BindView(R.id.id_dl_fragment_note_info_container)
    DrawerLayout dl_container;
    @BindView(R.id.id_rv_fragment_note_info)
    RecyclerView rv_info;

    private SectionedRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_info_layout;
    }

    @Override
    protected void initView(View view) {
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv_info.setLayoutManager(layoutManager);
        adapter = new SectionedRecyclerViewAdapter();
        for (int i = 0; i < 2; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add("");
            }
            adapter.addSection(new NoteInfoAdapter("", list));
        }
        rv_info.setAdapter(adapter);
        rv_info.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        getChildFragmentManager().beginTransaction().replace(R.id.id_fl_fragment_note_info_menu_container, NoteInfoStepFragment.newInstance()).commit();
    }

    @OnClick(R.id.test)
    public void onTest(){
        rv_info.smoothScrollToPosition(3);
    }

    @Override
    protected void setComponent() {
    }

    @OnClick(R.id.id_fab_fragment_note_info_step)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_fab_fragment_note_info_step:
                if (dl_container.isDrawerOpen(GravityCompat.END))
                    dl_container.closeDrawer(GravityCompat.END);
                else dl_container.openDrawer(GravityCompat.END);
                break;
        }
    }

}
