package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyBean;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyCommentBean;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyDesignBean;
import com.android.yt.ehouse.app.data.bean.DecorateCompanyNoteBean;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.utils.EncodeUtils;
import com.android.yt.ehouse.app.utils.MethodUtils;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;

import java.util.Map;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoFragment extends LroidBaseNetFragment {

    public static final String ORG_ID = "org_id";

    public static DecorateCompanyInfoFragment newInstance(Bundle bundle) {
        DecorateCompanyInfoFragment decorateCompanyInfoFragment = new DecorateCompanyInfoFragment();
        decorateCompanyInfoFragment.setArguments(bundle);
        return decorateCompanyInfoFragment;
    }

    private DecorateCompanyBean decorateCompanyBean;
    private DecorateCompanyInfoDesignFragment decorateCompanyInfoDesignFragment;
    private DecorateCompanyInfoNoteFragment decorateCompanyInfoNoteFragment;
    private DecorateCompanyInfoCommentFragment decorateCompanyInfoCommentFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_layout;
    }

    @Override
    protected void initView(View view) {
        decorateCompanyBean = getArguments().getParcelable(ORG_ID);
        decorateCompanyInfoDesignFragment = DecorateCompanyInfoDesignFragment.newInstance(decorateCompanyBean.getOrg_id());
        decorateCompanyInfoNoteFragment = DecorateCompanyInfoNoteFragment.newInstance(decorateCompanyBean.getOrg_id());
        decorateCompanyInfoCommentFragment = DecorateCompanyInfoCommentFragment.newInstance(decorateCompanyBean.getOrg_id());
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_decorate_company_info_introduce_container, DecorateCompanyInfoIntroduceFragment.newInstance(decorateCompanyBean))
                .replace(R.id.id_fl_fragment_decorate_company_info_design_container, decorateCompanyInfoDesignFragment)
                .replace(R.id.id_fl_fragment_decorate_company_info_detail_container, DecorateCompanyInfoDetailFragment.newInstance(decorateCompanyBean.getOrg_id()))
                .replace(R.id.id_fl_fragment_decorate_company_info_note_container, decorateCompanyInfoNoteFragment)
                .replace(R.id.id_fl_fragment_decorate_company_info_comment_container, decorateCompanyInfoCommentFragment)
                .commit();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fillDataFromNet();
    }

    private void fillDataFromNet() {
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_ORGANIZATION.decoCompanyDetail(decorateCompanyBean == null ? "" : decorateCompanyBean.getOrg_id()));
    }

    @Override
    public void onRequestStart(int requestID) {
        super.onRequestStart(requestID);
        mProgressDialog = ProgressDialog.show(mContext, null, "正在加载详情……");
    }

    @Override
    public void onRequestEnd(int requestID) {
        super.onRequestEnd(requestID);
        mProgressDialog.dismiss();
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        Map<String, Object> mapResult = (Map<String, Object>) result;
        parseDesignData(mapResult);
        parseNoteData(mapResult);
        parseCommentData(mapResult);
    }


    private void parseDesignData(Map<String, Object> mapResult) {
        Map<String, Object> designMap = (Map<String, Object>) mapResult.get("design");
        if (designMap != null && !designMap.isEmpty()) {
//            DecorateCompanyDesignBean decorateCompanyDesignBean = new DecorateCompanyDesignBean();
//            decorateCompanyDesignBean.setId((String) designMap.get("id"));
//            decorateCompanyDesignBean.setName((String) designMap.get("name"));
//            decorateCompanyDesignBean.setCreatorid((String) designMap.get("creatorid"));
//            decorateCompanyDesignBean.setCreatetime((String) designMap.get("createtime"));
//            decorateCompanyDesignBean.setOrg_id((String) designMap.get("org_id"));
//            decorateCompanyDesignBean.setThumb((String) designMap.get("thumb"));
//            decorateCompanyDesignBean.setDesigner_id((String) designMap.get("designer_id"));
//            decorateCompanyDesignBean.setDescription((String) designMap.get("description"));
//            decorateCompanyDesignBean.setDesign_style((String) designMap.get("design_style"));
//            decorateCompanyDesignBean.setDecoration_area((String) designMap.get("decoration_area"));
//            decorateCompanyDesignBean.setHouse_type((String) designMap.get("house_type"));
//            decorateCompanyDesignBean.setHouse_type_name((String) designMap.get("group_type_dir"));
//            decorateCompanyDesignBean.setGroup_dir((String) designMap.get("group_dir"));
//            decorateCompanyDesignBean.setRecommend((String) designMap.get("recommend"));
//            decorateCompanyDesignBean.set_num((String) designMap.get("_num"));
//            decorateCompanyDesignBean.setDesign_style_name((String) designMap.get("design_style_name"));
//            decorateCompanyDesignBean.setHouse_type_name((String) designMap.get("house_type_name"));
//            decorateCompanyDesignBean.setCount((String) designMap.get("count"));
            DecorateCompanyDesignBean decorateCompanyDesignBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(designMap), DecorateCompanyDesignBean.class);
            decorateCompanyInfoDesignFragment.refresh(decorateCompanyDesignBean);
        }
    }

    private void parseNoteData(Map<String, Object> mapResult) {
        Map<String, Object> noteResult = (Map<String, Object>) mapResult.get("diary");
        if (noteResult != null && !noteResult.isEmpty()) {
            DecorateCompanyNoteBean decorateCompanyNoteBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(noteResult), DecorateCompanyNoteBean.class);
            DecorateCompanyNoteBean.DecorateCompanyNoteUserInfoBean decorateCompanyNoteUserInfoBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode((Map<String, Object>) noteResult.get("user")), DecorateCompanyNoteBean.DecorateCompanyNoteUserInfoBean.class);
            DecorateCompanyNoteBean.DecorateCompanyNoteInfoBean decorateCompanyNoteInfoBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode((Map<String, Object>) noteResult.get("info")), DecorateCompanyNoteBean.DecorateCompanyNoteInfoBean.class);
            decorateCompanyNoteBean.setDecorateCompanyNoteInfoBean(decorateCompanyNoteInfoBean);
            decorateCompanyNoteBean.setDecorateCompanyNoteUserInfoBean(decorateCompanyNoteUserInfoBean);
            decorateCompanyInfoNoteFragment.refresh(decorateCompanyNoteBean);
        }
    }

    private void parseCommentData(Map<String, Object> mapResult) {
        Map<String, Object> commentResult = (Map<String, Object>) mapResult.get("evaluate");
        if (commentResult != null && !commentResult.isEmpty()) {
            DecorateCompanyCommentBean decorateCompanyCommentBean = MethodUtils.jsonToBean(EncodeUtils.jsonEncode(commentResult), DecorateCompanyCommentBean.class);
            decorateCompanyInfoCommentFragment.refresh(decorateCompanyCommentBean);
        }
    }

}
