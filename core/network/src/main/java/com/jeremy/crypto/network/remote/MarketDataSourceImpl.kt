package com.jeremy.crypto.network.remote

import com.jeremy.crypto.model.MarketCodeResponseItem
import com.jeremy.crypto.data.datasource.MarketDataSource
import com.jeremy.crypto.model.MarketCurrencyItem
import com.jeremy.crypto.network.service.UpbitService
import javax.inject.Inject

class MarketDataSourceImpl @Inject constructor(
    private val upbitService: UpbitService
): MarketDataSource {
    override suspend fun getMarketCode(): List<MarketCodeResponseItem> {
        return upbitService.getMarketCode()
    }

    override suspend fun getMarketsTicker(markets: String): List<MarketCurrencyItem> {
        return upbitService.getMarketTicker(markets)
    }

}