package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.MarketRepository
import javax.inject.Inject

class SetMarketCodeCacheUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {
    suspend fun execute(krwCodes: List<String>, btcCodes: List<String>) {
        marketRepository.setMarketCode(krwCodes, btcCodes)
    }
}