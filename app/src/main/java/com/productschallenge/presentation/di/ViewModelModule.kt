package com.productschallenge.presentation.di

import com.productschallenge.analytic.screen.MainScreenAnalytic
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.util.AsyncTaskUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {

    @Provides
    @AsyncTaskUtilsQualifier(MainScreenAnalytic.SCREEN)
    fun mainAsyncTaskUtils(
        analyticSender: AnalyticSender
    ): AsyncTaskUtils = AsyncTaskUtils(analyticSender, MainScreenAnalytic)
}