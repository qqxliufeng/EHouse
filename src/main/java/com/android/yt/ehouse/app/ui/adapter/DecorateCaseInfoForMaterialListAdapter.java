package com.android.yt.ehouse.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by feng on 2017/8/1.
 */

public class DecorateCaseInfoForMaterialListAdapter extends StatelessSection {

    private String title;
    private ArrayList<String> list;

    public DecorateCaseInfoForMaterialListAdapter(String title, ArrayList<String> list) {
        super(new SectionParameters.Builder(R.layout.adapter_decorate_case_info_for_material_item_layout).headerResourceId(R.layout.adapter_decorate_case_info_for_material_header_layout).footerResourceId(R.layout.adapter_note_info_foot_item_layout).build());
        this.title = title;
        this.list = list;
    }

    @Override
    public int getContentItemsTotal() {
        return list == null || list.isEmpty() ? 0 : list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        ((HeaderHolder) holder).tv_title.setText(title);
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {

        TextView tv_title;

        public HeaderHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.id_tv_adapter_decorate_case_info_for_material_header_name);
        }
    }

    static class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(View itemView) {
            super(itemView);
        }
    }

}
