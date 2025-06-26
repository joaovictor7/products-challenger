package com.productschallenge.feature.product.network.response

import kotlinx.serialization.Serializable

@Serializable
internal data class ReviewResponse(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String,
)
