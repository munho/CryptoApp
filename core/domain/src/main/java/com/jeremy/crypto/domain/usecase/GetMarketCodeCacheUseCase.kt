package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.model.CurrencyCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMarketCodeCacheUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {

    operator fun invoke(): Flow<CurrencyCache> {
        return marketRepository.marketCache
    }
}