package com.example.miujsag.ui.archive

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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.miujsag.R

class ArchiveFragment : Fragment() {

    private lateinit var archiveViewModel: ArchiveViewModel
    private lateinit var webview:WebView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        archiveViewModel =
                ViewModelProvider(this).get(ArchiveViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_archive, container, false)
        val textView: TextView = root.findViewById(R.id.text_archive)
        archiveViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webview = view.findViewById(R.id.archive_webview)

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView, url:String) {
                webview.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()")
            }
        }

        webview.settings.javaScriptEnabled = true
        webview.settings.javaScriptCanOpenWindowsAutomatically = true
        webview.settings.allowFileAccessFromFileURLs = true
        webview.settings.loadsImagesAutomatically = true
        webview.settings.mixedContentMode = 0
        webview.settings.domStorageEnabled = true

        val folder = "https://drive.google.com/drive/u/0/folders/16mc_gUCCg2qjBfj3LFI2xKW9FjlgE8b_"
        webview.loadUrl(folder)

        webview.clearCache(true)
        webview.clearHistory()


        super.onViewCreated(view, savedInstanceState)
    }
}