package com.productschallenge.feature.product.navigation.destination

import com.productschallenge.core.router.interfaces.Destination
import kotlinx.serialization.Serializable

@Serializable
internal data class ProductDetailDestination(
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
) : Destination