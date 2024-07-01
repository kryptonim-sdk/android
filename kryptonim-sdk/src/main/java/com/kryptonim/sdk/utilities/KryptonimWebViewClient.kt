package com.kryptonim.sdk.utilities

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.kryptonim.sdk.Kryptonim

internal class KryptonimWebViewClient(
    val onSuccess: () -> Unit,
    val onFailure: () -> Unit
) : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val uri = request?.url
        println(request?.requestHeaders?.entries)
        return when (uri.toString()) {
            KryptonimTransactionResultContract.successUrl -> {
                onSuccess()
                true
            }
            KryptonimTransactionResultContract.failureUrl -> {
                onFailure()
                true
            }
            else -> false
        }
    }
}
