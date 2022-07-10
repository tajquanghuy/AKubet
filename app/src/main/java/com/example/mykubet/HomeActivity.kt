package com.example.mykubet

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mykubet.MainActivity.Companion.KEY_INTENT


class HomeActivity : AppCompatActivity() {
    private val URL_KUBET = "https://vn.ku6123.net/Mobile/Home/Login"
    private val URL_SUPPORT = "https://vn.ku6123.net/Mobile/Member/ServiceCenter"
    private val URL_REGISTER = "https://vn.ku6123.net/Mobile/Register/Register"
    private var urlWebView : String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        when(intent.getIntExtra(KEY_INTENT, 1)){
            1 -> urlWebView = URL_KUBET
            2 -> urlWebView = URL_SUPPORT
            3 -> urlWebView = URL_REGISTER
        }
        val progress = findViewById<FrameLayout>(R.id.progressBar)
        val webView = findViewById<WebView>(R.id.webView)
            webView.apply {
            this.settings.javaScriptEnabled = true
            this.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url ?: URL_KUBET)
                    return true
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    webView.visibility = View.GONE
                    progress.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    webView.visibility = View.VISIBLE
                    progress.visibility = View.GONE
                }
            }
                Log.d("huytq", "onCreate: $urlWebView")
            this.loadUrl(urlWebView ?: URL_KUBET)
        }
        val settings: WebSettings = webView.settings
        settings.domStorageEnabled = true
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}