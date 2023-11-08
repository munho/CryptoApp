package com.jeremy.crypto.data.repository

import android.util.Log
import com.jeremy.crypto.cache.TickerCache
import com.jeremy.crypto.data.datasource.MarketDataSource
import com.jeremy.crypto.domain.repository.TickerRepository
import com.jeremy.crypto.model.MarketCurrencyItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TickerRepositoryImpl @Inject constructor(
    private val marketDataSource: MarketDataSource,
    private val tickerCache: TickerCache
) : TickerRepository {

    override suspend fun getMarketsTicker(markets: String): List<MarketCurrencyItem> {
        val result = marketDataSource.getMarketsTicker(markets)
        result.forEach {
            tickerCache.set(it.market, it)
        }
        return result
    }

    override fun getMarketTickers(): Flow<List<MarketCurrencyItem>> {
        return tickerCache.getListFlow()
    }
}
