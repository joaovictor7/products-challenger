package com.productschallenge.feature.form.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.productschallenge.core.router.interfaces.NavGraph
import com.productschallenge.feature.form.navigation.destination.FormDestination
import com.productschallenge.feature.form.presenter.ui.form.FormScreen
import com.productschallenge.feature.form.presenter.ui.form.FormViewModel

object FormNavGraph : NavGraph {
    override fun NavGraphBuilder.register(
        navController: NavHostController
    ) {
        composable<FormDestination> {
            val viewModel = hiltViewModel<FormViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            FormScreen(
                uiState = uiState,
                onExecuteIntent = viewModel::executeIntent,
            )
        }
    }
}