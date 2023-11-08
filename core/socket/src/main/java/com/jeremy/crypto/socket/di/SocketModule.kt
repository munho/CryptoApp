package com.jeremy.crypto.socket.di

import android.content.Context
import com.jeremy.crypto.socket.UpbitSocketService
import com.jeremy.thunder.event.converter.ConverterType
import com.jeremy.thunder.makeWebSocketCore
import com.jeremy.thunder.thunder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object SocketModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SocketType

    @Singleton
    @Provides
    @SocketType
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .pingInterval(
                10,
                TimeUnit.SECONDS
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideUpbitSocketService(
        @SocketType okHttpClient: OkHttpClient,
        @ApplicationContext context: Context
    ): UpbitSocketService {
        return thunder {
            webSocketCore(okHttpClient.makeWebSocketCore("wss://api.upbit.com/websocket/v1")) // upbit socket server
            setApplicationContext(context)
            setConverterType(ConverterType.Serialization)
        }.create()
    }
}