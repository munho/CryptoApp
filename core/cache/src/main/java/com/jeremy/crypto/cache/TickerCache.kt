package com.jeremy.crypto.cache

import com.jeremy.crypto.model.MarketCurrencyItem
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.concurrent.ConcurrentHashMap

class TickerCache : BaseCache<MarketCurrencyItem> {
    override val streamFlow: MutableSharedFlow<ConcurrentHashMap<String, MarketCurrencyItem>>
        = MutableSharedFlow(
            replay = 1,
            extraBufferCapacity = 120,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )
    override val cache: ConcurrentHashMap<String, MarketCurrencyItem>
        = ConcurrentHashMap()
}