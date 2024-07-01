package com.kryptonim.sdk.core

/**
 * An enumeration representing supported cryptocurrencies.
 * Each case corresponds to a specific cryptocurrency and its associated symbol.
 *
 * @property symbol The symbol for the cryptocurrency.
 *
 * @constructor Creates an instance of the CryptoCurrency enum with the specified symbol.
 */
public enum class CryptoCurrency(public val symbol: String) {
    /** Represents the cryptocurrency DAI */
    DAI("DAI"),

    /** Represents the cryptocurrency ARB */
    ARB("ARB"),

    /** Represents Wrapped Bitcoin (WBTC) */
    WBTC("WBTC"),

    /** Represents USD Coin (USDC) */
    USDC("USDC"),

    /** Represents Tether (USDT) */
    USDT("USDT"),

    /** Represents Ethereum (ETH) */
    ETH("ETH"),

    /** Represents Avalanche (AVAX) */
    AVAX("AVAX"),

    /** Represents Bitcoin (BTC) */
    BTC("BTC"),

    /** Represents Uniswap (UNI) */
    UNI("UNI"),

    /** Represents Polygon (MATIC) */
    MATIC("MATIC"),

    /** Represents Shiba Inu (SHIB) */
    SHIB("SHIB"),

    /** Represents TrueUSD (TUSD) */
    TUSD("TUSD"),

    /** Represents Binance USD (BUSD) */
    BUSD("BUSD"),

    /** Represents Wrapped Ether (WETH) */
    WETH("WETH"),

    /** Represents Solana (SOL) */
    SOL("SOL"),

    /** Represents TRON (TRX) */
    TRX("TRX")
}
