package com.productschallenge.feature.product.presenter.ui.list

import com.productschallenge.core.router.model.NavigationModel

internal sealed interface ProductListUiEvent {
    data class NavigateTo(val navigationModel: NavigationModel) : ProductListUiEvent
}
