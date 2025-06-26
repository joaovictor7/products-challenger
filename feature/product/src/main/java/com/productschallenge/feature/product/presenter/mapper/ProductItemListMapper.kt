package com.productschallenge.feature.product.presenter.mapper

import com.productschallenge.feature.product.domain.model.ProductModel
import com.productschallenge.feature.product.presenter.enums.RatingStatus
import com.productschallenge.feature.product.presenter.model.ProductItemListModel
import javax.inject.Inject

internal class ProductItemListMapper @Inject constructor() {

    fun mapperTo(products: List<ProductModel>) = products.map {
        ProductItemListModel(
            id = it.id,
            title = it.title,
            rating = it.rating.toString(),
            ratingStatus = getStatus(it.rating)
        )
    }

    private fun getStatus(rating: Double) = if (rating < 3) {
        RatingStatus.DISLIKE
    } else if (rating > 4) {
        RatingStatus.LIKE
    } else {
        RatingStatus.NEUTRAL
    }
}