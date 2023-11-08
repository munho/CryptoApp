package com.jeremy.crypto.socket

import com.jeremy.crypto.data.datasource.RealtimeDataSource
import com.jeremy.crypto.model.socket.request.UpbitRequest
import com.jeremy.crypto.model.socket.response.UpbitTickerResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RealtimeDataSourceImpl @Inject constructor(
    private val socketService: UpbitSocketService
): RealtimeDataSource {
    override fun requestSubscribe(requestParams: List<UpbitRequest>) {
        socketService.requestUpbitRequest(requestParams)
    }

    override fun collectUpbitTickers(): Flow<UpbitTickerResponse> {
        return socketService.collectUpbitTickers()
    }
}