package com.android.yt.ehouse.app.data.bean;

/**
 * Created by feng on 2017/6/27.
 */

public class UserInfo {

    private UserInfo() {
    }

    private static UserInfo mInstance = null;

    public static UserInfo getInstance() {
        if (mInstance == null) {
            synchronized (UserInfo.class) {
                if (mInstance == null) {
                    mInstance = new UserInfo();
                }
            }
        }
        return mInstance;
    }

    private String nickname;
    private String mobile;
    private String loginToken;
    private String email;
    private String predeposit;
    private String uid;
    private String bonusPoint;
    private String isDefPwd;
    private String sex;
    private String avatarUrl;
    private String realname;
    private String session_id;


    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPredeposit() {
        return predeposit;
    }

    public void setPredeposit(String predeposit) {
        this.predeposit = predeposit;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(String bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getIsDefPwd() {
        return isDefPwd;
    }

    public void setIsDefPwd(String isDefPwd) {
        this.isDefPwd = isDefPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void clear() {
        setUid(null);
        setSex(null);
        setRealname(null);
        setNickname(null);
        setAvatarUrl(null);
        setEmail(null);
        setIsDefPwd(null);
        setLoginToken(null);
        setSession_id(null);
    }

}
