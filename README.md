# Kryptonim Android SDK

The Kryptonim Android SDK is a library that allows you to easily integrate Kryptonim payments into your app. If you want to add Kryptonim payments to your app without using the SDK, you can do so using a browser. Check [here](https://github.com/kryptonim-sdk/android-webview-demo).

Full API documentation can be found [here](https://www.kryptonim.com/api-documentation).

## Installation
Add library repository to your root `build.gradle`:
```kotlin
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add dependency to desired `build.gradle` file:
```kotlin
dependencies {
    implementation 'com.github.kryptonim-sdk:android:1.+'
}
```

## Usage

Create an `ActivityResultLauncher` for `KryptonimTransactionResultContract` where you can take actions depending on the transaction result. The result type is the `TransactionResult` enum, which has three possible values:
- `SUCCESS`: transaction process finished with success
- `FAILURE`: transaction process finished with failure
- `EXIT`: transaction process intent was closed

```kotlin
private var kryptonimResultLauncher = registerForActivityResult(Kryptonim.createTransactionResultContract()) { result ->
    when (result) {
        TransactionResult.SUCCESS -> println("SUCCESS!")
        TransactionResult.FAILURE -> println("FAILURE!")
        TransactionResult.EXIT -> println("Kryptonim closed")
    }
}
```

Create a `KryptonimConfiguration` object with all data you want to pass as parameters so your app user doesn't have to fill them during transaction process. All parameters and restrictions on their use can be checked [here](https://www.kryptonim.com/api-documentation).
```kotlin
val configuration = KryptonimConfiguration(
    // 'Environment' defaults to .production. Select .sandbox for a test environment.
    environment = Environment.SANDBOX,
    transaction = Transaction(amount = "0.5", currency = FiatCurrency.EUR),
    creditCard = CreditCard(cardNumber = "11111111111111", cardCVV = "111", cardHolder = "John Smith"),
    theme = Theme.LIGHT
)
```

Launch created earlier launcher with configuration object.
```kotlin
kryptonimResultLauncher.launch(configuration)
```
