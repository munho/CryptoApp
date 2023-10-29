package com.jeremy.crypto.domain.repository

import com.jeremy.crypto.model.CurrencyCache
import com.jeremy.crypto.model.MarketCodeResponseItem
import com.jeremy.crypto.model.MarketCurrencyItem
import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    val marketCache: Flow<CurrencyCache>
    suspend fun getMarketCode(): List<MarketCodeResponseItem>

    suspend fun setMarketCode(krwCodes: List<String>, btcCodes: List<String>)

    suspend fun getMarketsTicker(markets: String): List<MarketCurrencyItem>
}