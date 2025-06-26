package com.productschallenge.core.domain.model

import com.productschallenge.core.domain.enums.Theme

data class ThemeConfigurationModel(
    var theme: Theme,
    var dynamicColor: Boolean,
)
