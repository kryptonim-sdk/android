package com.kryptonim.sdk.core

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents transaction details.
 *
 * @param amount Amount in the Fiat currency
 * @param currency Fiat currency
 * @param convertedAmount Amount in the Cryptocurrency
 * @param convertedCurrency Cryptocurrency
 * @param blockchain Wallet's Network
 * @param walletAddress Customer's wallet address
 * @param paymentMethod The selected payment method ('card', 'bank'). Note that the "bank" payment method is only available for Euro fiat currency
 * @param customerMail Customer’s e-mail address
 * @param m Merchant identificator
 */
@Parcelize
public class Transaction(
    public val amount: String? = null,
    public val currency: FiatCurrency? = null,
    public val convertedAmount: String? = null,
    public val convertedCurrency: CryptoCurrency? = null,
    public val blockchain: Blockchain? = null,
    public val walletAddress: String? = null,
    public val paymentMethod: PaymentMethod? = null,
    public val customerMail: String? = null,
    public val m: String? = null
) : Parcelable
