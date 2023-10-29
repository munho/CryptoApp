package com.jeremy.crypto.model

import kotlinx.serialization.Serializable
@Serializable
data class MarketCodeResponseItem(
    val english_name: String,
    val korean_name: String,
    val market: String
)