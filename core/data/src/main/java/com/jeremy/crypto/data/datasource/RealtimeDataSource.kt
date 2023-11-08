package com.jeremy.crypto.data.datasource

import com.jeremy.crypto.model.socket.request.UpbitRequest
import com.jeremy.crypto.model.socket.response.UpbitTickerResponse
import kotlinx.coroutines.flow.Flow

interface RealtimeDataSource {
    fun requestSubscribe(requestParams: List<UpbitRequest>)
    fun collectUpbitTickers(): Flow<UpbitTickerResponse>
}