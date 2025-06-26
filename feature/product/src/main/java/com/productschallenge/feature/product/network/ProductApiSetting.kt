package com.productschallenge.feature.product.network

import com.productschallenge.core.network.ApiSetting

internal data class ProductApiSetting(
    override val url: String,
) : ApiSetting