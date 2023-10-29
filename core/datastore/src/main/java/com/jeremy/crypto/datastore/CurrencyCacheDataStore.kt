package com.jeremy.crypto.datastore

import androidx.datastore.core.DataStore
import com.jeremy.crypto.model.CurrencyCache
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retry
import java.io.IOException
import javax.inject.Inject

class CurrencyCacheDataStore @Inject constructor(
    private val upbitCurrencyCacheDataStore: DataStore<UpbitCurrencyCodeCache>,
) {

    val upbitCache = upbitCurrencyCacheDataStore.data.map {
        CurrencyCache(
            krwMarketCodes = it.krwMarketCodeSetMap.keys.toList(),
            btcMarketCodes = it.btcMarketCodeSetMap.keys.toList()
        )
    }.retry { true }

    suspend fun setUpbitCurrencyCache(krwMarketCode: List<String>, btcMarketCode: List<String>) {
        try {
            upbitCurrencyCacheDataStore.updateData {
                it.copy {
                    krwMarketCodeSet.putAll(krwMarketCode.associateWith { true })
                    btcMarketCodeSet.putAll(btcMarketCode.associateWith { true })
                }
            }
        } catch (ioException: IOException) { }
    }
}