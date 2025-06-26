package com.productschallenge.navigation.di

import com.productschallenge.core.router.interfaces.NavGraph
import com.productschallenge.feature.product.navigation.ProductNavGraph
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class NavigationModule {

    @Provides
    fun navGraphs(): Array<NavGraph> = arrayOf(
        ProductNavGraph,
    )
}