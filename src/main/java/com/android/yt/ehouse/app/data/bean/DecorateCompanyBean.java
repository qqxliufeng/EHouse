package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by feng on 2017/8/21.
 */

public class DecorateCompanyBean implements Parcelable {

//    org_code=, city_id=283, koubei=2, org_short_name=, recommend=1, org_license_group=, pcount=0, _num=1, org_email=, service_num=1, org_video=,
// org_phone=13791063533, createtime=1502931982, org_name=济南一品饰家装饰工程有限公司,
// org_id=34, org_thumb=, store_id=0, org_pos=, org_state=1, ecount=0, org_hidden=0, creatorid=51, province_id=22, org_logo=,
// org_addr=山东省济南市槐荫区张庄路172号, area_id=0, org_license=/data/certificate/2017-08-17/150293198250979.png, enable_map=0, org_type=default

    private String org_code;
    private String city_id;
    private String koubei;
    private String org_short_name;
    private String recommend;
    private String org_license_group;
    private String pcount;
    private String _num;
    private String org_email;
    private String service_num;
    private String org_video;
    private String org_phone;
    private String createtime;
    private String org_name;
    private String org_id;
    private String org_thumb;
    private String store_id;
    private String org_pos;
    private String org_state;
    private String ecount;
    private String org_hidden;
    private String creatorid;
    private String province_id;
    private String org_logo;
    private String org_addr;
    private String area_id;
    private String org_license;
    private String enable_map;
    private String org_type;

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getKoubei() {
        return koubei;
    }

    public void setKoubei(String koubei) {
        this.koubei = koubei;
    }

    public String getOrg_short_name() {
        return org_short_name;
    }

    public void setOrg_short_name(String org_short_name) {
        this.org_short_name = org_short_name;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getOrg_license_group() {
        return org_license_group;
    }

    public void setOrg_license_group(String org_license_group) {
        this.org_license_group = org_license_group;
    }

    public String getPcount() {
        return pcount;
    }

    public void setPcount(String pcount) {
        this.pcount = pcount;
    }

    public String get_num() {
        return _num;
    }

    public void set_num(String _num) {
        this._num = _num;
    }

    public String getOrg_email() {
        return org_email;
    }

    public void setOrg_email(String org_email) {
        this.org_email = org_email;
    }

    public String getService_num() {
        return service_num;
    }

    public void setService_num(String service_num) {
        this.service_num = service_num;
    }

    public String getOrg_video() {
        return org_video;
    }

    public void setOrg_video(String org_video) {
        this.org_video = org_video;
    }

    public String getOrg_phone() {
        return org_phone;
    }

    public void setOrg_phone(String org_phone) {
        this.org_phone = org_phone;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getOrg_thumb() {
        return org_thumb;
    }

    public void setOrg_thumb(String org_thumb) {
        this.org_thumb = org_thumb;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getOrg_pos() {
        return org_pos;
    }

    public void setOrg_pos(String org_pos) {
        this.org_pos = org_pos;
    }

    public String getOrg_state() {
        return org_state;
    }

    public void setOrg_state(String org_state) {
        this.org_state = org_state;
    }

    public String getEcount() {
        return ecount;
    }

    public void setEcount(String ecount) {
        this.ecount = ecount;
    }

    public String getOrg_hidden() {
        return org_hidden;
    }

    public void setOrg_hidden(String org_hidden) {
        this.org_hidden = org_hidden;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getOrg_logo() {
        return org_logo;
    }

    public void setOrg_logo(String org_logo) {
        this.org_logo = org_logo;
    }

    public String getOrg_addr() {
        return org_addr;
    }

    public void setOrg_addr(String org_addr) {
        this.org_addr = org_addr;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getOrg_license() {
        return org_license;
    }

    public void setOrg_license(String org_license) {
        this.org_license = org_license;
    }

    public String getEnable_map() {
        return enable_map;
    }

    public void setEnable_map(String enable_map) {
        this.enable_map = enable_map;
    }

    public String getOrg_type() {
        return org_type;
    }

    public void setOrg_type(String org_type) {
        this.org_type = org_type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.org_code);
        dest.writeString(this.city_id);
        dest.writeString(this.koubei);
        dest.writeString(this.org_short_name);
        dest.writeString(this.recommend);
        dest.writeString(this.org_license_group);
        dest.writeString(this.pcount);
        dest.writeString(this._num);
        dest.writeString(this.org_email);
        dest.writeString(this.service_num);
        dest.writeString(this.org_video);
        dest.writeString(this.org_phone);
        dest.writeString(this.createtime);
        dest.writeString(this.org_name);
        dest.writeString(this.org_id);
        dest.writeString(this.org_thumb);
        dest.writeString(this.store_id);
        dest.writeString(this.org_pos);
        dest.writeString(this.org_state);
        dest.writeString(this.ecount);
        dest.writeString(this.org_hidden);
        dest.writeString(this.creatorid);
        dest.writeString(this.province_id);
        dest.writeString(this.org_logo);
        dest.writeString(this.org_addr);
        dest.writeString(this.area_id);
        dest.writeString(this.org_license);
        dest.writeString(this.enable_map);
        dest.writeString(this.org_type);
    }

    public DecorateCompanyBean() {
    }

    protected DecorateCompanyBean(Parcel in) {
        this.org_code = in.readString();
        this.city_id = in.readString();
        this.koubei = in.readString();
        this.org_short_name = in.readString();
        this.recommend = in.readString();
        this.org_license_group = in.readString();
        this.pcount = in.readString();
        this._num = in.readString();
        this.org_email = in.readString();
        this.service_num = in.readString();
        this.org_video = in.readString();
        this.org_phone = in.readString();
        this.createtime = in.readString();
        this.org_name = in.readString();
        this.org_id = in.readString();
        this.org_thumb = in.readString();
        this.store_id = in.readString();
        this.org_pos = in.readString();
        this.org_state = in.readString();
        this.ecount = in.readString();
        this.org_hidden = in.readString();
        this.creatorid = in.readString();
        this.province_id = in.readString();
        this.org_logo = in.readString();
        this.org_addr = in.readString();
        this.area_id = in.readString();
        this.org_license = in.readString();
        this.enable_map = in.readString();
        this.org_type = in.readString();
    }

    public static final Parcelable.Creator<DecorateCompanyBean> CREATOR = new Parcelable.Creator<DecorateCompanyBean>() {
        @Override
        public DecorateCompanyBean createFromParcel(Parcel source) {
            return new DecorateCompanyBean(source);
        }

        @Override
        public DecorateCompanyBean[] newArray(int size) {
            return new DecorateCompanyBean[size];
        }
    };
}
