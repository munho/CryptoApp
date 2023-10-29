package com.jeremy.crypto.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.GlobalScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providesUpbitCurrencyCodeCacheDataStore(
        @ApplicationContext context: Context,
        upbitCurrencyCodeCacheSerializer: UpbitCurrencyCodeCacheSerializer,
    ): DataStore<UpbitCurrencyCodeCache> =
        DataStoreFactory.create(
            serializer = upbitCurrencyCodeCacheSerializer,
            scope = GlobalScope,
        ) {
            context.dataStoreFile("upbit_currency_code_cache.pb")
        }
}