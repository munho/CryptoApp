package com.jeremy.crypto.network.service

import com.jeremy.crypto.model.MarketCodeResponseItem
import com.jeremy.crypto.model.MarketCurrencyItem
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitService {
    @GET("/v1/market/all")
    suspend fun getMarketCode(): List<MarketCodeResponseItem>

    @GET("/v1/ticker")
    suspend fun getMarketTicker(
        @Query("markets") markets: String
    ): List<MarketCurrencyItem>
}