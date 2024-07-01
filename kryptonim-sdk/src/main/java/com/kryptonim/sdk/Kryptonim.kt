package com.kryptonim.sdk

import androidx.activity.result.contract.ActivityResultContract
import com.kryptonim.sdk.core.KryptonimConfiguration
import com.kryptonim.sdk.utilities.KryptonimTransactionResultContract
import com.kryptonim.sdk.core.TransactionResult

/**
 * The `Kryptonim` object provides methods to create transaction result contracts and transaction configuration objects.
 */
public object Kryptonim {
    /** The URL for the iframe form. */
    internal const val sandboxUrl: String = "https://intg.kryptonim.com/iframe-form"
    internal const val productionUrl: String = "https://buy.kryptonim.com/iframe-form"

    /**
     * Creates and returns a new `ActivityResultContract` for handling transaction results.
     *
     * @return ActivityResultContract<KryptonimTransactionConfig, TransactionResult>
     */
    public fun createTransactionResultContract(): ActivityResultContract<KryptonimConfiguration, TransactionResult> {
        return KryptonimTransactionResultContract()
    }
}
