package com.productschallenge.core.ui.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.productschallenge.core.ui.interfaces.ViewModelParamFactory

@Composable
inline fun <reified VM : ViewModel, P> hiltViewModelWithParam(
    param: P?
) = hiltViewModel<VM, ViewModelParamFactory<P, VM>>(
    creationCallback = { factory -> factory.create(param) }
)