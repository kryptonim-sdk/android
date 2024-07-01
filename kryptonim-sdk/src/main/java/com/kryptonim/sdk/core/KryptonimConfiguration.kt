package com.kryptonim.sdk.core

import android.os.Parcelable
import com.kryptonim.sdk.Kryptonim
import kotlinx.parcelize.Parcelize

/**
 * Defines the configuration for a Kryptonim transaction. This interface provides
 * properties for transaction url, setting transaction details, credit card information, billing details,
 * and the theme for the transaction UI.
 */
public interface KryptonimConfiguration : Parcelable {
    public val url: String
    public val transaction: Transaction?
    public val creditCard: CreditCard?
    public val billing: Billing?
    public val theme: Theme?
}

/**
 * Creates and returns a new `KryptonimConfiguration` object with the provided parameters.
 *
 * @param environment An `Environment` object specifying where the transaction will be processed.
 * @param transaction Optional: A `Transaction` object representing the transaction details.
 * @param creditCard Optional: A `CreditCard` object containing credit card information.
 * @param billing Optional: A `Billing` object with billing details.
 * @param theme Optional: A `Theme` object to customize the appearance.
 * @return KryptonimConfiguration
 */
public fun KryptonimConfiguration(
    environment: Environment = Environment.PRODUCTION,
    transaction: Transaction? = null,
    creditCard: CreditCard? = null,
    billing: Billing? = null,
    theme: Theme? = null
): KryptonimConfiguration {
    val url: String = when (environment) {
        Environment.PRODUCTION -> Kryptonim.productionUrl
        Environment.SANDBOX -> Kryptonim.sandboxUrl
    }
    return KryptonimConfigurationImpl(
        url = url,
        transaction = transaction,
        creditCard = creditCard,
        billing = billing,
        theme = theme
    )
}

/**
 * A class representing the configuration for a Kryptonim transaction.
 *
 * @property url The URL to load the iframe form.
 * @property transaction The transaction details.
 * @property creditCard The credit card information.
 * @property billing The billing information.
 * @property theme The theme for the transaction interface.
 */
@Parcelize
private class KryptonimConfigurationImpl(
    override val url: String,
    override val transaction: Transaction?,
    override val creditCard: CreditCard?,
    override val billing: Billing?,
    override val theme: Theme?
) : KryptonimConfiguration
