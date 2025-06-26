package com.productschallenge.core.database.di

import com.productschallenge.core.database.data.dao.ConfigurationEntityDao
import com.productschallenge.core.database.data.dao.SessionEntityDao
import com.productschallenge.core.database.data.dao.UserEntityDao
import com.productschallenge.core.database.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun sessionEntityDao(database: Database): SessionEntityDao =
        database.sessionEntityDao()

    @Provides
    fun userEntityDao(database: Database): UserEntityDao = database.userEntityDao()

    @Provides
    fun configurationEntityDao(
        database: Database
    ): ConfigurationEntityDao = database.configurationEntityDao()
}