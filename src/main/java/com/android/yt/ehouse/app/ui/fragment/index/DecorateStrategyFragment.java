package com.android.yt.ehouse.app.ui.fragment.index;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.view.MyGridView;

import butterknife.BindView;

/**
 * Created by feng on 2017/6/15.
 */

public class DecorateStrategyFragment extends LroidBaseNetFragment{

    public static DecorateStrategyFragment newInstance() {
        return new DecorateStrategyFragment();
    }

    @BindView(R.id.id_gv_decorate_strategy_container)
    MyGridView mGridView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_decorate_strategy_layout;
    }

    @Override
    protected void initView(View view) {
        mGridView.setFocusable(false);
        mGridView.setAdapter(new MyDecorateStrategyGridViewAdapter());
    }

    class MyDecorateStrategyGridViewAdapter extends BaseAdapter {

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
            return View.inflate(mContext,R.layout.adapter_index_decorate_strategy_item_layout,null);
        }
    }

}
