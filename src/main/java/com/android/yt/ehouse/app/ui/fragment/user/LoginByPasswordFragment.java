package com.android.yt.ehouse.app.ui.fragment.user;

import android.app.ProgressDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.KtUserInfo;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/26.
 */

public class LoginByPasswordFragment extends LroidBaseNetFragment {

    public static LoginByPasswordFragment newInstance() {
        return new LoginByPasswordFragment();
    }

    @BindView(R.id.id_et_fragment_login_by_password_user_name)
    EditText et_name;
    @BindView(R.id.id_et_fragment_login_by_password_user_password)
    EditText et_password;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_by_password_layout;
    }

    @Override
    protected void initView(View view) {
        et_name.setText("13966669998");
        et_password.setText("123456");
    }

    @OnClick(R.id.id_tv_fragment_login_by_password_user_name_register)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tv_fragment_login_register:
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "", KtFragmentContainerActivity.Companion.getREGISTER_FLAG());
                break;
        }
    }

    @OnClick(R.id.id_bt_fragment_login_by_password_user_login)
    public void onLogin() {
        String name = et_name.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(mContext, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        String password = et_password.getText().toString();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(mContext, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_USER.login(name, password));
    }

    @OnClick(R.id.id_tv_fragment_login_by_password_user_forget_password)
    public void onForgetPassword() {
    }


    @OnCheckedChanged(R.id.id_cb_fragment_login_by_password_user_password_visible)
    public void onPasswordVisible(CompoundButton button, boolean isChecked) {
        if (isChecked) {
            et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }


    @Override
    public void onRequestStart(int requestID) {
        if (requestID == 0x0) {
            mProgressDialog = ProgressDialog.show(mContext, null, "正在登录，请稍后……");
        }
    }

    @Override
    public void onRequestEnd(int requestID) {
        if (requestID == 0x0) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        if (result != null) {
            HashMap<String, Object> map = (HashMap<String, Object>) result;
            KtUserInfo.INSTANCE.setNickname((String) map.get("nickname"));
            KtUserInfo.INSTANCE.setMobile((String) map.get("mobile"));
            KtUserInfo.INSTANCE.setLoginToken((String) map.get("loginToken"));
            KtUserInfo.INSTANCE.setSession_id((String) map.get("session_id"));
            KtUserInfo.INSTANCE.setEmail((String) map.get("email"));
            KtUserInfo.INSTANCE.setPredeposit((String) map.get("predeposit"));
            KtUserInfo.INSTANCE.setUid((String) map.get("uid"));
            KtUserInfo.INSTANCE.setBonusPoint((String) map.get("bonusPoint"));
            KtUserInfo.INSTANCE.setDefPwd((String) map.get("isDefPwd"));
            KtUserInfo.INSTANCE.setSex((String) map.get("sex"));
            KtUserInfo.INSTANCE.setAvatarUrl((String) map.get("avatarUrl"));
            KtUserInfo.INSTANCE.setRealname((String) map.get("realname"));
            Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestFail(int requestID, Throwable e) {
        super.onRequestFail(requestID, e);
        Toast.makeText(mContext, "登录失败，请稍后重试！", Toast.LENGTH_SHORT).show();
    }
}
