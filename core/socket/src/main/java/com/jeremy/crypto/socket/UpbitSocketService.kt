package com.jeremy.crypto.socket

import com.jeremy.crypto.model.socket.request.UpbitRequest
import com.jeremy.crypto.model.socket.response.UpbitTickerResponse
import com.jeremy.thunder.ws.Receive
import com.jeremy.thunder.ws.Send
import kotlinx.coroutines.flow.Flow

interface UpbitSocketService {
    @Send
    fun requestUpbitRequest(request: List<UpbitRequest>)
    @Receive
    fun collectUpbitTickers(): Flow<UpbitTickerResponse>
}