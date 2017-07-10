package com.android.yt.ehouse.app.ui.fragment.materials;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.BaseBottomSheetDialogFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/10.
 */

public class MaterialsInfoParametersDialogFragment extends BaseBottomSheetDialogFragment {

    public static MaterialsInfoParametersDialogFragment newInstance() {
        Bundle args = new Bundle();
        MaterialsInfoParametersDialogFragment fragment = new MaterialsInfoParametersDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.id_rv_fragment_materials_info_parameters)
    RecyclerView rv_parameters;

    private ArrayList<String> mArrayList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_materials_info_parameters_layout;
    }

    @Override
    public void initView(View rootView) {
        for (int i = 0; i < 20; i++) {
            mArrayList.add("item " + i);
        }
        rv_parameters = (RecyclerView) rootView.findViewById(R.id.id_rv_fragment_materials_info_parameters);
        rv_parameters.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        MaterialsParametersAdapter adapter = new MaterialsParametersAdapter(android.R.layout.simple_list_item_1, mArrayList);
        View headerView = View.inflate(mContext,R.layout.layout_materails_info_parameters_header_layout,null);
        headerView.findViewById(R.id.id_iv_layout_materials_info_parameters_header_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close(true);
            }
        });
        adapter.addHeaderView(headerView);
        rv_parameters.setAdapter(adapter);
    }

    static class MaterialsParametersAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MaterialsParametersAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(android.R.id.text1, item);
        }
    }
}
