package com.productschallenge.feature.product.data.datasource

import com.productschallenge.feature.product.network.response.ProductsResponse

internal interface ProductRemoteDataSource {

    suspend fun getAllProducts(): ProductsResponse
}