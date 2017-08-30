package com.android.yt.ehouse.app.utils

import android.text.TextUtils
import android.widget.TextView
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by feng on 2017/8/30.
 */

const val defaultText: String = "暂无"

public fun TextView.setDefaultText(text: String?) {
    setText(if (TextUtils.isEmpty(text)) defaultText else text)
}

public fun BaseViewHolder.setDefaultText(resId: Int, text: String?) {
    setText(resId, if (TextUtils.isEmpty(text)) defaultText else text)
}


