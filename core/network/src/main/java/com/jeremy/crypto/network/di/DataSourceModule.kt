package com.jeremy.crypto.network.di

import com.jeremy.crypto.data.datasource.MarketDataSource
import com.jeremy.crypto.network.remote.MarketDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsMarketDataSource(
        marketDataSourceImpl: MarketDataSourceImpl
    ): MarketDataSource

}