package com.productschallenge.presentation.ui.main

import android.os.Build
import com.productschallenge.core.domain.model.AppThemeModel
import com.productschallenge.core.designsystem.param.alertdialog.SimpleDialogParam
import com.productschallenge.core.router.interfaces.Destination
import com.productschallenge.core.router.interfaces.NavGraph

internal data class MainUiState(
    val firstDestination: Destination? = null,
    val navGraphs: List<NavGraph> = emptyList(),
    val appTheme: AppThemeModel = AppThemeModel(),
    val showSplashScreen: Boolean = true,
    val simpleDialogParam: SimpleDialogParam? = null,
) {
    val forceNavigationBarTransparency get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q

    fun setInitUiState(firstDestination: Destination, navGraphs: Array<NavGraph>) =
        copy(
            showSplashScreen = false,
            firstDestination = firstDestination,
            navGraphs = navGraphs.toList()
        )

    fun setAppTheme(appTheme: AppThemeModel?) = copy(appTheme = appTheme ?: this.appTheme)
    fun setSimpleDialog(param: SimpleDialogParam?) = copy(simpleDialogParam = param)
}
