package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateCaseInfoForMaterialListAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseInfoForMaterialListFragment extends LroidBaseNetFragment {


    public static DecorateCaseInfoForMaterialListFragment newInstance() {
        Bundle args = new Bundle();
        DecorateCaseInfoForMaterialListFragment fragment = new DecorateCaseInfoForMaterialListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_dl_fragment_decorate_case_info_for_material_container)
    DrawerLayout dl_container;
    @BindView(R.id.id_rv_fragment_decorate_case_info_material_list)
    RecyclerView rv_list;

    private LinearLayoutManager layoutManager;
    private SectionedRecyclerViewAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_decorate_case_info_for_material_list_layout;
    }

    @Override
    public void initView(View view) {
        ArrayList<String> secondList = new ArrayList<>();
        adapter = new SectionedRecyclerViewAdapter();
        for (int i = 0; i < 5; i++) {
            secondList.add("second" + i);
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                list.add("");
            }
            adapter.addSection(secondList.get(i),new DecorateCaseInfoForMaterialListAdapter(secondList.get(i), list));
        }
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        layoutManager.setStackFromEnd(true);
        rv_list.setLayoutManager(layoutManager);
        rv_list.setAdapter(adapter);
        dl_container.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_decorate_case_info_for_material_menu_container,
                        DecorateCaseInfoForMaterialMenuFragment.newInstance(secondList))
                .commit();
    }

    public void onSmoothScrollToPosition(String tag, int position) {
        if (position != RecyclerView.NO_POSITION) {
            dl_container.closeDrawer(GravityCompat.END);
            position = adapter.getSectionPosition(tag);
            layoutManager.scrollToPositionWithOffset(position, 0);
        }
    }


    @OnClick(R.id.id_fab_fragment_decorate_case_info_for_material_list)
    public void onFabClick() {
        if (dl_container.isDrawerOpen(GravityCompat.END)) {
            dl_container.closeDrawer(GravityCompat.END);
        } else {
            dl_container.openDrawer(GravityCompat.END);
        }
    }

}
