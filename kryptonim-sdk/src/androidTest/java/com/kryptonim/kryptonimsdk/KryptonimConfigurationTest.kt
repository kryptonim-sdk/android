package com.kryptonim.kryptonimsdk

import com.kryptonim.sdk.core.Billing
import com.kryptonim.sdk.core.Blockchain
import com.kryptonim.sdk.core.CreditCard
import com.kryptonim.sdk.core.CryptoCurrency
import com.kryptonim.sdk.core.FiatCurrency
import com.kryptonim.sdk.Kryptonim
import com.kryptonim.sdk.core.KryptonimConfiguration
import com.kryptonim.sdk.core.PaymentMethod
import com.kryptonim.sdk.core.Theme
import com.kryptonim.sdk.core.Transaction
import com.kryptonim.sdk.utilities.toUrl
import org.junit.Assert.*
import org.junit.Test

class KryptonimConfigurationTest {

    @Test
    fun testBuildUrlWithParameters_success() {
        val transaction = Transaction(
            amount = "100.00",
            currency = FiatCurrency.USD,
            convertedAmount = null,
            convertedCurrency = CryptoCurrency.BTC,
            blockchain = Blockchain.ETHEREUM,
            walletAddress = "0x123",
            paymentMethod = PaymentMethod.CARD,
            customerMail = "test@example.com",
            m = null
        )

        val creditCard = CreditCard(
            cardNumber = "4111111111111111",
            cardCVV = "123",
            cardHolder = "John Doe",
            expiration = CreditCard.Expiration("12", "2025")
        )

        val billing = Billing(
            firstName = "John",
            lastName = "Doe",
            city = "New York",
            streetAddress = "123 Main St",
            postalCode = "10001",
            country = "USA",
            countryCode = "US",
            state = "NY"
        )

        val theme = Theme.DARK

        val config = KryptonimConfiguration(
            transaction = transaction,
            creditCard = creditCard,
            billing = billing,
            theme = theme
        )

        val result = config.toUrl()
        val expectedUrl = "${Kryptonim.productionUrl}?amount=100.00&currency=USD&convertedCurrency=BTC&blockchain=Ethereum&address=0x123&paymentMethod=CARD&customerMail=test%40example.com&cardNumber=4111111111111111&cardCVV=123&cardHolder=John%20Doe&cardExpMM=12&cardExpYY=2025&firstName=John&lastName=Doe&billingCity=New%20York&billingStreetAddress=123%20Main%20St&billingPostalCode=10001&billingCountry=USA&billingCountryCode=US&billingState=NY&theme=DARK&successUrl=https%3A%2F%2Fsuccess%2F&failureUrl=https%3A%2F%2Ffailure%2F"

        assertEquals(expectedUrl, result.toString())
    }
}
