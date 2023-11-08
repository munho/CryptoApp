package com.jeremy.crypto.domain.usecase

import com.jeremy.crypto.domain.repository.RealtimeRepository
import javax.inject.Inject

class RequestRealtimeTickerSubscribeUseCase @Inject constructor(
    private val realtimeRepository: RealtimeRepository
) {
    operator fun invoke() {
        realtimeRepository.requestTickers()
    }
}