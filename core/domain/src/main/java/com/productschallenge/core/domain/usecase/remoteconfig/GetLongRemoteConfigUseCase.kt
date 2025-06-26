package com.productschallenge.core.domain.usecase.remoteconfig

import com.productschallenge.common.remoteconfig.RemoteConfig
import com.productschallenge.core.domain.repository.RemoteConfigRepository
import javax.inject.Inject

class GetLongRemoteConfigUseCase @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository,
) {
    operator fun invoke(remoteConfig: RemoteConfig) =
        remoteConfigRepository.getLong(remoteConfig)
}