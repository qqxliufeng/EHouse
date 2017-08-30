package com.android.yt.ehouse.app.ui.fragment.index;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateImageBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.view.MyGridView;
import com.android.yt.ehouse.app.utils.GlideManager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by feng on 2017/6/15.
 */

public class DecorateResultFragment extends LroidBaseNetFragment {


    public static DecorateResultFragment newInstance() {
        return new DecorateResultFragment();
    }

    @BindView(R.id.id_gv_decorate_result_container)
    MyGridView mGridView;

    private MyDecorateResultGridViewAdapter myDecorateResultGridViewAdapter;
    private ArrayList<DecorateImageBean> mArrayList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_decorate_result_layout;
    }

    @Override
    protected void initView(View view) {
        mGridView.setFocusable(false);
        myDecorateResultGridViewAdapter = new MyDecorateResultGridViewAdapter();
        mGridView.setAdapter(myDecorateResultGridViewAdapter);
    }

    public void refresh(ArrayList<DecorateImageBean> tempList) {
        if (myDecorateResultGridViewAdapter != null && tempList != null && !tempList.isEmpty()) {
            mArrayList.addAll(tempList);
            myDecorateResultGridViewAdapter.notifyDataSetChanged();
        }
    }

    class MyDecorateResultGridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mArrayList.isEmpty()) {
                return 0;
            }
            return Math.min(mArrayList.size(), 4);
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
            View view = View.inflate(mContext, R.layout.adapter_index_decorate_result_item_layout, null);
            ImageView iv_image = (ImageView) view.findViewById(R.id.id_iv_adapter_index_decorate_image_item_image);
            TextView tv_title = (TextView) view.findViewById(R.id.id_tv_adapter_index_decorate_image_item_title);
            DecorateImageBean decorateImageBean = (DecorateImageBean) getItem(position);
            GlideManager.loadImage(mContext, decorateImageBean.getThumb(), iv_image);
            tv_title.setText(decorateImageBean.getStr());
            return view;
        }
    }

}
