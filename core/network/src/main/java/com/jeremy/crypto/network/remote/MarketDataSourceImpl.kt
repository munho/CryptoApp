package com.jeremy.crypto.network.remote

import com.jeremy.crypto.model.MarketCodeResponseItem
import com.jeremy.crypto.data.datasource.MarketDataSource
import com.jeremy.crypto.network.service.UpbitService
import javax.inject.Inject

class MarketDataSourceImpl @Inject constructor(
    private val upbitService: UpbitService
): MarketDataSource {
    override suspend fun getMarketCode(): List<MarketCodeResponseItem> {
        return upbitService.getMarketCode()
    }

}