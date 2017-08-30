package com.android.yt.ehouse.app.ui.fragment.base

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import butterknife.bindView


import com.android.yt.ehouse.app.R


/**
 * Created by feng on 2016/9/13.
 */

class WebContentFragment : LroidBaseFragment() {

    private val mProgress: ProgressBar by bindView(R.id.id_pb_fragment_web_progress)

    private val mWebView: WebView by bindView(R.id.id_wb_fragment_web_content)

    override fun getLayoutId(): Int = R.layout.fragment_web_content_layout


    override fun initView(view: View) {
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        mWebView.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                mProgress.progress = newProgress
            }
        })
        mWebView.setWebViewClient(object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                super.onPageStarted(view, url, favicon)
                mProgress.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                mProgress.visibility = View.GONE
            }
        })
        val url = arguments.getString(WEB_LOAD_URL)
        if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            mWebView.loadUrl(url)
        } else {
            mWebView.loadData(url, "text/html; charset=UTF-8", null)
        }
    }

    override fun setComponent() {}

    companion object {

        val WEB_LOAD_URL = "web_load_url"

        fun newInstance(args: Bundle): WebContentFragment {
            val fragment = WebContentFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
