package com.productschallenge.feature.product.presenter.mapper

import com.productschallenge.feature.product.R
import com.productschallenge.feature.product.navigation.destination.ProductDetailDestination
import com.productschallenge.feature.product.presenter.model.ProductDetailRow
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import javax.inject.Inject

internal class ProductDetailMapper @Inject constructor() {
    private val decimalFormatSymbols = DecimalFormatSymbols().apply {
        decimalSeparator = ','
        groupingSeparator = '.'
    }
    private val decimalFormat = DecimalFormat("$#,##0.00", decimalFormatSymbols)

    fun mapperToModel(destination: ProductDetailDestination) = listOf(
        ProductDetailRow(R.string.product_detail_rating, destination.rating.toString(), true),
        ProductDetailRow(R.string.product_detail_price, decimalFormat.format(destination.price)),
        ProductDetailRow(
            R.string.product_detail_discount_percentage,
            "${destination.discountPercentage}%"
        ),
        ProductDetailRow(R.string.product_detail_stock, destination.stock.toString()),
    )
}