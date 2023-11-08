package com.jeremy.crypto.data.repository

import com.jeremy.crypto.cache.TickerCache
import com.jeremy.crypto.data.datasource.RealtimeDataSource
import com.jeremy.crypto.datastore.CurrencyCacheDataStore
import com.jeremy.crypto.domain.repository.RealtimeRepository
import com.jeremy.crypto.model.socket.request.RequestFormatField
import com.jeremy.crypto.model.socket.request.RequestTicketField
import com.jeremy.crypto.model.socket.request.RequestTypeField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class RealtimeRepositoryImpl @Inject constructor(
    private val realtimeDataSource: RealtimeDataSource,
    private val cacheDataStore: CurrencyCacheDataStore,
    private val tickerCache: TickerCache,
) : RealtimeRepository {

    private val internalScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    init {
        realtimeDataSource.collectUpbitTickers().onEach {
            tickerCache.set(it.code, it.mapTo())
        }.launchIn(internalScope)
    }

    override fun requestTickers() {
        internalScope.launch {
            cacheDataStore.upbitCache.map { it.krwMarketCodes }.firstOrNull()?.let { codes ->
                val request = listOf(
                    RequestTicketField(ticket = UUID.randomUUID().toString()),
                    RequestTypeField(
                        type = "ticker",
                        codes = codes
                    ),
                    RequestFormatField()
                )
                realtimeDataSource.requestSubscribe(request)
            }
        }
    }

}