package com.jeremy.crypto.data

import com.jeremy.crypto.data.repository.MarketRepositoryImpl
import com.jeremy.crypto.domain.repository.MarketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsMarketRepository (
        marketRepository: MarketRepositoryImpl
    ): MarketRepository

}