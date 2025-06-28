package com.productschallenge.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.productschallenge.analytic.screen.MainScreenAnalytic
import com.productschallenge.core.domain.usecase.remoteconfig.FetchRemoteConfigUseCase
import com.productschallenge.core.router.interfaces.NavGraph
import com.productschallenge.core.ui.base.BaseViewModel
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.interfaces.UiEvent
import com.productschallenge.core.ui.interfaces.UiState
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.domain.usecase.GetAppThemeUseCase
import com.productschallenge.feature.form.navigation.destination.FormDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val getAppThemeUseCase: GetAppThemeUseCase,
    private val fetchRemoteConfigUseCase: FetchRemoteConfigUseCase,
    private val navGraphs: Array<NavGraph>,
    @param:AsyncTaskUtilsQualifier(MainScreenAnalytic.SCREEN) private val asyncTaskUtils: AsyncTaskUtils,
) : BaseViewModel(), UiState<MainUiState>, UiEvent<MainUiEvent>, MainIntentReceiver {

    override val intentReceiver = this

    private val _uiState = MutableStateFlow(MainUiState())
    override val uiState = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<MainUiEvent>()
    override val uiEvent = _uiEvent.asSharedFlow()

    init {
        appThemeObservable()
        initUiState()
    }

    override fun fetchRemoteConfig() {
        fetchRemoteConfigUseCase()
    }

    override fun dismissAlertDialog() {
        _uiState.update { it.setSimpleDialog(null) }
    }

    private fun initUiState() = asyncTaskUtils.runAsyncTask(viewModelScope) {
        _uiState.update { it.setInitUiState(FormDestination, navGraphs) }
    }

    private fun appThemeObservable() {
        asyncTaskUtils.runFlowTask(
            coroutineScope = viewModelScope,
            flow = getAppThemeUseCase()
        ) { appTheme ->
            _uiState.update { it.setAppTheme(appTheme) }
        }
    }
}