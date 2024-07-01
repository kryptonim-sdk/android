package com.kryptonim.sdk.utilities

import android.content.Intent
import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.result.ActivityResultLauncher

internal class KryptonimWebViewChromeClient(
    private val fileChooserLauncher: ActivityResultLauncher<Intent>,
    private var onFilePathCallback: (ValueCallback<Array<Uri>>?) -> Unit
) : WebChromeClient() {

    override fun onShowFileChooser(
        webView: WebView?,
        filePath: ValueCallback<Array<Uri>>,
        fileChooserParams: FileChooserParams
    ): Boolean {
        onFilePathCallback(filePath)
        val intent = fileChooserParams.createIntent()
        try {
            fileChooserLauncher.launch(intent)
        } catch (e: Exception) {
            return false
        }
        return true
    }

}
