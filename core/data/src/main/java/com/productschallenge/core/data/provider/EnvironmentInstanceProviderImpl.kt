package com.productschallenge.core.data.provider

import com.productschallenge.core.domain.enums.Flavor
import com.productschallenge.core.domain.provider.BuildConfigProvider
import javax.inject.Inject

internal class EnvironmentInstanceProviderImpl @Inject constructor(
    private val buildConfigProvider: BuildConfigProvider
) : EnvironmentInstanceProvider {

    override fun <Instance> getInstance(instance: Instance, fakeInstance: Instance) =
        if (buildConfigProvider.buildConfig.flavor == Flavor.DEVELOP) fakeInstance else instance
}