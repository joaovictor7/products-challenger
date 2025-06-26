package com.productschallenge.feature.product.data.mapper

import com.productschallenge.feature.product.domain.model.ProductsModel
import com.productschallenge.feature.product.network.response.ProductsResponse
import javax.inject.Inject

internal class ProductsMapper @Inject constructor(
    private val productMapper: ProductMapper,
) {

    fun mapperTo(response: ProductsResponse) = ProductsModel(
        products = productMapper.mapperTo(response.products),
        total = response.total,
        skip = response.skip,
        limit = response.limit
    )
}