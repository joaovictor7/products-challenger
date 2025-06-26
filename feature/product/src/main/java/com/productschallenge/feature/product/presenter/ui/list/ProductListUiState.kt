package com.productschallenge.feature.product.presenter.ui.list

import com.productschallenge.core.designsystem.param.alertdialog.SimpleDialogParam
import com.productschallenge.feature.product.presenter.model.ProductItemListModel

internal data class ProductListUiState(
    val filter: String = String(),
    val productScreenList: List<ProductItemListModel> = emptyList(),
    val simpleDialogParam: SimpleDialogParam? = null,
    val isLoading: Boolean = false
) {
    fun setIsLoading(isLoading: Boolean) = copy(isLoading = isLoading)

    fun setProductScreenList(
        exchangeScreenList: List<ProductItemListModel>,
        filter: String = String(),
    ) = copy(
        productScreenList = exchangeScreenList,
        filter = filter,
    )

    fun setProductListFiltered(
        exchangeFilter: String,
        exchangeScreenList: List<ProductItemListModel>
    ) = copy(filter = exchangeFilter, productScreenList = exchangeScreenList)

    fun setSimpleDialogParam(simpleDialogParam: SimpleDialogParam?) =
        copy(simpleDialogParam = simpleDialogParam)
}
