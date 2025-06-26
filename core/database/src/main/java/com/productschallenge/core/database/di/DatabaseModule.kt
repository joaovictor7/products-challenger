package com.productschallenge.core.database.di

import android.content.Context
import androidx.room.Room
import com.productschallenge.core.database.data.converter.LocalDateTimeConverter
import com.productschallenge.core.database.data.extension.addLogs
import com.productschallenge.core.database.database.Database
import com.productschallenge.core.database.domain.usecase.GetDatabaseKeyUseCase
import com.productschallenge.core.domain.provider.BuildConfigProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    private const val DATABASE_NAME = "composetest_database"

    @Provides
    @Singleton
    fun appDatabase(
        @ApplicationContext context: Context,
        buildConfigProvider: BuildConfigProvider,
        getDatabaseKeyUseCase: GetDatabaseKeyUseCase,
    ): Database = Room.databaseBuilder(
        context,
        Database::class.java,
        DATABASE_NAME
    )
        .openHelperFactory(getHelperFactory(getDatabaseKeyUseCase))
        .addTypeConverter(LocalDateTimeConverter())
        .addLogs(buildConfigProvider.buildConfig)
        .build()

    private fun getHelperFactory(getDatabaseKeyUseCase: GetDatabaseKeyUseCase) = runBlocking {
        SupportOpenHelperFactory(getDatabaseKeyUseCase())
    }
}