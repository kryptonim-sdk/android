package com.kryptonim.sdk.utilities

import android.net.Uri
import com.kryptonim.sdk.core.Billing
import com.kryptonim.sdk.core.CreditCard
import com.kryptonim.sdk.core.Theme
import com.kryptonim.sdk.core.Transaction

/**
 * Helper function to append a query parameter to the URL builder if the value is not null.
 *
 * @param name The name of the query parameter.
 * @param value The value of the query parameter.
 */
internal fun Uri.Builder.appendQueryParameterIfNotNull(name: String, value: String?) {
    value?.let {
        this.appendQueryParameter(name, it)
    }
}

/**
 * Appends transaction details as query parameters to the URL builder.
 *
 * @param transaction The transaction details to append.
 */
internal fun Uri.Builder.appendAsQuery(transaction: Transaction) {
    appendQueryParameterIfNotNull("amount", transaction.amount)
    appendQueryParameterIfNotNull("currency", transaction.currency?.code)
    appendQueryParameterIfNotNull("convertedAmount", transaction.convertedAmount)
    appendQueryParameterIfNotNull("convertedCurrency", transaction.convertedCurrency?.symbol)
    appendQueryParameterIfNotNull("blockchain", transaction.blockchain?.networkName)
    appendQueryParameterIfNotNull("address", transaction.walletAddress)
    appendQueryParameterIfNotNull("paymentMethod", transaction.paymentMethod?.name)
    appendQueryParameterIfNotNull("customerMail", transaction.customerMail)
    appendQueryParameterIfNotNull("m", transaction.m)
}

/**
 * Appends credit card details as query parameters to the URL builder.
 *
 * @param creditCard The credit card details to append.
 */
internal fun Uri.Builder.appendAsQuery(creditCard: CreditCard) {
    appendQueryParameterIfNotNull("cardNumber", creditCard.cardNumber)
    appendQueryParameterIfNotNull("cardCVV", creditCard.cardCVV)
    appendQueryParameterIfNotNull("cardHolder", creditCard.cardHolder)
    appendQueryParameterIfNotNull("cardExpMM", creditCard.expiration?.month)
    appendQueryParameterIfNotNull("cardExpYY", creditCard.expiration?.year)
}

/**
 * Appends billing details as query parameters to the URL builder.
 *
 * @param billing The billing details to append.
 */
internal fun Uri.Builder.appendAsQuery(billing: Billing) {
    appendQueryParameterIfNotNull("firstName", billing.firstName)
    appendQueryParameterIfNotNull("lastName", billing.lastName)
    appendQueryParameterIfNotNull("billingCity", billing.city)
    appendQueryParameterIfNotNull("billingStreetAddress", billing.streetAddress)
    appendQueryParameterIfNotNull("billingPostalCode", billing.postalCode)
    appendQueryParameterIfNotNull("billingCountry", billing.country)
    appendQueryParameterIfNotNull("billingCountryCode", billing.countryCode)
    appendQueryParameterIfNotNull("billingState", billing.state)
}

/**
 * Appends theme details as query parameters to the URL builder.
 *
 * @param theme The theme details to append.
 */
internal fun Uri.Builder.appendAsQuery(theme: Theme) {
    appendQueryParameterIfNotNull("theme", theme.name)
}
