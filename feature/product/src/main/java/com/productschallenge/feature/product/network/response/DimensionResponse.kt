package com.productschallenge.feature.product.network.response

import kotlinx.serialization.Serializable

@Serializable
internal data class DimensionResponse(
    val width: Double,
    val height: Double,
    val depth: Double,
)