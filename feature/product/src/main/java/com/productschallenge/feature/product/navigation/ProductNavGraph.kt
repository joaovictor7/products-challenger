package com.productschallenge.feature.product.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.productschallenge.core.router.destination.product.ProductListDestination
import com.productschallenge.core.router.interfaces.NavGraph
import com.productschallenge.feature.product.presenter.ui.list.ProductListScreen
import com.productschallenge.feature.product.presenter.ui.list.ProductListViewModel

object ProductNavGraph : NavGraph {
    override fun NavGraphBuilder.register(
        navController: NavHostController
    ) {
        composable<ProductListDestination> {
            val viewModel: ProductListViewModel = hiltViewModel<ProductListViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ProductListScreen(
                uiState = uiState,
                uiEvent = viewModel.uiEvent,
                onExecuteIntent = viewModel::executeIntent,
                navController = navController
            )
        }
    }
}