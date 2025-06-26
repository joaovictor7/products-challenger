package com.productschallenge.core.data.datasource

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {

    suspend fun <T> setData(key: Preferences.Key<T>, value: T)

    fun <T> getData(onGetValue: (Preferences) -> T): Flow<T>
}