package com.android.yt.ehouse.app.interfaces

/**
 * Created by feng on 2016/8/22.
 */

interface IPresentListener {

    fun onRequestStart(requestID: Int)

    fun onRequestFail(requestID: Int, e: Throwable)

    fun <T> onRequestSuccess(requestID: Int, result: T)

    fun onRequestEnd(requestID: Int)

}
