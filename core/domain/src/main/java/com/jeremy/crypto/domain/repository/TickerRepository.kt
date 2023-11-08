package com.jeremy.crypto.domain.repository

import com.jeremy.crypto.model.MarketCurrencyItem
import kotlinx.coroutines.flow.Flow

interface TickerRepository {
    suspend fun getMarketsTicker(markets: String): List<MarketCurrencyItem>

    fun getMarketTickers(): Flow<List<MarketCurrencyItem>>
}