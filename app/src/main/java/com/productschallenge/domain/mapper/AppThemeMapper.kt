package com.productschallenge.domain.mapper

import com.productschallenge.core.domain.model.AppThemeModel
import com.productschallenge.core.domain.model.ThemeConfigurationModel
import javax.inject.Inject

internal class AppThemeMapper @Inject constructor() {
    fun mapperToModel(
        themeConfiguration: ThemeConfigurationModel,
    ) = AppThemeModel(
        theme = themeConfiguration.theme,
        dynamicColor = themeConfiguration.dynamicColor
    )
}