package com.productschallenge.feature.product.presenter.mapper

import com.productschallenge.feature.product.domain.model.ProductModel
import com.productschallenge.feature.product.navigation.destination.ProductDetailDestination
import javax.inject.Inject

internal class ProductDestinationlMapper @Inject constructor() {

    fun mapperToDestination(model: ProductModel) = ProductDetailDestination(
        title = model.title,
        price = model.price,
        description = model.description,
        rating = model.rating,
        discountPercentage = model.discountPercentage,
        thumbnail = model.thumbnail,
        stock = model.stock,
    )
}