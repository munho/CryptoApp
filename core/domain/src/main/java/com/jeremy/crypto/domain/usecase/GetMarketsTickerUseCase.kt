package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.model.CurrencyUiItem
import com.jeremy.crypto.model.MarketCurrencyItem
import javax.inject.Inject

class GetMarketsTickerUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(markets: String): List<CurrencyUiItem> {
        return marketRepository.getMarketsTicker(markets)
            .map(MarketCurrencyItem::mapTo)
            .sortedByDescending { it.accTradePrice }
    }
}