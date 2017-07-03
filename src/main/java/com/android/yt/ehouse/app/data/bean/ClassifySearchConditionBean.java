package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by feng on 2017/6/28.
 */

public class ClassifySearchConditionBean implements Parcelable {

    private String searchMod;
    private String searchAct;
    private int searchType;


    public String getSearchMod() {
        return searchMod;
    }

    public void setSearchMod(String searchMod) {
        this.searchMod = searchMod;
    }

    public String getSearchAct() {
        return searchAct;
    }

    public void setSearchAct(String searchAct) {
        this.searchAct = searchAct;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.searchMod);
        dest.writeString(this.searchAct);
        dest.writeInt(this.searchType);
    }

    public ClassifySearchConditionBean() {
    }

    protected ClassifySearchConditionBean(Parcel in) {
        this.searchMod = in.readString();
        this.searchAct = in.readString();
        this.searchType = in.readInt();
    }

    public static final Parcelable.Creator<ClassifySearchConditionBean> CREATOR = new Parcelable.Creator<ClassifySearchConditionBean>() {
        @Override
        public ClassifySearchConditionBean createFromParcel(Parcel source) {
            return new ClassifySearchConditionBean(source);
        }

        @Override
        public ClassifySearchConditionBean[] newArray(int size) {
            return new ClassifySearchConditionBean[size];
        }
    };
}
