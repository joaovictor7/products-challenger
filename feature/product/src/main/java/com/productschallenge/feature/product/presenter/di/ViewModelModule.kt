package com.productschallenge.feature.product.presenter.di

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.product.analytic.screen.ProductDetailScreenAnalytic
import com.productschallenge.feature.product.analytic.screen.ProductListScreenAnalytic
import com.productschallenge.feature.product.navigation.destination.ProductDetailDestination
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {

    @Provides
    @AsyncTaskUtilsQualifier(ProductListScreenAnalytic.SCREEN)
    fun productListAsyncTaskUtils(
        analyticSender: AnalyticSender
    ): AsyncTaskUtils = AsyncTaskUtils(analyticSender, ProductListScreenAnalytic)

    @Provides
    @AsyncTaskUtilsQualifier(ProductDetailScreenAnalytic.SCREEN)
    fun productDetailAsyncTaskUtils(
        analyticSender: AnalyticSender
    ): AsyncTaskUtils = AsyncTaskUtils(analyticSender, ProductDetailScreenAnalytic)

    @Provides
    fun productDetailDestination(
        savedStateHandle: SavedStateHandle,
    ): ProductDetailDestination = savedStateHandle.toRoute()

}