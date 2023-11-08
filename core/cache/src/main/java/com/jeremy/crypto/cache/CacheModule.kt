package com.jeremy.crypto.cache

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object CacheModule {
    @Provides
    @Singleton
    fun provideTickerCache(): TickerCache {
        return TickerCache()
    }
}