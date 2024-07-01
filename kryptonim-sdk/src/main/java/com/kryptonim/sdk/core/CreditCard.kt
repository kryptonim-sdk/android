package com.kryptonim.sdk.core

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents a customer's credit card information.
 * @param cardNumber Customer’s credit card number
 * @param cardCVV Customer's credit card CVV number
 * @param cardHolder Customer's full name
 * @param expiration Customer’s credit card expiration month and year
 */
@Parcelize
public class CreditCard(
    public val cardNumber: String? = null,
    public val cardCVV: String? = null,
    public val cardHolder: String? = null,
    public val expiration: Expiration? = null
) : Parcelable {
    /**
     * Represents the expiration date of the credit card.
     * @param month Expiration month
     * @param year Expiration year
     */
    @Parcelize
    public class Expiration(
        public val month: String,
        public val year: String
    ) : Parcelable
}
