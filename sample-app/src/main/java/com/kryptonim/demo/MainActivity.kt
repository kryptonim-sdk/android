package com.kryptonim.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kryptonim.demo.ui.theme.KryptonimsdkandroidTheme
import com.kryptonim.sdk.core.FiatCurrency
import com.kryptonim.sdk.Kryptonim
import com.kryptonim.sdk.core.CreditCard
import com.kryptonim.sdk.core.Environment
import com.kryptonim.sdk.core.KryptonimConfiguration
import com.kryptonim.sdk.core.Theme
import com.kryptonim.sdk.core.Transaction
import com.kryptonim.sdk.core.TransactionResult

class MainActivity : ComponentActivity() {

    private var kryptonimResultLauncher = registerForActivityResult(Kryptonim.createTransactionResultContract()) { result ->
        when (result) {
            TransactionResult.SUCCESS -> println("SUCCESS!")
            TransactionResult.FAILURE -> println("FAILURE!")
            TransactionResult.EXIT -> println("Kryptonim closed")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KryptonimsdkandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    KryptonimButton()
                }
            }
        }
    }

    @Composable
    fun KryptonimButton() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                val configuration = KryptonimConfiguration(
                    environment = Environment.SANDBOX,
                    transaction = Transaction(amount = "0.5", currency = FiatCurrency.EUR),
                    creditCard = CreditCard(cardNumber = "11111111111111", cardCVV = "111", cardHolder = "John Smith"),
                    theme = Theme.LIGHT
                )
                kryptonimResultLauncher.launch(configuration)
            }) {
                Text(text = "Open Kryptonim")
            }
        }
    }
}




