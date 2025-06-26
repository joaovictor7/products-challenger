package com.productschallenge.core.domain.model

import com.productschallenge.core.domain.enums.Theme

data class AppThemeModel(
    val theme: Theme = Theme.AUTO,
    val dynamicColor: Boolean = false
)