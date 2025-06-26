package com.productschallenge.core.data.repository

import com.productschallenge.common.remoteconfig.RemoteConfig
import com.productschallenge.core.data.datasource.remote.RemoteConfigDataSource
import com.productschallenge.core.domain.repository.RemoteConfigRepository
import javax.inject.Inject

internal class RemoteConfigRepositoryImpl @Inject constructor(
    private val remoteConfigDataSource: RemoteConfigDataSource
) : RemoteConfigRepository {

    override fun getString(remoteConfig: RemoteConfig) =
        remoteConfigDataSource.getString(remoteConfig.key)

    override fun getLong(remoteConfig: RemoteConfig) =
        remoteConfigDataSource.getLong(remoteConfig.key)

    override fun getDouble(remoteConfig: RemoteConfig) =
        remoteConfigDataSource.getDouble(remoteConfig.key)

    override fun fetch() {
        remoteConfigDataSource.fetch()
    }
}