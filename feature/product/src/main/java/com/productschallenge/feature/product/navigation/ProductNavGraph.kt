package com.productschallenge.feature.product.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.productschallenge.core.router.destination.product.ProductListDestination
import com.productschallenge.core.router.interfaces.NavGraph
import com.productschallenge.feature.product.presenter.ui.product.ProductScreen
import com.productschallenge.feature.product.presenter.ui.product.ProductViewModel

object ProductNavGraph : NavGraph {
    override fun NavGraphBuilder.register(
        navController: NavHostController
    ) {
        composable<ProductListDestination> {
            hiltViewModel<ProductViewModel>()
            ProductScreen()
        }
    }
}