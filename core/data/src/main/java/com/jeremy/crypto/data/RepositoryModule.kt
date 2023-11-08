package com.jeremy.crypto.data

import com.jeremy.crypto.data.repository.MarketRepositoryImpl
import com.jeremy.crypto.data.repository.RealtimeRepositoryImpl
import com.jeremy.crypto.data.repository.TickerRepositoryImpl
import com.jeremy.crypto.domain.repository.MarketRepository
import com.jeremy.crypto.domain.repository.RealtimeRepository
import com.jeremy.crypto.domain.repository.TickerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsMarketRepository (
        marketRepositoryImpl: MarketRepositoryImpl
    ): MarketRepository

    @Binds
    fun bindsTickerRepository (
        tickerRepositoryImpl: TickerRepositoryImpl
    ): TickerRepository

    @Binds
    fun bindsRealtimeRepository (
        realtimeRepositoryImpl: RealtimeRepositoryImpl
    ): RealtimeRepository
}