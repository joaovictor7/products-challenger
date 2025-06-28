package com.productschallenge.feature.product.data.repository

import com.productschallenge.feature.product.data.datasource.ProductLocalDataSource
import com.productschallenge.feature.product.data.datasource.ProductRemoteDataSource
import com.productschallenge.feature.product.data.mapper.ProductEntityMapper
import com.productschallenge.feature.product.data.mapper.ProductResponseMapper
import com.productschallenge.feature.product.domain.model.ProductModel
import javax.inject.Inject

internal class ProductRepository @Inject constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
    private val productEntityMapper: ProductEntityMapper,
    private val productResponseMapper: ProductResponseMapper,
) {

    suspend fun getAllProducts(): List<ProductModel> {
        var products = productEntityMapper.mapperToModels(productLocalDataSource.getAll())
        if (products.isEmpty()) {
            products = productResponseMapper
                .mapperToModels(productRemoteDataSource.getAllProducts().products)
            productLocalDataSource
                .insertAll(productEntityMapper.mapperToEntities(products))
        }
        return products
    }

    suspend fun getAllProducts1(): List<ProductModel> {
        val products = productResponseMapper
            .mapperToModels(productRemoteDataSource.getAllProducts().products)
        productLocalDataSource.clearAll()
        productLocalDataSource.insertAll(productEntityMapper.mapperToEntities(products))
        return products
    }
}