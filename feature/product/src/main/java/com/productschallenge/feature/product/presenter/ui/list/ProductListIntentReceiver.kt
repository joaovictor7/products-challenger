package com.productschallenge.feature.product.presenter.ui.list

import com.productschallenge.core.ui.interfaces.IntentReceiver

internal interface ProductListIntentReceiver : IntentReceiver<ProductListIntentReceiver> {
    fun getAllProducts()
    fun navigateToDetail(exchangeId: String)
    fun productFilter(filter: String)
    fun dismissSimpleDialog()
}