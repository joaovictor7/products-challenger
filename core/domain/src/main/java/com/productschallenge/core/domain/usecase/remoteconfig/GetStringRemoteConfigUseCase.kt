package com.productschallenge.core.domain.usecase.remoteconfig

import com.productschallenge.common.remoteconfig.RemoteConfig
import com.productschallenge.core.domain.repository.RemoteConfigRepository
import javax.inject.Inject

class GetStringRemoteConfigUseCase @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository,
) {
    operator fun invoke(remoteConfig: RemoteConfig) =
        remoteConfigRepository.getString(remoteConfig)
}