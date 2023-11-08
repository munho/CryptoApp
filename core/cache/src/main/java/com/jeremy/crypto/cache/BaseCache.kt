package com.jeremy.crypto.cache

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import java.util.concurrent.ConcurrentHashMap

interface BaseCache<T> {
    val streamFlow: MutableSharedFlow<ConcurrentHashMap<String, T>>

    val cache: ConcurrentHashMap<String, T>

    fun flush() {
        streamFlow.tryEmit(cache)
    }

    fun set(key: String, data: T) {
        cache[key] = data
        flush()
    }

    fun clear() {
        cache.clear()
        streamFlow.tryEmit(cache)
    }

    fun getListFlow(): Flow<List<T>> = streamFlow.conflate().map {
        it.values.toList()
    }.flowOn(Dispatchers.IO)

    fun getFlow(key: String): Flow<T> = streamFlow.conflate().mapNotNull {
        it[key]
    }.flowOn(Dispatchers.IO)
}