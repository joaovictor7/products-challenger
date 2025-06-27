package com.productschallenge.feature.product.data.datasource

import com.productschallenge.core.network.extension.get
import com.productschallenge.core.network.util.ApiCallUtils
import com.productschallenge.feature.product.network.response.ProductsResponse
import io.ktor.client.HttpClient

internal class ProductRemoteApiDataSource(
    private val apiCallUtils: ApiCallUtils,
    private val httpClient: HttpClient,
) : ProductRemoteDataSource {

    override suspend fun getAllProducts() = apiCallUtils.executeApiCall {
        httpClient.get<ProductsResponse>(PRODUCTS_PATH)
    }

    private companion object Companion {
        const val PRODUCTS_PATH = "/products"
    }
}