package com.productschallenge.domain.usecase

import com.productschallenge.core.domain.model.AppThemeModel
import com.productschallenge.core.domain.enums.Theme
import com.productschallenge.domain.mapper.AppThemeMapper
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

internal class GetAppThemeUseCase @Inject internal constructor(
//    private val configurationRepository: ConfigurationRepository,
    private val mapper: AppThemeMapper,
) {
    //    operator fun invoke() = configurationRepository
//        .getThemeConfiguration()
//        .map(mapper::mapperToModel)
    operator fun invoke() = flowOf(
        AppThemeModel(
            theme = Theme.AUTO,
            dynamicColor = false
        )
    )
}