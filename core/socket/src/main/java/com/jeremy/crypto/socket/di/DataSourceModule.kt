package com.jeremy.crypto.socket.di

import com.jeremy.crypto.data.datasource.RealtimeDataSource
import com.jeremy.crypto.socket.RealtimeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsRealtimeDataSource(
        realtimeDataSourceImpl: RealtimeDataSourceImpl
    ): RealtimeDataSource

}