package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyNoteBean;
import com.android.yt.ehouse.app.ui.adapter.NoteDecorateAllAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.android.yt.ehouse.app.utils.EncodeUtils;
import com.android.yt.ehouse.app.utils.MethodUtils;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by feng on 2017/8/24.
 */

public class DecorateCompanyNoteListFragment extends BaseRecycleViewFragment<DecorateCompanyNoteBean> {

    public static DecorateCompanyNoteListFragment newInstance(Bundle args) {
        DecorateCompanyNoteListFragment fragment = new DecorateCompanyNoteListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<DecorateCompanyNoteBean, BaseViewHolder> createAdapter() {
        return new NoteDecorateAllAdapter(R.layout.adapter_note_decorate_list_item_layout, mArrayList);
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
        mGetDataFromNetPresenter.getData(0x0,
                RequestParamsHelper.RequestMod_HOUSE.getDiaryList(getArguments().getString(DecorateCompanyInfoFragment.ORG_ID, ""), ""));
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        try {
            HashMap<String, Object> listMap = (HashMap<String, Object>) ((HashMap<String, Object>) result).get("list");
            if (listMap != null && !listMap.isEmpty()) {
                int[] sortKey = MethodUtils.sortKeys(listMap.keySet());
                ArrayList<DecorateCompanyNoteBean> tempList = new ArrayList<>();
                for (int key : sortKey) {
                    Map<String, Object> objectMap = (Map<String, Object>) listMap.get(Integer.toString(key));
                    DecorateCompanyNoteBean decorateCompanyNoteBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(objectMap), DecorateCompanyNoteBean.class);
                    HashMap<String, String> imageList = (HashMap<String, String>) objectMap.get("imgarr");
                    if (imageList != null && !imageList.isEmpty()) {
                        ArrayList<String> tempImageList = new ArrayList<>();
                        int[] sortImageKey = MethodUtils.sortKeys(imageList.keySet());
                        for (int imageKey : sortImageKey) {
                            tempImageList.add(imageList.get(Integer.toString(imageKey)));
                        }
                        decorateCompanyNoteBean.setImageList(tempImageList);
                    } else {
                        decorateCompanyNoteBean.setImageList(null);
                    }
                    tempList.add(decorateCompanyNoteBean);
                }
                mBaseQuickAdapter.addData(tempList);
                mBaseQuickAdapter.loadMoreComplete();
            } else {
                if (current_page > 1) { //已经加载几页了，没有更多数据了
                    mBaseQuickAdapter.loadMoreEnd();
                } else {//第一在页就没有数据
                    showEmptyView();
                }
            }
            if (((HashMap<String, Object>) result).containsKey(COUNT)) {
                setPagerParam((String) listMap.get(COUNT));
            }
        } catch (Exception e) {
            showErrorView();
        }
    }
}
