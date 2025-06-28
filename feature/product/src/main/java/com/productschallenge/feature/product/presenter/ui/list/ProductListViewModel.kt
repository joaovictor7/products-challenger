package com.productschallenge.feature.product.presenter.ui.list

import androidx.lifecycle.viewModelScope
import com.productschallenge.core.analytic.event.CommonAnalyticEvent
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.router.extension.dialogErrorDestination
import com.productschallenge.core.router.model.NavigationModel
import com.productschallenge.core.ui.base.BaseViewModel
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.interfaces.UiEvent
import com.productschallenge.core.ui.interfaces.UiState
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.product.analytic.screen.ProductListScreenAnalytic
import com.productschallenge.feature.product.domain.model.ProductModel
import com.productschallenge.feature.product.domain.usecase.FilterProductsUseCase
import com.productschallenge.feature.product.domain.usecase.GetAllProductsUseCase
import com.productschallenge.feature.product.domain.usecase.ResyncProductsUseCase
import com.productschallenge.feature.product.presenter.mapper.ProductDestinationlMapper
import com.productschallenge.feature.product.presenter.mapper.ProductItemListMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ProductListViewModel @Inject constructor(
    private val analyticSender: AnalyticSender,
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val resyncProductsUseCase: ResyncProductsUseCase,
    private val filterProductsUseCase: FilterProductsUseCase,
    private val productItemListMapper: ProductItemListMapper,
    private val productDestinationlMapper: ProductDestinationlMapper,
    @param:AsyncTaskUtilsQualifier(ProductListScreenAnalytic.SCREEN) private val asyncTaskUtils: AsyncTaskUtils,
) : BaseViewModel(),
    UiState<ProductListUiState>,
    UiEvent<ProductListUiIntent>,
    ProductListIntentReceiver {

    override val intentReceiver = this

    private var productList = emptyList<ProductModel>()

    private val _uiState = MutableStateFlow(ProductListUiState())
    override val uiState = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<ProductListUiIntent>()
    override val uiEvent = _uiEvent.asSharedFlow()

    init {
        sendOpenScreenAnalytic()
        getAllProducts()
    }

    override fun sendOpenScreenAnalytic() {
        asyncTaskUtils.runAsyncTask(viewModelScope) {
            analyticSender.sendEvent(CommonAnalyticEvent.OpenScreen(ProductListScreenAnalytic))
        }
    }

    override fun resyncProducts() {
        _uiState.update { it.setIsLoading(true) }
        asyncTaskUtils.runAsyncTask(
            coroutineScope = viewModelScope,
            onError = { errorHandler(it) },
            onCompletion = { _uiState.update { it.setIsLoading(false) } }
        ) {
            productList = resyncProductsUseCase()
            _uiState.update { it.setProductScreenList(productItemListMapper.mapperTo(productList)) }
        }
    }

    override fun navigateToDetail(id: Int) {
        val product = productList.find { it.id == id } ?: return
        val destination = productDestinationlMapper.mapperToDestination(product)
        _uiEvent.emitEvent(ProductListUiIntent.NavigateTo(NavigationModel(destination)))
    }

    override fun productFilter(filter: String) {
        val productsFiltered = filterProductsUseCase(productList, filter)
        _uiState.update {
            it.setProductScreenList(
                productItemListMapper.mapperTo(productsFiltered),
                filter,
            )
        }
    }

    override fun dismissSimpleDialog() {
        _uiState.update { it.setSimpleDialogParam(null) }
    }

    private fun getAllProducts() {
        _uiState.update { it.setIsLoading(true) }
        asyncTaskUtils.runAsyncTask(
            coroutineScope = viewModelScope,
            onError = { errorHandler(it) },
            onCompletion = { _uiState.update { it.setIsLoading(false) } }
        ) {
            productList = getAllProductsUseCase()
            _uiState.update { it.setProductScreenList(productItemListMapper.mapperTo(productList)) }
        }
    }

    private fun errorHandler(error: Throwable) {
        _uiEvent.emitEvent(ProductListUiIntent.NavigateTo(error.dialogErrorDestination()))
    }
}