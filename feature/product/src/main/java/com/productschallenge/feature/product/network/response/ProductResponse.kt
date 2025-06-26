package com.productschallenge.feature.product.network.response

import kotlinx.serialization.Serializable

@Serializable
internal data class ProductResponse(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String? = null,
    val sku: String,
    val weight: Int,
    val dimensions: DimensionResponse,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<ReviewResponse>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val meta: MetaResponse,
    val images: List<String>,
    val thumbnail: String
)