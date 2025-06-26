package com.productschallenge.feature.product.domain.model

import java.time.LocalDateTime

internal data class MetaModel(
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val barcode: String,
    val qrCode: String
)