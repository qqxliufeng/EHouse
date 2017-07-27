package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.view.MyGridView;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/27.
 */

public class DecorateBottomVideoFragment extends LroidBaseNetFragment {

    public static DecorateBottomVideoFragment newInstance() {
        return new DecorateBottomVideoFragment();
    }

    @BindView(R.id.id_gv_decorate_result_container)
    MyGridView mGridView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_bottom_video_layout;
    }

    @Override
    protected void initView(View view) {
        mGridView.setAdapter(new MyDecorateVideoGridViewAdapter());
    }

    class MyDecorateVideoGridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return View.inflate(mContext,R.layout.adapter_index_decorate_bottom_video_item_layout,null);
        }
    }

}
