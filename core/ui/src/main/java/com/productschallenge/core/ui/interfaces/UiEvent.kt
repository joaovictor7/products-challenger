package com.productschallenge.core.ui.interfaces

import kotlinx.coroutines.flow.SharedFlow

interface UiEvent<UiEvent> {
    val uiEvent: SharedFlow<UiEvent>
}