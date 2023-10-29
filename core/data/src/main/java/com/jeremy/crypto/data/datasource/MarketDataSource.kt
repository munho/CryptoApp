package com.jeremy.crypto.data.datasource

import com.jeremy.crypto.model.MarketCodeResponseItem
import com.jeremy.crypto.model.MarketCurrencyItem

interface MarketDataSource {
    suspend fun getMarketCode(): List<MarketCodeResponseItem>

    suspend fun getMarketsTicker(markets: String): List<MarketCurrencyItem>
}