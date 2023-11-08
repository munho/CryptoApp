package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.TickerRepository
import com.jeremy.crypto.model.CurrencyUiItem
import com.jeremy.crypto.model.MarketCurrencyItem
import javax.inject.Inject

class GetMarketsTickerUseCase @Inject constructor(
    private val tickerRepository: TickerRepository
) {
    suspend operator fun invoke(markets: String): List<CurrencyUiItem> {
        return tickerRepository.getMarketsTicker(markets)
            .map(MarketCurrencyItem::mapTo)
            .sortedByDescending { it.accTradePrice }
    }
}