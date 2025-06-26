package com.productschallenge.feature.product.data.mapper

import com.productschallenge.feature.product.domain.model.DimensionsModel
import com.productschallenge.feature.product.network.response.DimensionResponse
import javax.inject.Inject

internal class DimensionMapper @Inject constructor() {

    fun mapperTo(dimensions: DimensionResponse) = DimensionsModel(
        width = dimensions.width,
        height = dimensions.height,
        depth = dimensions.depth
    )
}