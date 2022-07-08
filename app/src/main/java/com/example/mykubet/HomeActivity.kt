package com.example.mykubet

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    private val URL_KUBET = "https://vn.ku6123.net/Mobile/Home/Login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val progress = findViewById<FrameLayout>(R.id.progressBar)
        val webView = findViewById<WebView>(R.id.webView).apply {
            this.settings.javaScriptEnabled = true
            this.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(URL_KUBET)
                    return true
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    progress.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progress.visibility = View.GONE
                }
            }
            this.loadUrl(URL_KUBET)
        }
        val settings: WebSettings = webView.settings
        settings.domStorageEnabled = true
    }
}