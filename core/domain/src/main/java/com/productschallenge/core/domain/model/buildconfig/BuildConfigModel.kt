package com.productschallenge.core.domain.model.buildconfig

import com.productschallenge.core.domain.enums.BuildType
import com.productschallenge.core.domain.enums.Flavor

data class BuildConfigModel(
    val applicationId: String,
    val versionName: String,
    val versionCode: Int,
    val buildType: BuildType,
    val distributionFlavor: Flavor,
    val environmentFlavor: Flavor,
    val androidSdkVersion: Int,
) {
    val isRelease get() = buildType == BuildType.RELEASE
    val isProduction get() = distributionFlavor == Flavor.PRODUCTION
    val fullyVersion get() = versionName + versionCode
}