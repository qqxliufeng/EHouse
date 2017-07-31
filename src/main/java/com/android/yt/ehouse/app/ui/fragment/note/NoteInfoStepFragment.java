package com.android.yt.ehouse.app.ui.fragment.note;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/31.
 */

public class NoteInfoStepFragment extends LroidBaseNetFragment {

    public static NoteInfoStepFragment newInstance() {
        return new NoteInfoStepFragment();
    }

    @BindView(R.id.id_rv_fragment_note_info_step)
    RecyclerView rv_step;

    private ArrayList<String> mArrayList = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_info_step_layout;
    }

    @Override
    protected void initView(View view) {
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        rv_step.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_step.setAdapter(new NoteInfoStepAdapter(R.layout.adapter_note_info_step_item_layout, mArrayList));
    }

    static class NoteInfoStepAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public NoteInfoStepAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            View viewLine = helper.getView(R.id.id_view_adapter_note_step_item_line);
            if (helper.getLayoutPosition() == getData().size() - 1) {
                viewLine.setVisibility(View.GONE);
            }
        }
    }

}
