package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyCommentBean implements Parcelable {

    private String id;
    private String company_id;
    private String store_id;
    private String goods_id;
    private String order_id;
    private String order_item_id;
    private String project_id;
    private String member_id;
    private String evaluate_type;
    private String goods_score;
    private String service_score;
    private String content;
    private String reply;
    private String time;
    private String recommend;
    private String _num;
    private String evaluate_type_name;
    private String time_str;
    private String count;

    public String getEvaluate_type_name() {
        return evaluate_type_name;
    }

    public void setEvaluate_type_name(String evaluate_type_name) {
        this.evaluate_type_name = evaluate_type_name;
    }

    public String getTime_str() {
        return time_str;
    }

    public void setTime_str(String time_str) {
        this.time_str = time_str;
    }

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

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(String order_item_id) {
        this.order_item_id = order_item_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getEvaluate_type() {
        return evaluate_type;
    }

    public void setEvaluate_type(String evaluate_type) {
        this.evaluate_type = evaluate_type;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String get_num() {
        return _num;
    }

    public void set_num(String _num) {
        this._num = _num;
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
        dest.writeString(this.company_id);
        dest.writeString(this.store_id);
        dest.writeString(this.goods_id);
        dest.writeString(this.order_id);
        dest.writeString(this.order_item_id);
        dest.writeString(this.project_id);
        dest.writeString(this.member_id);
        dest.writeString(this.evaluate_type);
        dest.writeString(this.goods_score);
        dest.writeString(this.service_score);
        dest.writeString(this.content);
        dest.writeString(this.reply);
        dest.writeString(this.time);
        dest.writeString(this.recommend);
        dest.writeString(this._num);
        dest.writeString(this.evaluate_type_name);
        dest.writeString(this.time_str);
        dest.writeString(this.count);
    }

    protected DecorateCompanyCommentBean(Parcel in) {
        this.id = in.readString();
        this.company_id = in.readString();
        this.store_id = in.readString();
        this.goods_id = in.readString();
        this.order_id = in.readString();
        this.order_item_id = in.readString();
        this.project_id = in.readString();
        this.member_id = in.readString();
        this.evaluate_type = in.readString();
        this.goods_score = in.readString();
        this.service_score = in.readString();
        this.content = in.readString();
        this.reply = in.readString();
        this.time = in.readString();
        this.recommend = in.readString();
        this._num = in.readString();
        this.evaluate_type_name = in.readString();
        this.time_str = in.readString();
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
