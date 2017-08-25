package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyNoteBean implements Parcelable {

    private String id;
    private String createtime;
    private String hits;
    private String fav_num;
    private String comment_num;
    private String content;
    private String avatarUrl;
    private String nickname;
    private String str;
    private String sclassname;
    private String count;
    private ArrayList<String> imageList;

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getSclassname() {
        return sclassname;
    }

    public void setSclassname(String sclassname) {
        this.sclassname = sclassname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getFav_num() {
        return fav_num;
    }

    public void setFav_num(String fav_num) {
        this.fav_num = fav_num;
    }

    public String getComment_num() {
        return comment_num;
    }

    public void setComment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.createtime);
        dest.writeString(this.hits);
        dest.writeString(this.fav_num);
        dest.writeString(this.comment_num);
        dest.writeString(this.content);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.nickname);
        dest.writeString(this.str);
        dest.writeString(this.sclassname);
        dest.writeString(this.count);
    }

    protected DecorateCompanyNoteBean(Parcel in) {
        this.id = in.readString();
        this.createtime = in.readString();
        this.hits = in.readString();
        this.fav_num = in.readString();
        this.comment_num = in.readString();
        this.content = in.readString();
        this.avatarUrl = in.readString();
        this.nickname = in.readString();
        this.str = in.readString();
        this.sclassname = in.readString();
        this.count = in.readString();
    }

    public static final Creator<DecorateCompanyNoteBean> CREATOR = new Creator<DecorateCompanyNoteBean>() {
        @Override
        public DecorateCompanyNoteBean createFromParcel(Parcel source) {
            return new DecorateCompanyNoteBean(source);
        }

        @Override
        public DecorateCompanyNoteBean[] newArray(int size) {
            return new DecorateCompanyNoteBean[size];
        }
    };
}
