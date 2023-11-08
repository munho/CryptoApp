package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.TickerRepository
import com.jeremy.crypto.model.CurrencyUiItem
import com.jeremy.crypto.model.MarketCurrencyItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRealtimeMarketTickersUseCase @Inject constructor(
    private val tickerRepository: TickerRepository
) {
    operator fun invoke(): Flow<List<CurrencyUiItem>> {
        return tickerRepository.getMarketTickers()
            .map {
                it.map(MarketCurrencyItem::mapTo).sortedByDescending { it.accTradePrice }
            }

    }
}