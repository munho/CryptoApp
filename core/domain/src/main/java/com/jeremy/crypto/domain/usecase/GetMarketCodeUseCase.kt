package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.model.MarketCodeResponseItem
import javax.inject.Inject

class GetMarketCodeUseCase @Inject constructor(
    private val marketRepository: MarketRepository
){
    suspend fun execute(): Result<List<MarketCodeResponseItem>> {
        return kotlin.runCatching { marketRepository.getMarketCode() }
    }
}