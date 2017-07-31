package com.android.yt.ehouse.app.ui.fragment.note;

import android.view.View;
import android.widget.CheckedTextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/28.
 */

public class NoteDecorateStepFragment extends LroidBaseFragment {

    public static NoteDecorateStepFragment newInstance() {
        return new NoteDecorateStepFragment();
    }

    @BindView(R.id.id_ctv_fragment_note_decorate_step_zb)
    CheckedTextView ctv_zb;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_cg)
    CheckedTextView ctv_cg;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_sd)
    CheckedTextView ctv_sd;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_nm)
    CheckedTextView ctv_nm;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_yq)
    CheckedTextView ctv_yq;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_jg)
    CheckedTextView ctv_jg;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_rz)
    CheckedTextView ctv_rz;
    @BindView(R.id.id_ctv_fragment_note_decorate_step_rz1)
    CheckedTextView ctv_rz1;

    private CheckedTextView[] checkedTextViews;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_decorate_step_layout;
    }

    @Override
    protected void initView(View view) {
        setCheckedTextViewClick();
    }

    private void setCheckedTextViewClick() {
        checkedTextViews = new CheckedTextView[]{ctv_cg, ctv_jg, ctv_nm, ctv_rz, ctv_rz1, ctv_sd, ctv_yq, ctv_zb};
        for (CheckedTextView checkedTextView : checkedTextViews) {
            checkedTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (CheckedTextView checkedTextView : checkedTextViews) {
                        if (v == checkedTextView) {
                            checkedTextView.setChecked(true);
                        } else {
                            checkedTextView.setChecked(false);
                        }
                    }
                }
            });
        }
    }

    @Override
    protected void setComponent() {
    }

}
