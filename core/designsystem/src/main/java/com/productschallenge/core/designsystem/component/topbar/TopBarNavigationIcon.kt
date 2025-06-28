package com.productschallenge.core.designsystem.component.topbar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.productschallenge.core.designsystem.component.button.BackButton
import com.productschallenge.core.designsystem.enums.topbar.TopBarAction
import com.productschallenge.core.designsystem.theme.ProductsChallengeTheme

@Composable
internal fun TopBarNavigationIcon(
    showBackButton: Boolean,
    navigationAction: TopBarAction? = null,
    onClickNavigationAction: (() -> Unit)? = null,
) {
    when {
        navigationAction != null -> {
            IconButton(onClick = { onClickNavigationAction?.invoke() }) {
                Icon(
                    painter = painterResource(navigationAction.iconId),
                    contentDescription = null
                )
            }
        }
        showBackButton -> {
            BackButton()
        }
    }
}

@Composable
@Preview
private fun Preview() {
    ProductsChallengeTheme {
        TopBarNavigationIcon(showBackButton = false, navigationAction = TopBarAction.MENU)
    }
}