package com.android.yt.ehouse.app.ui.fragment.decorate;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import java.util.ArrayList;

import butterknife.BindView;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseInfoForMaterialMenuFragment extends LroidBaseNetFragment {

    public static DecorateCaseInfoForMaterialMenuFragment newInstance(ArrayList<String> list) {
        Bundle args = new Bundle();
        args.putStringArrayList("list", list);
        DecorateCaseInfoForMaterialMenuFragment fragment = new DecorateCaseInfoForMaterialMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_rv_fragment_decorate_case_info_material_list_menu)
    RecyclerView rv_menu;

    private SectionedRecyclerViewAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_case_info_material_list_menu_layout;
    }

    @Override
    protected void initView(View view) {
        adapter = new SectionedRecyclerViewAdapter();
        final ArrayList<String> list = getArguments().getStringArrayList("list");
        adapter.addSection(new DecorateCaseInfoMaterialListMenuAdapter("title", list, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((DecorateCaseInfoForMaterialListFragment) getParentFragment()).onSmoothScrollToPosition(list.get(position),position);
            }
        }));
        rv_menu.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_menu.setAdapter(adapter);
    }


    static class DecorateCaseInfoMaterialListMenuAdapter extends StatelessSection {

        private String title;
        private ArrayList<String> list;

        private AdapterView.OnItemClickListener onItemClickListener;

        public DecorateCaseInfoMaterialListMenuAdapter(String title, ArrayList<String> list, AdapterView.OnItemClickListener onItemClickListener) {
            super(new SectionParameters.Builder(R.layout.adapter_note_info_step_item_layout).headerResourceId(android.R.layout.simple_list_item_1).build());
            this.title = title;
            this.list = list;
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public int getContentItemsTotal() {
            return list == null || list.isEmpty() ? 0 : list.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            ((ItemViewHolder) viewHolder).ll_container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(null, v, i, i);
                }
            });
            if (i == list.size() - 1) {
                ((ItemViewHolder) viewHolder).viewLine.setVisibility(View.GONE);
            } else {
                ((ItemViewHolder) viewHolder).viewLine.setVisibility(View.VISIBLE);
            }
            ((ItemViewHolder) viewHolder).tv_name.setText(list.get(i));
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            ((HeaderViewHolder) holder).tv_title.setText(title);
        }

        static class ItemViewHolder extends RecyclerView.ViewHolder {

            View viewLine;
            LinearLayout ll_container;
            TextView tv_name;

            public ItemViewHolder(View itemView) {
                super(itemView);
                ll_container = (LinearLayout) itemView.findViewById(R.id.id_ll_adapter_note_info_step_item_container);
                tv_name = (TextView) itemView.findViewById(R.id.id_tv_adapter_note_info_step_item_name);
                viewLine = itemView.findViewById(R.id.id_view_adapter_note_step_item_line);
            }
        }

        static class HeaderViewHolder extends RecyclerView.ViewHolder {

            TextView tv_title;

            public HeaderViewHolder(View headerView) {
                super(headerView);
                tv_title = (TextView) headerView.findViewById(android.R.id.text1);
            }
        }
    }


}
