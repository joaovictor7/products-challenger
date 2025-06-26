package com.productschallenge.core.domain.repository

import com.productschallenge.common.remoteconfig.RemoteConfig

interface RemoteConfigRepository {
    fun getString(remoteConfig: RemoteConfig): String
    fun getLong(remoteConfig: RemoteConfig): Long
    fun getDouble(remoteConfig: RemoteConfig): Double
    fun fetch()
}