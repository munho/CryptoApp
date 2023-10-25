package com.jeremy.crypto.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideCryptoNavigator(
        cryptoNavigator: CryptoNavigator,
    ): AppComposeNavigator
}
