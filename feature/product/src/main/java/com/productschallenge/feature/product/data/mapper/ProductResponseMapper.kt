package com.productschallenge.feature.product.data.mapper

import com.productschallenge.feature.product.domain.model.ProductModel
import com.productschallenge.feature.product.network.response.ProductResponse
import javax.inject.Inject

internal class ProductResponseMapper @Inject constructor() {

    fun mapperToModels(responses: List<ProductResponse>) =
        responses.map { mapperToModel(it) }

    fun mapperToModel(response: ProductResponse) = ProductModel(
        id = response.id,
        title = response.title,
        description = response.description,
        price = response.price,
        discountPercentage = response.discountPercentage,
        rating = response.rating,
        stock = response.stock,
        thumbnail = response.thumbnail
    )
}