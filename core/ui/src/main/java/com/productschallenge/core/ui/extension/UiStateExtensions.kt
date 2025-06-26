package com.productschallenge.core.ui.extension

import com.productschallenge.core.ui.interfaces.UiState

val <T> UiState<T>.uiStateValue get() = uiState.value