package com.android.yt.ehouse.app.data.bean

/**
 * Created by feng on 2017/8/29.
 */
object KtUserInfo {

    var nickname: String? = null
    var mobile: String? = null
    var loginToken: String? = null
    var email: String? = null
    var predeposit: String? = null
    var uid: String? = null
    var bonusPoint: String? = null
    var defPwd: String? = null
    var sex: String? = null
    var avatarUrl: String? = null
    var realname: String? = null
    var session_id: String? = null

    fun logout() {
        nickname = null
        uid = null
        sex = null
        session_id = null
        realname = null
        avatarUrl = null
        email = null
        defPwd = null
        loginToken = null
    }
}