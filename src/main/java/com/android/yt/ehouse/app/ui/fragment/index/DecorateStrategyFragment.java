package com.android.yt.ehouse.app.ui.fragment.index;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateStrategyBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.view.MyGridView;
import com.android.yt.ehouse.app.utils.GlideManager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by feng on 2017/6/15.
 */

public class DecorateStrategyFragment extends LroidBaseNetFragment {


    public static DecorateStrategyFragment newInstance() {
        return new DecorateStrategyFragment();
    }

    @BindView(R.id.id_gv_decorate_strategy_container)
    MyGridView mGridView;

    private ArrayList<DecorateStrategyBean> mArrayList = new ArrayList<>();

    private MyDecorateStrategyGridViewAdapter myDecorateStrategyGridViewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_decorate_strategy_layout;
    }

    @Override
    protected void initView(View view) {
        mGridView.setFocusable(false);
        myDecorateStrategyGridViewAdapter = new MyDecorateStrategyGridViewAdapter();
        mGridView.setAdapter(myDecorateStrategyGridViewAdapter);
    }

    public void refresh(ArrayList<DecorateStrategyBean> tempList) {
        if (myDecorateStrategyGridViewAdapter != null && tempList != null && !tempList.isEmpty()) {
            mArrayList.addAll(tempList);
            myDecorateStrategyGridViewAdapter.notifyDataSetChanged();
        }
    }

    class MyDecorateStrategyGridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mArrayList.isEmpty()) {
                return 0;
            }
            return mArrayList.size() > 4 ? 4 : mArrayList.size();
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
            View view = View.inflate(mContext, R.layout.adapter_index_decorate_strategy_item_layout, null);
            ImageView iv_image = (ImageView) view.findViewById(R.id.id_iv_adapter_index_strategy_item_image);
            TextView tv_title = (TextView) view.findViewById(R.id.id_tv_adapter_index_strategy_item_title);
            TextView tv_content = (TextView) view.findViewById(R.id.id_tv_adapter_index_strategy_item_content);
            TextView tv_time = (TextView) view.findViewById(R.id.id_tv_adapter_index_strategy_item_time);
            TextView tv_count = (TextView) view.findViewById(R.id.id_tv_adapter_index_strategy_item_see_count);
            DecorateStrategyBean decorateStrategyBean = (DecorateStrategyBean) getItem(position);
            GlideManager.loadImage(mContext, decorateStrategyBean.getThumb(), iv_image);
            String content = decorateStrategyBean.getContent();
            content = content.trim();
            tv_content.setText(TextUtils.isEmpty(content) ? "暂无" : content);
            tv_time.setText(decorateStrategyBean.getAddtime());
            tv_title.setText(decorateStrategyBean.getTitle());
            tv_count.setText(TextUtils.isEmpty(decorateStrategyBean.getHits()) ? "0" : decorateStrategyBean.getHits());
            return view;
        }
    }

}
