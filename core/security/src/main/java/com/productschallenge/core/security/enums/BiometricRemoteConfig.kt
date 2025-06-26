package com.productschallenge.core.security.enums

import com.productschallenge.common.remoteconfig.RemoteConfig

internal enum class BiometricRemoteConfig(override val key: String) : RemoteConfig {
    USE_BIOMETRIC("use_biometric"),
}