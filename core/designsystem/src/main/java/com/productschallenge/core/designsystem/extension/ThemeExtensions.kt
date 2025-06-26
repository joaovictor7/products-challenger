package com.productschallenge.core.designsystem.extension

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.productschallenge.core.domain.enums.Theme

val Theme.isDarkMode
    @Composable get() = when (this) {
        Theme.AUTO -> isSystemInDarkTheme()
        else -> this == Theme.DARK
    }