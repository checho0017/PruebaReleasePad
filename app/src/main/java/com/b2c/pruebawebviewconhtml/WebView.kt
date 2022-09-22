package com.b2c.pruebawebviewconhtml

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.Toast

class WebView : Fragment(),WebViewInterface {
    private lateinit var webView : WebView
    private lateinit var vista : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista  = inflater.inflate(R.layout.fragment_web_view, container, false)
        webView = vista.findViewById(R.id.webView)
        loadWebView()

        return vista
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView() {
        webView.webViewClient = WebViewClient()
        val webViewSettings = webView.settings
        val settings: WebSettings = webView.settings
        webView.addJavascriptInterface(WebAppInterface(requireContext(), this), "Android")
        settings.domStorageEnabled = true

        webView.loadUrl("file:///android_asset/index.html")

        webViewSettings.javaScriptEnabled = true
        webViewSettings.builtInZoomControls = true

        webView.webViewClient = object : WebViewClient() {
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
                Toast.makeText(requireActivity(),"cambios", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                //Toast.makeText(requireActivity(),"FINALIZO", Toast.LENGTH_SHORT).show()
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
        }
    }

    override fun setMaxSize(isFullSize: Boolean) {
        if (isFullSize) {
            requireActivity().runOnUiThread(Runnable {
                webView.layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            })
        }
    }
}