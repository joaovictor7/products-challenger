package com.productschallenge.data.di

import com.productschallenge.core.domain.provider.BuildConfigProvider
import com.productschallenge.data.provider.BuildConfigProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {
    @Binds
    abstract fun buildConfigProvider(
        buildConfigProviderImpl: BuildConfigProviderImpl
    ): BuildConfigProvider
}