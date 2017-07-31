package com.android.yt.ehouse.app.ui.fragment.note;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.utils.MethodUtils;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/29.
 */

public class NoteEditFragment extends LroidBaseNetFragment {

    public static NoteEditFragment newInstance() {
        return new NoteEditFragment();
    }

    @BindView(R.id.id_tv_fragment_note_edit_select_time)
    TextView tv_time;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_edit_layout;
    }

    @Override
    protected void initView(View view) {
        tv_time.setText(MethodUtils.parseDate(System.currentTimeMillis(),"yyyy-MM-dd"));
    }

    @OnClick({R.id.id_rl_fragment_note_edit_select_step, R.id.id_rl_fragment_note_edit_select_tag, R.id.id_rl_fragment_note_edit_select_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_rl_fragment_note_edit_select_step:
                break;
            case R.id.id_rl_fragment_note_edit_select_tag:
                FragmentContainerActivity.startFragmentsActivity(mContext,"选择标签",FragmentContainerActivity.NOTE_DECORATE_TAG_FLAG);
                break;
            case R.id.id_rl_fragment_note_edit_select_time:
                DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_time.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                }, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
                break;
        }
    }

}
