package com.android.yt.ehouse.app.ui.fragment.user;

import android.os.Bundle;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.MyMessageAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/8/22.
 */

public class MyMessageFragment extends BaseRecycleViewFragment<String>{

    public static MyMessageFragment newInstance() {
        return new MyMessageFragment();
    }

    @Override
    protected BaseQuickAdapter<String,BaseViewHolder> createAdapter() {
        return new MyMessageAdapter(R.layout.adapter_my_message_adapter_item_layout,mArrayList);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
