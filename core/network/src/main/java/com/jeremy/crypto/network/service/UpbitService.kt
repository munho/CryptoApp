package com.jeremy.crypto.network.service

import com.jeremy.crypto.model.MarketCodeResponseItem
import retrofit2.http.GET

interface UpbitService {
    @GET("/v1/market/all")
    suspend fun getMarketCode(): List<MarketCodeResponseItem>
}