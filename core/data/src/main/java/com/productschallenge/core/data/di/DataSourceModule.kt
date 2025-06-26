package com.productschallenge.core.data.di

import com.productschallenge.core.data.datasource.PreferenceDataSource
import com.productschallenge.core.data.datasource.local.PreferenceDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    fun preferencesDataSource(
        preferenceDataSourceImpl: PreferenceDataSourceImpl
    ): PreferenceDataSource = preferenceDataSourceImpl
}