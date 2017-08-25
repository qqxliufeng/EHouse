package com.android.yt.ehouse.app.ui.fragment.note;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyNoteBean;
import com.android.yt.ehouse.app.ui.adapter.NoteDecorateAllAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/7/28.
 */

public class NoteDecorateListAllFragment extends BaseRecycleViewFragment<DecorateCompanyNoteBean>{

    public static NoteDecorateListAllFragment newInstance() {
        return new NoteDecorateListAllFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_note_decorate_recommend_layout;
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyNoteBean, BaseViewHolder> createAdapter() {
        return new NoteDecorateAllAdapter(R.layout.adapter_note_decorate_list_item_layout,mArrayList);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }
}
