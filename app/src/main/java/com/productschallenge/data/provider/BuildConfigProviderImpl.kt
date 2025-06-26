package com.productschallenge.data.provider

import android.os.Build
import com.productschallenge.core.domain.provider.BuildConfigProvider
import com.productschallenge.BuildConfig
import com.productschallenge.core.domain.enums.BuildType.Companion.getBuildType
import com.productschallenge.core.domain.enums.Flavor.Companion.getFlavor
import com.productschallenge.core.domain.model.buildconfig.BuildConfigFieldsModel
import com.productschallenge.core.domain.model.buildconfig.BuildConfigModel
import javax.inject.Inject

internal class BuildConfigProviderImpl @Inject constructor() : BuildConfigProvider {

    override val buildConfig = BuildConfigModel(
        applicationId = BuildConfig.APPLICATION_ID,
        versionName = BuildConfig.VERSION_NAME,
        versionCode = BuildConfig.VERSION_CODE,
        buildType = BuildConfig.BUILD_TYPE.getBuildType(),
        flavor = BuildConfig.FLAVOR.getFlavor(),
        androidSdkVersion = Build.VERSION.SDK_INT,
    )

    override val buildConfigFields = BuildConfigFieldsModel(
        coinApiHost = BuildConfig.COIN_API_HOST,
        newsApiHost = BuildConfig.NEWS_API_HOST,
        openWeatherApiHost = BuildConfig.OPEN_WEATHER_API_HOST,
        openWeatherIconHost = BuildConfig.OPEN_WEATHER_ICON_HOST,
    )
}