package com.kryptonim.sdk

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.webkit.ValueCallback
import android.webkit.WebView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.kryptonim.sdk.core.KryptonimConfiguration
import com.kryptonim.sdk.utilities.KryptonimWebViewChromeClient
import com.kryptonim.sdk.utilities.KryptonimWebViewClient
import com.kryptonim.sdk.utilities.parcelable
import com.kryptonim.sdk.utilities.toUrl

internal class KryptonimActivity : ComponentActivity() {

    private lateinit var configuration: KryptonimConfiguration
    private var filePathCallback: ValueCallback<Array<Uri>>? = null

    private val fileChooserLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val uris = result.data?.data?.let {
            arrayOf(it)
        } ?: arrayOf()
        filePathCallback?.onReceiveValue(uris)
        filePathCallback = null
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.parcelable<KryptonimConfiguration>(CONFIGURATION)?.let {
            configuration = it
        }
        val webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            webChromeClient = KryptonimWebViewChromeClient(fileChooserLauncher) { filePathCallback = it }
            webViewClient = KryptonimWebViewClient(
                onSuccess = {
                    setResult(successCode)
                    finish()
                },
                onFailure = {
                    setResult(failureCode)
                    finish()
                }
            )
            val builtUrl = configuration.toUrl()
            loadUrl(builtUrl.toString())
        }
        setContentView(webView)
    }

    companion object {
        internal const val CONFIGURATION = "configuration"

        /** The code indicating a successful transaction. */
        internal const val successCode: Int = 1

        /** The code indicating a failed transaction. */
        internal const val failureCode: Int = 2
    }
}
