package com.productschallenge.core.domain.usecase.remoteconfig

import com.productschallenge.core.domain.repository.RemoteConfigRepository
import javax.inject.Inject

class FetchRemoteConfigUseCase @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository
) {
    operator fun invoke() = remoteConfigRepository.fetch()
}