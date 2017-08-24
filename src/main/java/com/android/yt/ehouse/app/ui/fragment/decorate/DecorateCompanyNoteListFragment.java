package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyCommentBean;
import com.android.yt.ehouse.app.ui.adapter.DecorateCompanyCommentListAdapter;
import com.android.yt.ehouse.app.ui.adapter.NoteDecorateAllAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Map;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyNoteListFragment extends BaseRecycleViewFragment<String> {

    public static DecorateCompanyNoteListFragment newInstance(Bundle args) {
        DecorateCompanyNoteListFragment fragment = new DecorateCompanyNoteListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new NoteDecorateAllAdapter(R.layout.adapter_note_decorate_list_item_layout,mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setItemDecoration();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fillDataFromNet();
    }

    protected void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.REQUESTMOD_HOUSE.getDiaryList(getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""), ""));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        Log.e("TAG",result.toString());
    }
}
