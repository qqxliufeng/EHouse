package com.android.yt.ehouse.app.ui.fragment.note;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by feng on 2017/7/28.
 */

public class NoteImagesAdapter extends StatelessSection {

    private String title;
    private List<String> list;

    public NoteImagesAdapter(String title, List<String> list) {
        super(new SectionParameters.Builder(R.layout.test_image_layout)
                .headerResourceId(R.layout.test_header_layout)
                .build());
        this.title = title;
        this.list = list;
    }

    @Override
    public int getContentItemsTotal() {
        return list.isEmpty() ? 0 : list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
//        if (i % 2 == 1){
//            ((ItemViewHolder)viewHolder).viewLine.setVisibility(View.GONE);
//        }else {
//            ((ItemViewHolder)viewHolder).viewLine.setVisibility(View.VISIBLE);
//        }
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        ((HeaderViewHolder) holder).tvTitle.setText(title);
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.text1);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
//        private final View viewLine;

        ItemViewHolder(View view) {
            super(view);
//            viewLine = view.findViewById(R.id.id_view_line);
            imageView = (ImageView) view.findViewById(R.id.image);
        }
    }
}
