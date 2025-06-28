package com.productschallenge.feature.form.presenter.di

import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.form.analytic.screen.FormScreenAnalytic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {

    @Provides
    @AsyncTaskUtilsQualifier(FormScreenAnalytic.SCREEN)
    fun formAsyncTaskUtils(
        analyticSender: AnalyticSender
    ): AsyncTaskUtils = AsyncTaskUtils(analyticSender, FormScreenAnalytic)
}