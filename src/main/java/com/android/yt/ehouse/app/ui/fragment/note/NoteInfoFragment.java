package com.android.yt.ehouse.app.ui.fragment.note;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.NoteInfoAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

/**
 * Created by feng on 2017/7/29.
 */

public class NoteInfoFragment extends LroidBaseNetFragment {


    public static final String ORG_ID = "org_id";

    public static NoteInfoFragment newInstance(Bundle args) {
        NoteInfoFragment noteInfoFragment = new NoteInfoFragment();
        noteInfoFragment.setArguments(args);
        return noteInfoFragment;
    }

    @BindView(R.id.id_dl_fragment_note_info_container)
    DrawerLayout dl_container;
    @BindView(R.id.id_rv_fragment_note_info)
    RecyclerView rv_info;

    private SectionedRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_info_layout;
    }

    @Override
    protected void initView(View view) {
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv_info.setLayoutManager(layoutManager);
        adapter = new SectionedRecyclerViewAdapter();
        for (int i = 0; i < 2; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add("");
            }
            adapter.addSection(new NoteInfoAdapter("", list));
        }
        rv_info.setAdapter(adapter);
        rv_info.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        getChildFragmentManager().beginTransaction().replace(R.id.id_fl_fragment_note_info_menu_container, NoteInfoStepFragment.newInstance()).commit();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_HOUSE.getDiaryDetail(getArguments().getString(ORG_ID)));
    }

    @Override
    public void onRequestStart(int requestID) {
        super.onRequestStart(requestID);
        mProgressDialog = ProgressDialog.show(mContext, null, "正在加载日记详情……");
    }

    @Override
    public void onRequestEnd(int requestID) {
        super.onRequestEnd(requestID);
        mProgressDialog.dismiss();
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        Log.e("TAG", result.toString());
        //{
        //  info={
        //         city_id=283, decoration_style=12, recommend=1, _num=1, ccount=1, user={store_id=0, password=ba9800f04dfa6b1215bd2926c0605a63df72da8d, dyncardid=0, nickname=13184098995, mobile=13184098995, _num=1, email=, predeposit=0.00, verification=none, ustate=0, freeze_predeposit=0.00, openid=, login_token=269354248, username=13184098995, pay_password=, uid=52, sex=2, realname=, avatar_file=}, city_name=济南, createtime=2017-08-18 11:31:21, status=正常, id=31, info={images=/data/diary/2017-08-12/150252374497017.png|, bclass=233, pid=31, sclassname=前期准备, updatetime=1503019204, creatorid=52, fav_num=1, comment_num=1, content=特殊他说特色特色特, sclass=242, createtime=1503019204, status=1, id=49, imgarr={0=/data/diary/2017-08-12/150252374497017.png}, hits=1}, decorate_way_str=半包, hits=10, org_name=, org_id=2, house_type=5, decorate_way=1, tag=, stage=1, updatetime=2017-08-18 11:31:21, creatorid=52, state=2, fav_num=0, province_id=22, share_type=tweet, comment_num=1, from=游客, project_id=, thumb=, area_id=2335, title=日记第二篇, description=, community_name=卢浮宫馆, area=98.00, community_id=, decoration_style_str=简约}, myInfo=, infoTree={0={clist={0={order_num=0, id=242, info={0={images=/data/diary/2017-08-12/150252374497017.png|, bclass=233, pid=31, updatetime=1503019204, _num=1, creatorid=52, ccount=0, fav_num=1, comment_num=1, content=特殊他说特色特色特, sclass=242, createtime=2017年08月18日, status=1, id=49, imgarr={0=/data/diary/2017-08-12/150252374497017.png}, hits=1}}, remark=, parent_id=233, _num=1, name=前期准备, kids_state=0, value=diary_zb_qqzb, class_type=diary_zb, del=0, tag_name=}}, order_num=0, remark=, parent_id=232, _num=1, kids_state=0, class_type=deco_diary_class, del=0, csize=1, tag_name=, time_str=2017/08/18, id=233, name=准备, value=diary_zb}}, iTree={0={clist={0={order_num=0, id=242, info={0={images=/data/diary/2017-08-12/150252374497017.png|, bclass=233, pid=31, updatetime=1503019204, _num=1, creatorid=52, fav_num=1, comment_num=1, content=特殊他说特色特色特, sclass=242, createtime=2017年08月18日, status=1, id=49, imgarr={0=/data/diary/2017-08-12/150252374497017.png}, hits=1}}, remark=, parent_id=233, _num=1, name=前期准备, kids_state=0, value=diary_zb_qqzb, class_type=diary_zb, del=0, tag_name=}}, order_num=0, remark=, parent_id=232, _num=1, kids_state=0, class_type=deco_diary_class, del=0, csize=1, tag_name=, time_str=2017/08/18, id=233, name=准备, value=diary_zb}}}
    }

    @OnClick(R.id.test)
    public void onTest() {
        rv_info.smoothScrollToPosition(3);
    }

    @OnClick(R.id.id_fab_fragment_note_info_step)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_fab_fragment_note_info_step:
                if (dl_container.isDrawerOpen(GravityCompat.END))
                    dl_container.closeDrawer(GravityCompat.END);
                else dl_container.openDrawer(GravityCompat.END);
                break;
        }
    }

}
