package com.kryptonim.sdk.core

/**
 * An enumeration representing the environment in which a transaction will be processed.
 * The environment determines whether the transaction is processed in a testing or live production setting.
 */
public enum class Environment {
    /** Represents a sandbox environment for testing transactions. Transactions processed in this environment are not real and do not affect real accounts or funds. */
    SANDBOX,

    /** Represents a production environment for live transactions. Transactions processed in this environment are real and affect real accounts and funds. */
    PRODUCTION
}

