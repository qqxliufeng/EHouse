package com.android.yt.ehouse.app.ui.fragment.house;

import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.SellHouseFormBean;
import com.android.yt.ehouse.app.data.manager.FormBeanManager;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * Created by feng on 2017/7/7.
 */

public class HouseSellFragment extends LroidBaseNetFragment {

    public static HouseSellFragment newInstance() {
        return new HouseSellFragment();
    }

    @BindView(R.id.id_sp_fragment_house_sell_house_direction)
    Spinner sp_direction;
    @BindView(R.id.id_sp_fragment_house_sell_house_decorate)
    Spinner sp_decorate;
    @BindView(R.id.id_sp_fragment_house_sell_house_property_right)
    Spinner sp_property_right;
    @BindView(R.id.id_sp_fragment_house_sell_house_type)
    Spinner sp_type;
    @BindView(R.id.id_tv_fragment_house_sell_code)
    TextView tv_code;
    @BindView(R.id.id_tv_fragment_house_sell_protocol)
    TextView tv_protocol;
    @BindView(R.id.id_cb_fragment_house_sell_protocol)
    CheckBox cb_protocol;
    @BindView(R.id.id_et_fragment_house_sell_name)
    EditText et_name;
    @BindView(R.id.id_et_fragment_house_sell_building)
    EditText et_building;
    @BindView(R.id.id_et_fragment_house_sell_no)
    EditText et_no;
    @BindView(R.id.id_et_fragment_house_sell_room)
    EditText et_room;

    private CountDownTimer countDownTimer;
    private SellHouseFormBean sellHouseFormBean = new SellHouseFormBean();
    private FormBeanManager<SellHouseFormBean> formBeanFormBeanManager = new FormBeanManager<>(sellHouseFormBean);

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_house_sell_layout;
    }

    @Override
    protected void initView(View view) {
        tv_protocol.getPaint().setFlags(TextPaint.UNDERLINE_TEXT_FLAG | TextPaint.ANTI_ALIAS_FLAG);
        sp_direction.setAdapter(getSpinnerAdapter(getResources().getStringArray(R.array.string_array_sp_sell_house_direction)));
        sp_decorate.setAdapter(getSpinnerAdapter(getResources().getStringArray(R.array.string_array_sp_sell_house_decorate)));
        sp_property_right.setAdapter(getSpinnerAdapter(getResources().getStringArray(R.array.string_array_sp_sell_house_property_right)));
        sp_type.setAdapter(getSpinnerAdapter(getResources().getStringArray(R.array.string_array_sp_sell_house_type)));
    }

    @OnClick({R.id.id_tv_fragment_house_sell_protocol,
            R.id.id_tv_fragment_house_sell_code,
            R.id.id_tv_fragment_house_sell_submit
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tv_fragment_house_sell_code:
                startCodeCounter();
                break;
            case R.id.id_tv_fragment_house_sell_protocol:
                break;
            case R.id.id_tv_fragment_house_sell_submit:
//                sellHouseFormBean.setHouseName(et_name.getText().toString());
//                sellHouseFormBean.setHouseBuilding(et_building.getText().toString());
//                sellHouseFormBean.setHouseNo(et_no.getText().toString());
//                sellHouseFormBean.setHouseRoom(et_room.getText().toString());
                sellHouseFormBean.setHouseName("this is house name");
                sellHouseFormBean.setHouseBuilding("this is house building");
                sellHouseFormBean.setHouseNo("this is house no ");
                sellHouseFormBean.setHouseRoom("this is house room");
                sellHouseFormBean.setHousePersonPhone("15910101117");
                String result = formBeanFormBeanManager.checkField();
                if (!"".equals(result)) {
                    Toast.makeText(mContext, "请输入 " + result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "验证通过", Toast.LENGTH_SHORT).show();
                    formBeanFormBeanManager.form(null);
                }
                break;
        }
    }

    /**
     * 开始请求验证码，并倒计时
     */
    private void startCodeCounter() {
        tv_code.setEnabled(false);
        countDownTimer = new CountDownTimer(10 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_code.setText("( " + millisUntilFinished / 1000 + " ) 秒");
            }

            @Override
            public void onFinish() {
                tv_code.setEnabled(true);
                tv_code.setText("重新发送？");
            }
        };
        countDownTimer.start();
    }

    @OnItemSelected({R.id.id_sp_fragment_house_sell_house_direction,
            R.id.id_sp_fragment_house_sell_house_decorate,
            R.id.id_sp_fragment_house_sell_house_property_right,
            R.id.id_sp_fragment_house_sell_house_type
    })
    public void onSpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e("TAG", parent.getSelectedItem().toString());
//        switch (view.getId()) {
//            case R.id.id_sp_fragment_house_sell_house_direction:
//                break;
//            case R.id.id_sp_fragment_house_sell_house_decorate:
//                break;
//            case R.id.id_sp_fragment_house_sell_house_property_right:
//                break;
//            case R.id.id_sp_fragment_house_sell_house_type:
//                break;
//        }
    }

    @NonNull
    private ArrayAdapter<String> getSpinnerAdapter(final String[] objects) {
        return new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, objects) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(mContext);
                    convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                }
                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                tv.setTextSize(14);
                tv.setText(getItem(position));
                return convertView;
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }
}
