package com.b2c.pruebawebviewconhtml

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), WebViewInterface {
    private lateinit var constraintLayout: FrameLayout
    private lateinit var container2: RelativeLayout
    private lateinit var webViews: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.container)
        webViews = findViewById(R.id.webView1)

        loadWebView()

         supportFragmentManager.beginTransaction().addToBackStack(null)
           .replace(R.id.container, FragmentUno()).commit()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView() {
        webViews.webViewClient = WebViewClient()
        val webViewSettings = webViews.settings
        val settings: WebSettings = webViews.settings
        webViews.addJavascriptInterface(WebAppInterface(this, this), "Android")
        settings.domStorageEnabled = true

        webViews.loadUrl("file:///android_asset/index.html")

        webViewSettings.javaScriptEnabled = true
        webViewSettings.builtInZoomControls = true

        webViews.webViewClient = object : WebViewClient() {
            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                view!!.loadUrl(url!!)
                Toast.makeText(this@MainActivity,"cambios",Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                //Toast.makeText(this@MainActivity,"FINALIZO",Toast.LENGTH_SHORT).show()
            }
        }

        webViews.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
        }
    }

    override fun setMaxSize(isFullSize: Boolean) {
        if (isFullSize) {
            this.runOnUiThread(Runnable {
                webViews.layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            })
        }
    }
}