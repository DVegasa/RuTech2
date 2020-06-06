package io.github.dvegasa.rutechmeetup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWebView()
    }

    private fun initWebView() {
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("http://social-game-hack.herokuapp.com/")
    }
}
