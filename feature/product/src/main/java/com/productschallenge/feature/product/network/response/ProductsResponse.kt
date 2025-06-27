package com.productschallenge.feature.product.network.response

import kotlinx.serialization.Serializable

@Serializable
internal data class ProductsResponse(
    val products: List<ProductResponse>,
)