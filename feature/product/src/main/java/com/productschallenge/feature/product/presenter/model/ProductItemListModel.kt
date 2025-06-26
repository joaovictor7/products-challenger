package com.productschallenge.feature.product.presenter.model

import com.productschallenge.feature.product.presenter.enums.RatingStatus

internal data class ProductItemListModel(
    val id: Int,
    val title: String,
    val rating: String,
    val ratingStatus: RatingStatus,
)