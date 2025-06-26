package com.productschallenge.feature.product.network.response

import kotlinx.serialization.Serializable

@Serializable
internal data class MetaResponse(
    val createdAt: String,
    val updatedAt: String,
    val barcode: String,
    val qrCode: String,
)
