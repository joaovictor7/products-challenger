package com.productschallenge.feature.product.presenter.ui.list

import com.productschallenge.core.ui.interfaces.IntentReceiver

internal interface ProductListIntentReceiver : IntentReceiver<ProductListIntentReceiver> {
    fun resyncProducts()
    fun navigateToDetail(id: Int)
    fun productFilter(filter: String)
    fun dismissSimpleDialog()
}