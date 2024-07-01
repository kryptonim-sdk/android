package com.kryptonim.sdk.core

/**
 * An enumeration representing the possible outcomes of a transaction.
 */
public enum class TransactionResult {
    /** Indicates that the transaction was successful. */
    SUCCESS,

    /** Indicates that the transaction failed. */
    FAILURE,

    /** Indicates that the transaction was exited without completion. */
    EXIT
}
