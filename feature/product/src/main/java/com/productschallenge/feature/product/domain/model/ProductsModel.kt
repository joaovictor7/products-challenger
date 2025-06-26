package com.productschallenge.feature.product.domain.model

internal data class ProductsModel(
    val products: List<ProductModel>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)