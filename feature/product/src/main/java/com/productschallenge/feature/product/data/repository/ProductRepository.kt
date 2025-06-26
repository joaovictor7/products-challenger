package com.productschallenge.feature.product.data.repository

import com.productschallenge.feature.product.data.datasource.ProductLocalDataSource
import com.productschallenge.feature.product.data.datasource.ProductRemoteDataSource
import com.productschallenge.feature.product.data.mapper.ProductsMapper
import com.productschallenge.feature.product.domain.model.ProductsModel
import javax.inject.Inject

internal class ProductRepository @Inject constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
    private val productsMapper: ProductsMapper,
) {

    suspend fun getAllProducts(): ProductsModel {
        val response = productRemoteDataSource.getAllProducts()
        return productsMapper.mapperTo(response)
    }
}