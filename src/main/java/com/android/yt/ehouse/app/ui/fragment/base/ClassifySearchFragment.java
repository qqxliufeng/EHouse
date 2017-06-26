package com.android.yt.ehouse.app.ui.fragment.base;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.ClassifyContentAdapter;
import com.android.yt.ehouse.app.ui.adapter.ClassifyMenuAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/6/23.
 */

public class ClassifySearchFragment extends LroidBaseNetFragment {

    public static final String TITLE = "建材-分类查询";

    @BindView(R.id.id_rv_fragment_classify_search_left_menu)
    RecyclerView rv_left_menu;
    @BindView(R.id.id_rv_fragment_classify_search_right_content)
    RecyclerView rv_right_content;
    @BindView(R.id.id_et_fragment_classify_search_content)
    EditText et_search_content;

    private ClassifyMenuAdapter classifyMenuAdapter;

    private ArrayList<String> leftMenuList = new ArrayList<>();
    private ArrayList<String> rightContentList = new ArrayList<>();


    public static ClassifySearchFragment newInstance() {
        return new ClassifySearchFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_materials_search_layout;
    }

    @Override
    protected void initView(View view) {
        for (int i = 0; i < 10; i++) {
            leftMenuList.add("灯饰照明");
            rightContentList.add("定制橱柜");
        }
        classifyMenuAdapter = new ClassifyMenuAdapter(R.layout.adapter_classisy_menu_layout, leftMenuList);
        rv_left_menu.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (view instanceof TextView)
                    view.setSelected(true);
            }
        });
        rv_left_menu.setAdapter(classifyMenuAdapter);
        rv_left_menu.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_left_menu.setItemAnimator(new DefaultItemAnimator());
        rv_left_menu.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        rv_right_content.setAdapter(new ClassifyContentAdapter(R.layout.adapter_classisy_content_layout, rightContentList));
        rv_right_content.setLayoutManager(new GridLayoutManager(mContext, 3));
    }

    @OnClick(R.id.id_iv_fragment_classify_search_content_clear)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.id_iv_fragment_classify_search_content_clear:
                et_search_content.setText("");
                break;
        }
    }
}
