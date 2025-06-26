package com.productschallenge.core.router.extension

import com.productschallenge.core.network.model.ApiError
import com.productschallenge.core.router.destination.dialog.GenericErrorDialog
import com.productschallenge.core.router.destination.dialog.NetworkErrorDialog
import com.productschallenge.core.router.model.NavigationModel

fun Throwable.dialogErrorDestination(): NavigationModel {
    val destination = when (this) {
        is ApiError.Network -> NetworkErrorDialog
        else -> GenericErrorDialog
    }
    return NavigationModel(destination)
}