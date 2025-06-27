package com.productschallenge.feature.product.data.di

import com.productschallenge.core.data.provider.AssetsProvider
import com.productschallenge.core.data.provider.EnvironmentInstanceProvider
import com.productschallenge.core.network.di.qualifier.ApiQualifier
import com.productschallenge.core.network.util.ApiCallUtils
import com.productschallenge.feature.product.data.datasource.ProductRemoteApiDataSource
import com.productschallenge.feature.product.data.datasource.ProductRemoteDataSource
import com.productschallenge.feature.product.data.datasource.ProductRemoteFakeDataSource
import com.productschallenge.feature.product.network.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    fun productRemoteDataSource(
        environmentInstanceProvider: EnvironmentInstanceProvider,
        apiCallUtils: ApiCallUtils,
        assetsProvider: AssetsProvider,
        @ApiQualifier(Api.DUMMY_JSON_PRODUCTS) httpClient: HttpClient,
    ): ProductRemoteDataSource = environmentInstanceProvider.getInstance(
        ProductRemoteApiDataSource(apiCallUtils, httpClient),
        ProductRemoteFakeDataSource(apiCallUtils, assetsProvider)
    )
}