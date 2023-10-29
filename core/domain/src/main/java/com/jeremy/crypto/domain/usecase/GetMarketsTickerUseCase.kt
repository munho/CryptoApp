package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.model.MarketCurrencyItem
import javax.inject.Inject

class GetMarketsTickerUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {
    suspend fun execute(markets: String): List<MarketCurrencyItem> {
        return marketRepository.getMarketsTicker(markets)
    }
}