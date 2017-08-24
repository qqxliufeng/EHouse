package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyCommentBean implements Parcelable {


    private String id;
    private String avatarUrl;
    private String content;
    private String time;
    private String goods_score;
    private String service_score;
    private String nickname;
    private String count;


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_score() {
        return goods_score;
    }

    public void setGoods_score(String goods_score) {
        this.goods_score = goods_score;
    }

    public String getService_score() {
        return service_score;
    }

    public void setService_score(String service_score) {
        this.service_score = service_score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public DecorateCompanyCommentBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.content);
        dest.writeString(this.time);
        dest.writeString(this.goods_score);
        dest.writeString(this.service_score);
        dest.writeString(this.nickname);
        dest.writeString(this.count);
    }

    protected DecorateCompanyCommentBean(Parcel in) {
        this.id = in.readString();
        this.avatarUrl = in.readString();
        this.content = in.readString();
        this.time = in.readString();
        this.goods_score = in.readString();
        this.service_score = in.readString();
        this.nickname = in.readString();
        this.count = in.readString();
    }

    public static final Creator<DecorateCompanyCommentBean> CREATOR = new Creator<DecorateCompanyCommentBean>() {
        @Override
        public DecorateCompanyCommentBean createFromParcel(Parcel source) {
            return new DecorateCompanyCommentBean(source);
        }

        @Override
        public DecorateCompanyCommentBean[] newArray(int size) {
            return new DecorateCompanyCommentBean[size];
        }
    };
}
