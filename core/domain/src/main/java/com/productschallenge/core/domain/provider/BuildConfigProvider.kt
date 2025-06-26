package com.productschallenge.core.domain.provider

import com.productschallenge.core.domain.model.buildconfig.BuildConfigFieldsModel
import com.productschallenge.core.domain.model.buildconfig.BuildConfigModel

interface BuildConfigProvider {
    val buildConfig: BuildConfigModel
    val buildConfigFields: BuildConfigFieldsModel
}