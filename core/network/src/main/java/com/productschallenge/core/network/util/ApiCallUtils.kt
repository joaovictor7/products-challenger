package com.productschallenge.core.network.util

import com.productschallenge.common.provider.DispatcherProvider
import com.productschallenge.core.domain.enums.Flavor
import com.productschallenge.core.domain.provider.BuildConfigProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class ApiCallUtils @Inject constructor(
    private val buildConfigProvider: BuildConfigProvider,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend fun <T> executeApiCall(onRemoteCall: suspend () -> T) =
        withContext(dispatcherProvider.io) {
            if (buildConfigProvider.buildConfig.environmentFlavor == Flavor.DEVELOP) {
                delay(fakeCallDelay)
            }
            onRemoteCall()
        }

    private companion object {
        val fakeCallDelay = 1.seconds
    }
}