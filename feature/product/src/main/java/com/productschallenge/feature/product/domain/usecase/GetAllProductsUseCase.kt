package com.productschallenge.feature.product.domain.usecase

import com.productschallenge.feature.product.data.repository.ProductRepository
import javax.inject.Inject

internal class GetAllProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke() = productRepository.getAllProducts()
}