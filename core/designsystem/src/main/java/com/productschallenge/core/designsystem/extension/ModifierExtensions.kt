package com.productschallenge.core.designsystem.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import com.productschallenge.core.designsystem.composition.LocalTheme
import com.productschallenge.core.designsystem.dimension.screenMargin

@Composable
fun Modifier.visibility(isVisible: Boolean) = alpha(if (isVisible) 1f else 0f)

@Composable
fun Modifier.verticalTopBackgroundBrush() = also {
    if (!LocalTheme.current.isDarkMode) {
        val colorStops = arrayOf(
            0.1f to MaterialTheme.colorScheme.primary,
            0.99f to MaterialTheme.colorScheme.surface,
        )
        return background(brush = Brush.verticalGradient(colorStops = colorStops))
    }
}

@Composable
fun Modifier.clickableWithoutRipple(onClick: () -> Unit) = clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = null,
    onClick = onClick
)

@Composable
fun Modifier.horizontalScreenMargin() = padding(horizontal = screenMargin)

@Composable
fun Modifier.topScreenMargin() = padding(top = screenMargin)

@Composable
fun Modifier.screenMarginWithoutBar() = windowInsetsPadding(WindowInsets.systemBars)
    .topScreenMargin()
    .horizontalScreenMargin()

@Composable
fun Modifier.screenMargin() = topScreenMargin().horizontalScreenMargin()