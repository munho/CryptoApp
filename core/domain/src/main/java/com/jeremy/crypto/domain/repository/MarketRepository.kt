package com.jeremy.crypto.domain.repository

import com.jeremy.crypto.model.MarketCodeResponseItem

interface MarketRepository {
    suspend fun getMarketCode(): List<MarketCodeResponseItem>
}