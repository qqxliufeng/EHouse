package com.android.yt.ehouse.app.ui.fragment.index;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyNoteBean;
import com.android.yt.ehouse.app.data.bean.IndexDecorateNoteBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.view.MyGridView;
import com.android.yt.ehouse.app.utils.GlideManager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by feng on 2017/6/15.
 */

public class DecorateNoteFragment extends LroidBaseNetFragment {


    public static DecorateNoteFragment newInstance() {
        return new DecorateNoteFragment();
    }

    @BindView(R.id.id_gv_decorate_note_container)
    MyGridView mGridView;

    private ArrayList<IndexDecorateNoteBean> mArrayList = new ArrayList<>();
    private MyDecorateNoteGridViewAdapter myDecorateNoteGridViewAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_decorate_note_layout;
    }

    @Override
    protected void initView(View view) {
        mGridView.setFocusable(false);
        myDecorateNoteGridViewAdapter = new MyDecorateNoteGridViewAdapter();
        mGridView.setAdapter(myDecorateNoteGridViewAdapter);
    }

    public void refresh(ArrayList<IndexDecorateNoteBean> tempList) {
        if (myDecorateNoteGridViewAdapter != null && tempList != null && !tempList.isEmpty()) {
            mArrayList.addAll(tempList);
            myDecorateNoteGridViewAdapter.notifyDataSetChanged();
        }
    }


    class MyDecorateNoteGridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mArrayList.isEmpty()) {
                return 0;
            }
            return mArrayList.size() > 2 ? 2 : mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mContext, R.layout.adapter_index_decorate_note_item_layout, null);
            TextView tv_collection_count = (TextView) view.findViewById(R.id.id_tv_adapter_index_decorate_note_collection_count);
            TextView tv_see_count = (TextView) view.findViewById(R.id.id_tv_adapter_index_decorate_note_see_count);
            TextView tv_title = (TextView) view.findViewById(R.id.id_tv_adapter_index_decorate_note_title);
            TextView tv_description = (TextView) view.findViewById(R.id.id_tv_adapter_index_decorate_note_description);
            ImageView iv_image = (ImageView) view.findViewById(R.id.id_iv_adapter_index_decorate_note_img);
            IndexDecorateNoteBean indexDecorateNoteBean = mArrayList.get(position);
            tv_collection_count.setText(indexDecorateNoteBean.getFav_num());
            tv_see_count.setText(indexDecorateNoteBean.getHits());
            tv_title.setText(indexDecorateNoteBean.getContent());
            tv_description.setText(indexDecorateNoteBean.getStr());
            GlideManager.loadImage(mContext,indexDecorateNoteBean.getImgarr(),iv_image);
            return view;
        }
    }

}
