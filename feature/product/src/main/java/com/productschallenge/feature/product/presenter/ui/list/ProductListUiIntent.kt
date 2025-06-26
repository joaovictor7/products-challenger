package com.productschallenge.feature.product.presenter.ui.list

import com.productschallenge.core.router.model.NavigationModel

internal sealed interface ProductListUiIntent {
    data class NavigateTo(val navigationModel: NavigationModel) : ProductListUiIntent
}
