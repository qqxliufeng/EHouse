package com.android.yt.ehouse.app.ui.adapter;

import com.android.yt.ehouse.app.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/6/23.
 */

public class ClassifyContentAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

    public ClassifyContentAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.id_tv_adapter_classify_content,item);
    }
}
