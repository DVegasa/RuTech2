package io.github.dvegasa.rutechmeetup.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWebView()
    }

    private fun initWebView() {
        webView.webViewClient = MyWebView()
        webView.settings.defaultTextEncodingName = "utf-8"
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("http://social-game-hack.herokuapp.com/")

    }
}
