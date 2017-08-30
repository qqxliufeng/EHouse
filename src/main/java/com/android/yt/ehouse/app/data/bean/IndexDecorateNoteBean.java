package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;

/**
 * Created by feng on 2017/8/28.
 */

public class IndexDecorateNoteBean extends DecorateCompanyNoteBean{

    protected IndexDecorateNoteBean(Parcel in) {
        super(in);
    }

    private String imgarr;

    public String getImgarr() {
        return imgarr;
    }

    public void setImgarr(String imgarr) {
        this.imgarr = imgarr;
    }
}
