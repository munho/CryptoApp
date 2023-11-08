package com.jeremy.crypto.model

import java.math.BigDecimal

data class CurrencyUiItem(
    val market: String,
    val tradeDate: String,
    val tradePrice: BigDecimal,
    val tradeTime: String,
    val tradeVolume: Double,
    val accTradePrice: BigDecimal, //거래 대금
    val change: String,
    val changePrice: Double,
    val changeRate: Double,
    val highPrice: Double,
    val lowPrice: Double,
    val openingPrice: Double,
    val prevClosingPrice: Double,
    val signedChangePrice: Double,
    val signedChangeRate: Double,
    val timestamp: Long,

)