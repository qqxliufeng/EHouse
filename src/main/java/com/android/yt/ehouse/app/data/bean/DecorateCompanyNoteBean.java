package com.android.yt.ehouse.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyNoteBean implements Parcelable {

    private String id;
    private String project_id;
    private String creatorid;
    private String createtime;
    private String title;
    private String thumb;
    private String description;
    private String share_type;
    private String hits;
    private String state;
    private String recommend;
    private String house_type;
    private String area;
    private String province_id;
    private String city_id;
    private String area_id;
    private String decoration_style;
    private String decorate_way;
    private String community_id;
    private String community_name;
    private String org_id;
    private String org_name;
    private String stage;
    private String tag;
    private String fav_num;
    private String comment_num;
    private String updatetime;
    private String status;
    private String from;
    private String _num;
    private String decorate_way_str;
    private String decoration_style_str;
    private String city_name;
    private String ccount;
    private String count;
    private DecorateCompanyNoteUserInfoBean decorateCompanyNoteUserInfoBean;
    private DecorateCompanyNoteInfoBean decorateCompanyNoteInfoBean;

    public DecorateCompanyNoteUserInfoBean getDecorateCompanyNoteUserInfoBean() {
        return decorateCompanyNoteUserInfoBean;
    }

    public void setDecorateCompanyNoteUserInfoBean(DecorateCompanyNoteUserInfoBean decorateCompanyNoteUserInfoBean) {
        this.decorateCompanyNoteUserInfoBean = decorateCompanyNoteUserInfoBean;
    }

    public DecorateCompanyNoteInfoBean getDecorateCompanyNoteInfoBean() {
        return decorateCompanyNoteInfoBean;
    }

    public void setDecorateCompanyNoteInfoBean(DecorateCompanyNoteInfoBean decorateCompanyNoteInfoBean) {
        this.decorateCompanyNoteInfoBean = decorateCompanyNoteInfoBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShare_type() {
        return share_type;
    }

    public void setShare_type(String share_type) {
        this.share_type = share_type;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getDecoration_style() {
        return decoration_style;
    }

    public void setDecoration_style(String decoration_style) {
        this.decoration_style = decoration_style;
    }

    public String getDecorate_way() {
        return decorate_way;
    }

    public void setDecorate_way(String decorate_way) {
        this.decorate_way = decorate_way;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String get_num() {
        return _num;
    }

    public void set_num(String _num) {
        this._num = _num;
    }

    public String getDecorate_way_str() {
        return decorate_way_str;
    }

    public void setDecorate_way_str(String decorate_way_str) {
        this.decorate_way_str = decorate_way_str;
    }

    public String getDecoration_style_str() {
        return decoration_style_str;
    }

    public void setDecoration_style_str(String decoration_style_str) {
        this.decoration_style_str = decoration_style_str;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCcount() {
        return ccount;
    }

    public void setCcount(String ccount) {
        this.ccount = ccount;
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
        dest.writeString(this.project_id);
        dest.writeString(this.creatorid);
        dest.writeString(this.createtime);
        dest.writeString(this.title);
        dest.writeString(this.thumb);
        dest.writeString(this.description);
        dest.writeString(this.share_type);
        dest.writeString(this.hits);
        dest.writeString(this.state);
        dest.writeString(this.recommend);
        dest.writeString(this.house_type);
        dest.writeString(this.area);
        dest.writeString(this.province_id);
        dest.writeString(this.city_id);
        dest.writeString(this.area_id);
        dest.writeString(this.decoration_style);
        dest.writeString(this.decorate_way);
        dest.writeString(this.community_id);
        dest.writeString(this.community_name);
        dest.writeString(this.org_id);
        dest.writeString(this.org_name);
        dest.writeString(this.stage);
        dest.writeString(this.tag);
        dest.writeString(this.fav_num);
        dest.writeString(this.comment_num);
        dest.writeString(this.updatetime);
        dest.writeString(this.status);
        dest.writeString(this.from);
        dest.writeString(this._num);
        dest.writeString(this.decorate_way_str);
        dest.writeString(this.decoration_style_str);
        dest.writeString(this.city_name);
        dest.writeString(this.ccount);
        dest.writeString(this.count);
        dest.writeParcelable(this.decorateCompanyNoteUserInfoBean, flags);
        dest.writeParcelable(this.decorateCompanyNoteInfoBean, flags);
    }

    public DecorateCompanyNoteBean() {
    }

    protected DecorateCompanyNoteBean(Parcel in) {
        this.id = in.readString();
        this.project_id = in.readString();
        this.creatorid = in.readString();
        this.createtime = in.readString();
        this.title = in.readString();
        this.thumb = in.readString();
        this.description = in.readString();
        this.share_type = in.readString();
        this.hits = in.readString();
        this.state = in.readString();
        this.recommend = in.readString();
        this.house_type = in.readString();
        this.area = in.readString();
        this.province_id = in.readString();
        this.city_id = in.readString();
        this.area_id = in.readString();
        this.decoration_style = in.readString();
        this.decorate_way = in.readString();
        this.community_id = in.readString();
        this.community_name = in.readString();
        this.org_id = in.readString();
        this.org_name = in.readString();
        this.stage = in.readString();
        this.tag = in.readString();
        this.fav_num = in.readString();
        this.comment_num = in.readString();
        this.updatetime = in.readString();
        this.status = in.readString();
        this.from = in.readString();
        this._num = in.readString();
        this.decorate_way_str = in.readString();
        this.decoration_style_str = in.readString();
        this.city_name = in.readString();
        this.ccount = in.readString();
        this.count = in.readString();
        this.decorateCompanyNoteUserInfoBean = in.readParcelable(DecorateCompanyNoteUserInfoBean.class.getClassLoader());
        this.decorateCompanyNoteInfoBean = in.readParcelable(DecorateCompanyNoteInfoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<DecorateCompanyNoteBean> CREATOR = new Parcelable.Creator<DecorateCompanyNoteBean>() {
        @Override
        public DecorateCompanyNoteBean createFromParcel(Parcel source) {
            return new DecorateCompanyNoteBean(source);
        }

        @Override
        public DecorateCompanyNoteBean[] newArray(int size) {
            return new DecorateCompanyNoteBean[size];
        }
    };

    public static final class DecorateCompanyNoteUserInfoBean implements Parcelable {
        private String uid;
        private String password;
        private String username;
        private String nickname;
        private String realname;
        private String email;
        private String mobile;
        private String sex;
        private String dyncardid;
        private String verification;
        private String ustate;
        private String predeposit;
        private String freeze_predeposit;
        private String login_token;
        private String openid;
        private String avatar_file;
        private String store_id;
        private String pay_password;
        private String _num;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getDyncardid() {
            return dyncardid;
        }

        public void setDyncardid(String dyncardid) {
            this.dyncardid = dyncardid;
        }

        public String getVerification() {
            return verification;
        }

        public void setVerification(String verification) {
            this.verification = verification;
        }

        public String getUstate() {
            return ustate;
        }

        public void setUstate(String ustate) {
            this.ustate = ustate;
        }

        public String getPredeposit() {
            return predeposit;
        }

        public void setPredeposit(String predeposit) {
            this.predeposit = predeposit;
        }

        public String getFreeze_predeposit() {
            return freeze_predeposit;
        }

        public void setFreeze_predeposit(String freeze_predeposit) {
            this.freeze_predeposit = freeze_predeposit;
        }

        public String getLogin_token() {
            return login_token;
        }

        public void setLogin_token(String login_token) {
            this.login_token = login_token;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getAvatar_file() {
            return avatar_file;
        }

        public void setAvatar_file(String avatar_file) {
            this.avatar_file = avatar_file;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getPay_password() {
            return pay_password;
        }

        public void setPay_password(String pay_password) {
            this.pay_password = pay_password;
        }

        public String get_num() {
            return _num;
        }

        public void set_num(String _num) {
            this._num = _num;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.uid);
            dest.writeString(this.password);
            dest.writeString(this.username);
            dest.writeString(this.nickname);
            dest.writeString(this.realname);
            dest.writeString(this.email);
            dest.writeString(this.mobile);
            dest.writeString(this.sex);
            dest.writeString(this.dyncardid);
            dest.writeString(this.verification);
            dest.writeString(this.ustate);
            dest.writeString(this.predeposit);
            dest.writeString(this.freeze_predeposit);
            dest.writeString(this.login_token);
            dest.writeString(this.openid);
            dest.writeString(this.avatar_file);
            dest.writeString(this.store_id);
            dest.writeString(this.pay_password);
            dest.writeString(this._num);
        }

        public DecorateCompanyNoteUserInfoBean() {
        }

        protected DecorateCompanyNoteUserInfoBean(Parcel in) {
            this.uid = in.readString();
            this.password = in.readString();
            this.username = in.readString();
            this.nickname = in.readString();
            this.realname = in.readString();
            this.email = in.readString();
            this.mobile = in.readString();
            this.sex = in.readString();
            this.dyncardid = in.readString();
            this.verification = in.readString();
            this.ustate = in.readString();
            this.predeposit = in.readString();
            this.freeze_predeposit = in.readString();
            this.login_token = in.readString();
            this.openid = in.readString();
            this.avatar_file = in.readString();
            this.store_id = in.readString();
            this.pay_password = in.readString();
            this._num = in.readString();
        }

        public static final Parcelable.Creator<DecorateCompanyNoteUserInfoBean> CREATOR = new Parcelable.Creator<DecorateCompanyNoteUserInfoBean>() {
            @Override
            public DecorateCompanyNoteUserInfoBean createFromParcel(Parcel source) {
                return new DecorateCompanyNoteUserInfoBean(source);
            }

            @Override
            public DecorateCompanyNoteUserInfoBean[] newArray(int size) {
                return new DecorateCompanyNoteUserInfoBean[size];
            }
        };
    }

    public static final class DecorateCompanyNoteInfoBean implements Parcelable {
        private String id;
        private String bclass;
        private String sclass;
        private String content;
        private String creatorid;
        private String createtime;
        private String updatetime;
        private String images;
        private String pid;
        private String hits;
        private String comment_num;
        private String fav_num;
        private String status;
//        private ArrayList<String> imgarr;
        private String sclassname;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBclass() {
            return bclass;
        }

        public void setBclass(String bclass) {
            this.bclass = bclass;
        }

        public String getSclass() {
            return sclass;
        }

        public void setSclass(String sclass) {
            this.sclass = sclass;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreatorid() {
            return creatorid;
        }

        public void setCreatorid(String creatorid) {
            this.creatorid = creatorid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getComment_num() {
            return comment_num;
        }

        public void setComment_num(String comment_num) {
            this.comment_num = comment_num;
        }

        public String getFav_num() {
            return fav_num;
        }

        public void setFav_num(String fav_num) {
            this.fav_num = fav_num;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

//        public ArrayList<String> getImgarr() {
//            return imgarr;
//        }
//
//        public void setImgarr(ArrayList<String> imgarr) {
//            this.imgarr = imgarr;
//        }
//
        public String getSclassname() {
            return sclassname;
        }

        public void setSclassname(String sclassname) {
            this.sclassname = sclassname;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.bclass);
            dest.writeString(this.sclass);
            dest.writeString(this.content);
            dest.writeString(this.creatorid);
            dest.writeString(this.createtime);
            dest.writeString(this.updatetime);
            dest.writeString(this.images);
            dest.writeString(this.pid);
            dest.writeString(this.hits);
            dest.writeString(this.comment_num);
            dest.writeString(this.fav_num);
            dest.writeString(this.status);
//            dest.writeStringList(this.imgarr);
            dest.writeString(this.sclassname);
        }

        public DecorateCompanyNoteInfoBean() {
        }

        protected DecorateCompanyNoteInfoBean(Parcel in) {
            this.id = in.readString();
            this.bclass = in.readString();
            this.sclass = in.readString();
            this.content = in.readString();
            this.creatorid = in.readString();
            this.createtime = in.readString();
            this.updatetime = in.readString();
            this.images = in.readString();
            this.pid = in.readString();
            this.hits = in.readString();
            this.comment_num = in.readString();
            this.fav_num = in.readString();
            this.status = in.readString();
//            this.imgarr = in.createStringArrayList();
            this.sclassname = in.readString();
        }

        public static final Parcelable.Creator<DecorateCompanyNoteInfoBean> CREATOR = new Parcelable.Creator<DecorateCompanyNoteInfoBean>() {
            @Override
            public DecorateCompanyNoteInfoBean createFromParcel(Parcel source) {
                return new DecorateCompanyNoteInfoBean(source);
            }

            @Override
            public DecorateCompanyNoteInfoBean[] newArray(int size) {
                return new DecorateCompanyNoteInfoBean[size];
            }
        };
    }


}
