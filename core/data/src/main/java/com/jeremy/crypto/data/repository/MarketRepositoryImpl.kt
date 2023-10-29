package com.jeremy.crypto.data.repository

import com.jeremy.crypto.data.datasource.MarketDataSource
import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.model.MarketCodeResponseItem
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val marketDataSource: MarketDataSource
): MarketRepository {
    override suspend fun getMarketCode(): List<MarketCodeResponseItem> {
        return marketDataSource.getMarketCode()
    }
}