package com.productschallenge.presentation.ui.main

import com.productschallenge.core.router.model.NavigationModel

internal interface MainUiEvent {
    data class NavigateTo(val navigationModel: NavigationModel) : MainUiEvent
}