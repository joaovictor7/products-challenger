package com.productschallenge.feature.product.data.datasource

import com.productschallenge.core.network.di.qualifier.ApiQualifier
import com.productschallenge.core.network.extension.get
import com.productschallenge.core.network.util.ApiCallUtils
import com.productschallenge.feature.product.network.api.Api
import com.productschallenge.feature.product.network.response.ProductsResponse
import io.ktor.client.HttpClient
import javax.inject.Inject

internal class ProductRemoteDataSource @Inject constructor(
    private val apiCallUtils: ApiCallUtils,
    @param:ApiQualifier(Api.DUMMY_JSON_PRODUCTS) private val httpClient: HttpClient,
) {

    suspend fun getAllProducts() = apiCallUtils.executeApiCall {
        httpClient.get<ProductsResponse>("/products")
    }
}