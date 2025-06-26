package com.productschallenge.core.designsystem.component.dock

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.productschallenge.core.designsystem.composition.LocalRootDockProvider
import com.productschallenge.core.designsystem.extension.toDp

@Composable
fun DockExtraPadding() {
    Spacer(Modifier.height(LocalRootDockProvider.current.toDp))
}