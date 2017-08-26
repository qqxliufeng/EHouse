package com.android.yt.ehouse.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.ui.view.MyGridView;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by feng on 2017/7/31.
 */

public class NoteInfoAdapter extends StatelessSection {

    private ArrayList<String> list;
    private String title;

    public NoteInfoAdapter(String title, ArrayList<String> list) {
        super(new SectionParameters.Builder(R.layout.adapter_note_info_item_layout)
                .headerResourceId(R.layout.adapter_note_info_header_item_layout)
                .footerResourceId(R.layout.adapter_note_info_foot_item_layout)
                .build());
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
        ((ItemHolder) viewHolder).mgv_image.setAdapter(new MyGridViewAdapter(i+4));
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    static class ItemHolder extends RecyclerView.ViewHolder {

        MyGridView mgv_image;

        public ItemHolder(View itemView) {
            super(itemView);
            mgv_image = (MyGridView) itemView.findViewById(R.id.id_mgv);
            mgv_image.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(EHouseApplication.getInstance(), position+"", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    static class MyGridViewAdapter extends BaseAdapter {

        private int count;

        public MyGridViewAdapter(int count){
            this.count = count;
        }


        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return View.inflate(EHouseApplication.getInstance(), R.layout.adapter_note_item_image_layout, null);
        }
    }

}
