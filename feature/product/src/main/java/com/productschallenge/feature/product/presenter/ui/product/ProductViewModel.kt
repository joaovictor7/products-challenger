package com.productschallenge.feature.product.presenter.ui.product

import androidx.lifecycle.viewModelScope
import com.productschallenge.core.analytic.event.CommonAnalyticEvent
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.base.BaseViewModel
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.product.analytic.screen.ProductScreenAnalytic
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class ProductViewModel @Inject constructor(
    private val analyticSender: AnalyticSender,
    @param:AsyncTaskUtilsQualifier(ProductScreenAnalytic.SCREEN) private val asyncTaskUtils: AsyncTaskUtils,
) : BaseViewModel() {

    init {
        sendOpenScreenAnalytic()
    }

    override fun sendOpenScreenAnalytic() {
        asyncTaskUtils.runAsyncTask(viewModelScope) {
            analyticSender.sendEvent(CommonAnalyticEvent.OpenScreen(ProductScreenAnalytic))
        }
    }
}