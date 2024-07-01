package com.kryptonim.sdk.utilities

import android.net.Uri
import com.kryptonim.sdk.Kryptonim
import com.kryptonim.sdk.core.KryptonimConfiguration

/**
 * Builds the URL with the parameters specified in the configuration.
 *
 * @return The URL with query parameters added.
 */
internal fun KryptonimConfiguration.toUrl(): Uri {
    val urlBuilder = Uri.parse(url).buildUpon()

    // Transaction object
    transaction?.let { urlBuilder.appendAsQuery(it) }

    // CreditCard object
    creditCard?.let { urlBuilder.appendAsQuery(it) }

    // Billing object
    billing?.let { urlBuilder.appendAsQuery(it) }

    // Theme object
    theme?.let { urlBuilder.appendAsQuery(it) }

    // Appends redirect query items (success and failure URLs) to the provided URL.
    urlBuilder.appendQueryParameter("successUrl", KryptonimTransactionResultContract.successUrl)
    urlBuilder.appendQueryParameter("failureUrl", KryptonimTransactionResultContract.failureUrl)

    return urlBuilder.build()
}
