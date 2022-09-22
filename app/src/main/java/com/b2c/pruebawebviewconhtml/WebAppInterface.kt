package com.b2c.pruebawebviewconhtml

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast
class WebAppInterface(private val mContext: Context, val webViewInterface: WebViewInterface) {

    @JavascriptInterface
    fun showToast(toast: String) {
        webViewInterface.setMaxSize(true)
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}

interface WebViewInterface {
    fun setMaxSize(isFullSize: Boolean)
}