package com.productschallenge.feature.product.presenter.ui.list

import com.productschallenge.core.ui.interfaces.Intent

internal sealed interface ProductListIntent : Intent<ProductListIntentReceiver> {
    data object GetAllProducts : ProductListIntent {
        override fun execute(intentReceiver: ProductListIntentReceiver) {
            intentReceiver.getAllProducts()
        }
    }

    data object DismissSimpleDialog : ProductListIntent {
        override fun execute(intentReceiver: ProductListIntentReceiver) {
            intentReceiver.dismissSimpleDialog()
        }
    }

    data class NavigateToDetail(private val exchangeId: String) : ProductListIntent {
        override fun execute(intentReceiver: ProductListIntentReceiver) {
            intentReceiver.navigateToDetail(exchangeId)
        }
    }

    data class ProductFilter(private val exchange: String) : ProductListIntent {
        override fun execute(intentReceiver: ProductListIntentReceiver) {
            intentReceiver.productFilter(exchange)
        }
    }
}