package com.productschallenge.feature.product.presenter.ui.detail

import com.productschallenge.feature.product.presenter.model.ProductDetailRow

internal data class ProductDetailUiState(
    val imageUrl: String? = null,
    val title: String = String(),
    val description: String = String(),
    val infoRows: List<ProductDetailRow> = emptyList(),
) {
    fun setProductDetails(
        imageUrl: String,
        title: String,
        description: String,
        infoRows: List<ProductDetailRow>,
    ) = copy(
        imageUrl = imageUrl,
        title = title,
        description = description,
        infoRows = infoRows,
    )
}
