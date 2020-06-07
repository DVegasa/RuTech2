package io.github.dvegasa.rutechmeetup.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.rutechmeetup.MyApp
import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

const val ARG_NAME = "name"
const val ARG_JOB = "job"
const val ARG_TAGS = "tags"
const val ARG_AVA = "ava"

class MainActivity : AppCompatActivity() {

    companion object {
        fun getIntent(
            context: Context,
            name: String,
            job: String,
            tags: String,
            ava_base64: String
        ): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(ARG_NAME, name)
            intent.putExtra(ARG_JOB, job)
            intent.putExtra(ARG_TAGS, tags)
            intent.putExtra(ARG_AVA, ava_base64)
            return intent
        }
    }

    var name: String? = null
    var job: String? = null
    var tags: String? = null
    var ava_base64: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val extras = intent.extras
        if (extras != null) {
            val name = extras.getString(ARG_NAME)
            val job = extras.getString(ARG_JOB)
            val tags = extras.getString(ARG_TAGS)
            val ava_base64 = extras.getString(ARG_AVA)
        }
        writeToLocalStorage()
        initWebView()
    }

    private fun initWebView() {
        webView.webViewClient = MyWebView {writeToLocalStorage()}
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(message: String, lineNumber: Int, sourceID: String) {
                Log.d("ed__webview", "$message -- From line $lineNumber of $sourceID")
            }
        }

        webView.settings.defaultTextEncodingName = "utf-8"
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccessFromFileURLs = true
        webView.settings.allowUniversalAccessFromFileURLs = true
        webView.loadUrl("http://social-game-hack.herokuapp.com/")
    }

    private fun writeToLocalStorage() {
        val websettings = webView.settings
        websettings.domStorageEnabled = true;  // Open DOM storage function
        websettings.setAppCacheMaxSize(1024*1024*8)
        val appCachePath: String = applicationContext.cacheDir.absolutePath
        websettings.setAppCachePath(appCachePath)
        websettings.allowFileAccess = true
        websettings.setAppCacheEnabled(true)

        webView.evaluateJavascript("window.localStorage.setItem('"+ ARG_NAME +"','"+ name +"');", null);
        webView.evaluateJavascript("window.localStorage.setItem('"+ ARG_JOB +"','"+  job +"');", null);
        webView.evaluateJavascript("window.localStorage.setItem('"+ ARG_TAGS +"','"+ tags +"');", null);
        webView.evaluateJavascript("window.localStorage.setItem('"+ ARG_AVA +"','"+  ava_base64 +"');", null);

    }
}
