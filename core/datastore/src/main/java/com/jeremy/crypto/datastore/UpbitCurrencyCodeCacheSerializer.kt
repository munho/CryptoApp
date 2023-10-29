package com.jeremy.crypto.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UpbitCurrencyCodeCacheSerializer @Inject constructor() : Serializer<UpbitCurrencyCodeCache> {
    override val defaultValue: UpbitCurrencyCodeCache = UpbitCurrencyCodeCache.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UpbitCurrencyCodeCache =
        try {
            UpbitCurrencyCodeCache.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: UpbitCurrencyCodeCache, output: OutputStream) {
        t.writeTo(output)
    }
}