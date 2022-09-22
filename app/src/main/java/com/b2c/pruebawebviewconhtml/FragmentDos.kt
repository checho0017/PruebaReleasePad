package com.b2c.pruebawebviewconhtml

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment

class FragmentDos : Fragment()/*, WebViewInterface */{

    private lateinit var vista: View
    private lateinit var container2: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_dos, container, false)

        container2 = vista.findViewById(R.id.container2)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container2, com.b2c.pruebawebviewconhtml.WebView()).commit()

        return vista
    }

   // @SuppressLint("SetJavaScriptEnabled")
    /*   private fun loadWebView() {
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
                   Toast.makeText(this@MainActivity,"cambios", Toast.LENGTH_SHORT).show()
                   return true
               }

               override fun onPageFinished(view: WebView?, url: String?) {
                   super.onPageFinished(view, url)
                   Toast.makeText(this@MainActivity,"FINALIZO", Toast.LENGTH_SHORT).show()
               }
           }

           webViews.webChromeClient = object : WebChromeClient() {
               override fun onProgressChanged(view: WebView?, newProgress: Int) {
                   super.onProgressChanged(view, newProgress)
               }
           }
       }*/


   /* override fun setMaxSize(isFullSize: Boolean) {
        if (isFullSize) {
                requireActivity().runOnUiThread(Runnable {
                    container2.layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )
                })
        }
    }*/
}