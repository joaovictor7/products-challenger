package com.productschallenge.feature.product.domain.model

internal data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String?,
    val sku: String,
    val weight: Int,
    val dimensions: DimensionsModel,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<ReviewModel>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val meta: MetaModel,
    val images: List<String>,
    val thumbnail: String
)