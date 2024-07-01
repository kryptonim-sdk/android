package com.kryptonim.sdk.core

/**
 * An enumeration representing various supported networks.
 * Each case corresponds to a specific blockchain network.
 *
 * @property networkName The name of the network.
 *
 * @constructor Creates an instance of the Blockchain enum with the specified name.
 */
public enum class Blockchain(public val networkName: String) {
    /** Represents the Arbitrum blockchain network */
    ARBITRUM("Arbitrum"),

    /** Represents the Avalanche blockchain network */
    AVALANCHE("Avalanche"),

    /** Represents the Bitcoin blockchain network */
    BITCOIN("Bitcoin"),

    /** Represents the Ethereum blockchain network */
    ETHEREUM("Ethereum"),

    /** Represents the Optimism blockchain network */
    OPTIMISM("Optimism"),

    /** Represents the Polygon blockchain network */
    POLYGON("Polygon"),

    /** Represents the Solana blockchain network */
    SOLANA("Solana"),

    /** Represents the TRON blockchain network */
    TRON("Tron")
}
