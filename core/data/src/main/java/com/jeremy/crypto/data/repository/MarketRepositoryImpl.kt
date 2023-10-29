package com.jeremy.crypto.data.repository

import com.jeremy.crypto.data.datasource.MarketDataSource
import com.jeremy.crypto.datastore.CurrencyCacheDataStore
import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.model.MarketCodeResponseItem
import com.jeremy.crypto.model.MarketCurrencyItem
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val marketDataSource: MarketDataSource,
    private val cacheDataStore: CurrencyCacheDataStore
) : MarketRepository {

    override val marketCache = cacheDataStore.upbitCache
    override suspend fun getMarketCode(): List<MarketCodeResponseItem> {
        return marketDataSource.getMarketCode()
    }

    override suspend fun setMarketCode(krwCodes: List<String>, btcCodes: List<String>) {
        cacheDataStore.setUpbitCurrencyCache(
            krwMarketCode = krwCodes,
            btcMarketCode = btcCodes
        )
    }

    override suspend fun getMarketsTicker(markets: String): List<MarketCurrencyItem> {
        return marketDataSource.getMarketsTicker(markets)
    }
}