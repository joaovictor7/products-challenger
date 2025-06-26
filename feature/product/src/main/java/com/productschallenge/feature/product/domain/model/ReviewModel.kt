package com.productschallenge.feature.product.domain.model

import java.time.LocalDateTime

internal data class ReviewModel(
    val rating: Int,
    val comment: String,
    val date: LocalDateTime,
    val reviewerName: String,
    val reviewerEmail: String
)