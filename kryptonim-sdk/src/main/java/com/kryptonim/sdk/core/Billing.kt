package com.kryptonim.sdk.core

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents billing information for a customer.
 *
 * @property firstName Customer's first name
 * @property lastName Customer's last name
 * @property city Customer's city
 * @property streetAddress Customer's street address
 * @property postalCode Customer's postal code
 * @property country Customer's country
 * @property countryCode Customer's country code
 * @property state Customer's state
 */
@Parcelize
public class Billing(
    public val firstName: String? = null,
    public val lastName: String? = null,
    public val city: String? = null,
    public val streetAddress: String? = null,
    public val postalCode: String? = null,
    public val country: String? = null,
    public val countryCode: String? = null,
    public val state: String? = null
) : Parcelable
