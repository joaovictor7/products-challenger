package com.productschallenge.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.productschallenge.core.designsystem.component.dialog.SimpleDialog
import com.productschallenge.core.designsystem.theme.ProductsChallengeTheme
import com.productschallenge.core.router.extension.navigateTo
import com.productschallenge.core.ui.interfaces.Intent
import com.productschallenge.core.ui.util.UiEventsObserver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
internal fun MainScreen(
    uiState: MainUiState,
    uiEvent: Flow<MainUiEvent> = emptyFlow(),
    onExecuteIntent: (Intent<MainIntentReceiver>) -> Unit = {}
) {
    ProductsChallengeTheme(
        dynamicColor = uiState.appTheme.dynamicColor,
        theme = uiState.appTheme.theme
    ) {
        DialogHandler(uiState = uiState, onExecuteIntent = onExecuteIntent)
        Navigation(uiState = uiState, uiEvent = uiEvent)
    }
}

@Composable
private fun Navigation(
    uiState: MainUiState,
    uiEvent: Flow<MainUiEvent>,
) {
    if (uiState.firstDestination == null) return
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = uiState.firstDestination) {
        uiState.navGraphs.forEach { it.run { register(navController) } }
    }
    UiEventsHandler(uiEvent = uiEvent, navController = navController)
}

@Composable
private fun DialogHandler(
    uiState: MainUiState,
    onExecuteIntent: (Intent<MainIntentReceiver>) -> Unit
) = uiState.simpleDialogParam?.let {
    SimpleDialog(param = it) {
        onExecuteIntent(MainIntent.DismissAlertDialog)
    }
}

@Composable
private fun UiEventsHandler(
    uiEvent: Flow<MainUiEvent>,
    navController: NavHostController,
) {
    UiEventsObserver(uiEvent) {
        when (it) {
            is MainUiEvent.NavigateTo -> navController.navigateTo(it.navigationModel)
        }
    }
}

@Composable
@Preview
private fun Preview() {
    ProductsChallengeTheme {
        MainScreen(uiState = MainUiState())
    }
}