package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

/**
 * Created by feng on 2017/7/5.
 */

public class DecorateCompanyInfoFragment extends LroidBaseNetFragment {

    public static DecorateCompanyInfoFragment newInstance() {
        return new DecorateCompanyInfoFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_decorate_company_info_layout;
    }

    @Override
    protected void initView(View view) {
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_decorate_company_info_introduce_container, DecorateCompanyInfoIntroduceFragment.newInstance())
                .replace(R.id.id_fl_fragment_decorate_company_info_design_container, DecorateCompanyInfoDesignFragment.newInstance())
                .replace(R.id.id_fl_fragment_decorate_company_info_detail_container, DecorateCompanyInfoDetailFragment.newInstance())
                .replace(R.id.id_fl_fragment_decorate_company_info_note_container, DecorateCompanyInfoNoteFragment.newInstance())
                .replace(R.id.id_fl_fragment_decorate_company_info_comment_container, DecorateCompanyInfoCommentFragment.newInstance())
                .commit();
    }
}
