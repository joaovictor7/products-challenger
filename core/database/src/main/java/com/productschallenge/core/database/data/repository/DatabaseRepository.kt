package com.productschallenge.core.database.data.repository

import com.productschallenge.core.data.datasource.PreferenceDataSource
import com.productschallenge.core.data.datastore.PreferencesDataKeys
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

internal class DatabaseRepository @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource
) {

    suspend fun getSqliteSecretKey() = preferenceDataSource.getData { preferences ->
        preferences[PreferencesDataKeys.Database.sqliteSecretKey]
    }.firstOrNull()

    suspend fun setSqliteSecretKey(secretKey: String) =
        preferenceDataSource.setData(PreferencesDataKeys.Database.sqliteSecretKey, secretKey)
}