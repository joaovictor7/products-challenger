package com.productschallenge.feature.product.presenter.di

import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.product.analytic.screen.ProductListScreenAnalytic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {

    @Provides
    @AsyncTaskUtilsQualifier(ProductListScreenAnalytic.SCREEN)
    fun homeAsyncTaskUtils(
        analyticSender: AnalyticSender
    ): AsyncTaskUtils = AsyncTaskUtils(analyticSender, ProductListScreenAnalytic)
}