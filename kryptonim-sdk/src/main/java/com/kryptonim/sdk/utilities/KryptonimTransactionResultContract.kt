package com.kryptonim.sdk.utilities

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.kryptonim.sdk.KryptonimActivity
import com.kryptonim.sdk.Kryptonim
import com.kryptonim.sdk.KryptonimActivity.Companion.failureCode
import com.kryptonim.sdk.KryptonimActivity.Companion.successCode
import com.kryptonim.sdk.core.KryptonimConfiguration
import com.kryptonim.sdk.core.TransactionResult

internal class KryptonimTransactionResultContract : ActivityResultContract<KryptonimConfiguration, TransactionResult>() {

    override fun createIntent(context: Context, input: KryptonimConfiguration): Intent {
        return Intent(context, KryptonimActivity::class.java).apply {
            putExtra(KryptonimActivity.CONFIGURATION, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): TransactionResult {
        return when (resultCode) {
            successCode -> TransactionResult.SUCCESS
            failureCode -> TransactionResult.FAILURE
            else -> TransactionResult.EXIT
        }
    }

    companion object {
        /** The URL to redirect to upon a successful transaction. */
        internal const val successUrl: String = "https://success/"

        /** The URL to redirect to upon a failed transaction. */
        internal const val failureUrl: String = "https://failure/"
    }

}
