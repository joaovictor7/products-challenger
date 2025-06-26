package com.productschallenge.feature.product.data.mapper

import com.productschallenge.feature.product.domain.model.ProductModel
import com.productschallenge.feature.product.network.response.ProductResponse
import javax.inject.Inject

internal class ProductMapper @Inject constructor(
    private val dimensionMapper: DimensionMapper,
    private val reviewMapper: ReviewMapper,
    private val metaMapper: MetaMapper,
) {

    fun mapperTo(products: List<ProductResponse>) = products.map { mapperTo(it) }

    fun mapperTo(product: ProductResponse) = ProductModel(
        id = product.id,
        title = product.title,
        description = product.description,
        category = product.category,
        price = product.price,
        discountPercentage = product.discountPercentage,
        rating = product.rating,
        stock = product.stock,
        tags = product.tags,
        brand = product.brand,
        sku = product.sku,
        weight = product.weight,
        dimensions = dimensionMapper.mapperTo(product.dimensions),
        warrantyInformation = product.warrantyInformation,
        shippingInformation = product.shippingInformation,
        availabilityStatus = product.availabilityStatus,
        reviews = reviewMapper.mapperTo(product.reviews),
        returnPolicy = product.returnPolicy,
        minimumOrderQuantity = product.minimumOrderQuantity,
        meta = metaMapper.mapperTo(product.meta),
        images = product.images,
        thumbnail = product.thumbnail
    )
}