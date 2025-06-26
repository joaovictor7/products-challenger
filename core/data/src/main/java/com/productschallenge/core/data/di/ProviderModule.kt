package com.productschallenge.core.data.di

import com.productschallenge.common.provider.DateTimeProvider
import com.productschallenge.common.provider.DispatcherProvider
import com.productschallenge.common.provider.LocaleProvider
import com.productschallenge.common.provider.NetworkProvider
import com.productschallenge.core.data.provider.AssetsProvider
import com.productschallenge.core.data.provider.AssetsProviderImpl
import com.productschallenge.core.data.provider.DateTimeProviderImpl
import com.productschallenge.core.data.provider.DispatcherProviderImpl
import com.productschallenge.core.data.provider.EnvironmentInstanceProvider
import com.productschallenge.core.data.provider.EnvironmentInstanceProviderImpl
import com.productschallenge.core.data.provider.LocaleProviderImpl
import com.productschallenge.core.data.provider.NetworkProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {

    @Binds
    abstract fun dispatcherProvider(
        dispatcherProviderImpl: DispatcherProviderImpl
    ): DispatcherProvider

    @Binds
    abstract fun networkProvider(
        networkProviderImpl: NetworkProviderImpl
    ): NetworkProvider

    @Binds
    abstract fun localeProvider(
        localeProviderImpl: LocaleProviderImpl
    ): LocaleProvider

    @Binds
    abstract fun dateTimeProvider(
        dateTimeProviderImpl: DateTimeProviderImpl
    ): DateTimeProvider

    @Binds
    abstract fun assetsProvider(
        assetsProviderImpl: AssetsProviderImpl
    ): AssetsProvider

    @Binds
    abstract fun environmentInstanceProvider(
        environmentInstanceProviderImpl: EnvironmentInstanceProviderImpl
    ): EnvironmentInstanceProvider
}