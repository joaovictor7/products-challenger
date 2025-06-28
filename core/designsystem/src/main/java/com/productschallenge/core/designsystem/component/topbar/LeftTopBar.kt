@file:OptIn(ExperimentalMaterial3Api::class)

package com.productschallenge.core.designsystem.component.topbar

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import com.productschallenge.core.designsystem.R
import com.productschallenge.core.designsystem.enums.topbar.TopBarAction
import com.productschallenge.core.designsystem.theme.ProductsChallengeTheme
import com.productschallenge.core.designsystem.util.getTopBarActions
import com.productschallenge.core.designsystem.util.getTopBarTitle

@Composable
fun LeftTopBar(
    @StringRes titleId: Int,
    showBackButton: Boolean = true,
    navigationAction: TopBarAction? = null,
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onClickNavigationAction: (() -> Unit)? = null,
    actionIcons: List<TopBarAction>? = null,
    onClickAction: ((TopBarAction) -> Unit)? = null
) {
    TopAppBar(
        navigationIcon = {
            TopBarNavigationIcon(
                showBackButton = showBackButton,
                navigationAction = navigationAction,
                onClickNavigationAction = onClickNavigationAction
            )
        },
        actions = getTopBarActions(actionIcons, onClickAction),
        title = getTopBarTitle(stringResource(titleId)),
        expandedHeight = expandedHeight,
        scrollBehavior = scrollBehavior,
    )
}

@Composable
@PreviewLightDark
private fun Preview() {
    ProductsChallengeTheme {
        LeftTopBar(titleId = R.string.toolbar_back_button_content_description)
    }
}