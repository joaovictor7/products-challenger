package com.productschallenge.core.ui.di

import com.productschallenge.core.ui.provider.LocationProvider
import com.productschallenge.core.ui.provider.LocationProviderImpl
import com.productschallenge.core.ui.provider.PermissionProvider
import com.productschallenge.core.ui.provider.PermissionProviderImpl
import com.productschallenge.core.ui.provider.StringResourceProvider
import com.productschallenge.core.ui.provider.StringResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {

    @Binds
    abstract fun permissionProvider(
        permissionProviderImpl: PermissionProviderImpl
    ): PermissionProvider

    @Binds
    abstract fun stringResourceProvider(
        stringResourceProviderImpl: StringResourceProviderImpl
    ): StringResourceProvider

    @Binds
    abstract fun locationProvider(
        locationProviderImpl: LocationProviderImpl
    ): LocationProvider
}