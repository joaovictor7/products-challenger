package com.productschallenge.core.database.di

import com.productschallenge.core.database.data.dao.ProductEntityDao
import com.productschallenge.core.database.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun productEntityDao(
        database: Database
    ): ProductEntityDao = database.productEntityDao()
}