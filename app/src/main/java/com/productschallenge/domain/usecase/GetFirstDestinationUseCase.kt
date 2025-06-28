package com.productschallenge.domain.usecase

import com.productschallenge.core.domain.enums.Flavor
import com.productschallenge.core.domain.provider.BuildConfigProvider
import com.productschallenge.feature.form.navigation.destination.FormDestination
import com.productschallenge.feature.product.navigation.destination.ProductListDestination
import javax.inject.Inject

internal class GetFirstDestinationUseCase @Inject internal constructor(
    private val buildConfigProvider: BuildConfigProvider
) {
    operator fun invoke() = if (buildConfigProvider.buildConfig.distributionFlavor == Flavor.PRODUCTS) {
        ProductListDestination
    } else {
        FormDestination
    }
}