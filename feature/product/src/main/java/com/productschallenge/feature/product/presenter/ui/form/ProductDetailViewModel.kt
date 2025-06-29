package com.productschallenge.feature.product.presenter.ui.form

import androidx.lifecycle.viewModelScope
import com.productschallenge.core.analytic.event.CommonAnalyticEvent
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.base.BaseViewModel
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.interfaces.UiState
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.product.analytic.screen.ProductDetailScreenAnalytic
import com.productschallenge.feature.product.navigation.destination.ProductDetailDestination
import com.productschallenge.feature.product.presenter.mapper.ProductDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ProductDetailViewModel @Inject constructor(
    private val destination: ProductDetailDestination,
    private val productDetailMapper: ProductDetailMapper,
    private val analyticSender: AnalyticSender,
    @param:AsyncTaskUtilsQualifier(ProductDetailScreenAnalytic.SCREEN) private val asyncTaskUtils: AsyncTaskUtils,
) : BaseViewModel(), UiState<ProductDetailUiState> {

    private val _uiState = MutableStateFlow(ProductDetailUiState())
    override val uiState = _uiState.asStateFlow()

    init {
        sendOpenScreenAnalytic()
        setDetails()
    }

    override fun sendOpenScreenAnalytic() {
        asyncTaskUtils.runAsyncTask(viewModelScope) {
            analyticSender.sendEvent(CommonAnalyticEvent.OpenScreen(ProductDetailScreenAnalytic))
        }
    }

    private fun setDetails() {
        _uiState.update {
            it.setProductDetails(
                destination.thumbnail,
                destination.title,
                destination.description,
                productDetailMapper.mapperToModel(destination)
            )
        }
    }
}