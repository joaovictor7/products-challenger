package com.productschallenge.core.designsystem.composition

import androidx.compose.runtime.compositionLocalOf
import com.productschallenge.core.domain.enums.Theme

val LocalTheme = compositionLocalOf { Theme.AUTO }
