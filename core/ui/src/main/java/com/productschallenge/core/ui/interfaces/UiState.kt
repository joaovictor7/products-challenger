package com.productschallenge.core.ui.interfaces

import kotlinx.coroutines.flow.StateFlow

interface UiState<UiState> {
    val uiState: StateFlow<UiState>
}