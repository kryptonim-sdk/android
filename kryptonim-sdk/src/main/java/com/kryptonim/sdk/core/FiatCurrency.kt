package com.kryptonim.sdk.core

/**
 * An enumeration representing supported fiat currencies.
 * Each case corresponds to a specific fiat currency identified by its ISO 4217 code.
 *
 * @property code The ISO 4217 code for the currency.
 *
 * @constructor Creates an instance of the FiatCurrency enum with the specified ISO 4217 code.
 */
public enum class FiatCurrency(public val code: String) {
    /** Argentine Peso (ARS) */
    ARS("ARS"),

    /** Australian Dollar (AUD) */
    AUD("AUD"),

    /** Bulgarian Lev (BGN) */
    BGN("BGN"),

    /** Brazilian Real (BRL) */
    BRL("BRL"),

    /** Canadian Dollar (CAD) */
    CAD("CAD"),

    /** Swiss Franc (CHF) */
    CHF("CHF"),

    /** Chilean Peso (CLP) */
    CLP("CLP"),

    /** Colombian Peso (COP) */
    COP("COP"),

    /** Czech Koruna (CZK) */
    CZK("CZK"),

    /** Danish Krone (DKK) */
    DKK("DKK"),

    /** Euro (EUR) */
    EUR("EUR"),

    /** Pound Sterling (GBP) */
    GBP("GBP"),

    /** Forint (HUF) */
    HUF("HUF"),

    /** Rupiah (IDR) */
    IDR("IDR"),

    /** Yen (JPY) */
    JPY("JPY"),

    /** Mexican Peso (MXN) */
    MXN("MXN"),

    /** Norwegian Krone (NOK) */
    NOK("NOK"),

    /** New Zealand Dollar (NZD) */
    NZD("NZD"),

    /** Zloty (PLN) */
    PLN("PLN"),

    /** Romanian Leu (RON) */
    RON("RON"),

    /** Saudi Riyal (SAR) */
    SAR("SAR"),

    /** Swedish Krona (SEK) */
    SEK("SEK"),

    /** Baht (THB) */
    THB("THB"),

    /** Turkish Lira (TRY) */
    TRY("TRY"),

    /** Hryvnia (UAH) */
    UAH("UAH"),

    /** US Dollar (USD) */
    USD("USD"),

    /** Dong (VND) */
    VND("VND")
}
