package com.jeremy.crypto.data.datasource

import com.jeremy.crypto.model.MarketCodeResponseItem

interface MarketDataSource {
    suspend fun getMarketCode(): List<MarketCodeResponseItem>
}