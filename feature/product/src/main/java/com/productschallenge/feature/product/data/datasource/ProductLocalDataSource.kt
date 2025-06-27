package com.productschallenge.feature.product.data.datasource

import com.productschallenge.core.database.data.dao.ProductEntityDao
import com.productschallenge.core.database.data.entity.product.ProductEntity
import javax.inject.Inject

internal class ProductLocalDataSource @Inject constructor(
    private val productDao: ProductEntityDao,
) {

    suspend fun insertAll(products: List<ProductEntity>) {
        productDao.insertAll(products)
    }

    suspend fun getAll() = productDao.getAll()
}