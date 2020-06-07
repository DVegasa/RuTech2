package io.github.dvegasa.rutechmeetup.main

import android.annotation.TargetApi
import android.os.Build
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


/**
 * Created by Ed Khalturin @DVegasa
 */
class MyWebView(val writeDataToLocalStorage: () -> Unit) : WebViewClient() {
    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        return true
    }

    // Для старых устройств
    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        view.loadUrl(url)
        return true
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        writeDataToLocalStorage()
    }
}