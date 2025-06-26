package com.productschallenge.core.designsystem.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import com.productschallenge.core.designsystem.component.dialog.SimpleDialog
import com.productschallenge.core.designsystem.param.dialog.GenericErrorParam
import com.productschallenge.core.designsystem.param.dialog.NetworkErrorParam
import com.productschallenge.core.router.destination.dialog.GenericErrorDialog
import com.productschallenge.core.router.destination.dialog.NetworkErrorDialog
import com.productschallenge.core.router.extension.navigateBack
import com.productschallenge.core.router.interfaces.NavGraph

object DesignSystemNavGraph : NavGraph {
    override fun NavGraphBuilder.register(
        navController: NavHostController
    ) {
        dialog<GenericErrorDialog> {
            SimpleDialog(GenericErrorParam) {
                navController.navigateBack()
            }
        }
        dialog<NetworkErrorDialog> {
            SimpleDialog(NetworkErrorParam) {
                navController.navigateBack()
            }
        }
    }
}