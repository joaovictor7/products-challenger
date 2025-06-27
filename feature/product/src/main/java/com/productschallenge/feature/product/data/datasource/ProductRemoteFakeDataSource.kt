package com.productschallenge.feature.product.data.datasource

import com.productschallenge.core.data.extension.readJsonAs
import com.productschallenge.core.data.provider.AssetsProvider
import com.productschallenge.core.network.util.ApiCallUtils
import com.productschallenge.feature.product.network.response.ProductsResponse

internal class ProductRemoteFakeDataSource(
    private val apiCallUtils: ApiCallUtils,
    private val assetsProvider: AssetsProvider,
) : ProductRemoteDataSource {

    override suspend fun getAllProducts() = apiCallUtils.executeApiCall {
        assetsProvider.readJsonAs<ProductsResponse>(PRODUCTS_JSON_FILE_NAME)
    }

    private companion object Companion {
        const val PRODUCTS_JSON_FILE_NAME = "all-products"
    }
}