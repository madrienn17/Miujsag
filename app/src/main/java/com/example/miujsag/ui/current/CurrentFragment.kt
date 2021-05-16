package com.example.miujsag.ui.current

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.miujsag.R


class CurrentFragment :Fragment() {

    private lateinit var currentViewModel: CurrentViewModel
    private lateinit var webview:WebView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        currentViewModel =
                ViewModelProvider(this).get(CurrentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_current, container, false)
        val textView: TextView = root.findViewById(R.id.text_current)
        currentViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webview = view.findViewById(R.id.current_webview)

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished( view:WebView, url:String) {
                webview.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()")
            }
        }

        webview.settings.javaScriptEnabled = true
        webview.settings.javaScriptCanOpenWindowsAutomatically = true
        webview.settings.allowFileAccessFromFileURLs = true
        webview.settings.loadsImagesAutomatically = true
        webview.settings.mixedContentMode = 0
        // enable Web Storage: localStorage, sessionStorage
        webview.settings.domStorageEnabled = true

        val pdf = "https://drive.google.com/u/0/uc?id=1Ah-3TnuOzbvZAx8k1uf_McdjIjIArzSl&export=download"
        webview.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdf")

        webview.clearCache(true)
        webview.clearHistory()


        super.onViewCreated(view, savedInstanceState)
    }
}