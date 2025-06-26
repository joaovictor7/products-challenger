package com.productschallenge.data.di

import com.productschallenge.common.provider.ApplicationModule
import com.productschallenge.core.database.application.DatabaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object ApplicationModule {

    @Provides
    fun applicationModules(): Array<ApplicationModule> = arrayOf(
        DatabaseApplication
    )
}