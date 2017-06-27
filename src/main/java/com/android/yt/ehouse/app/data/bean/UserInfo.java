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

    private String session_id;


    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
