package com.atritripathi.musk

import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.atritripathi.musk.databinding.WebViewFragmentBinding

class WebViewFragment : Fragment(R.layout.web_view_fragment) {

    private val args by navArgs<WebViewFragmentArgs>()
    private var _binding: WebViewFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = WebViewFragmentBinding.bind(view)

        with(binding.webView) {
            webViewClient = WebViewClient()
            loadUrl(args.url)
            setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && canGoBack()
                ) {
                    goBack() // Navigate back to previous web page if there is one
                    true
                } else false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}