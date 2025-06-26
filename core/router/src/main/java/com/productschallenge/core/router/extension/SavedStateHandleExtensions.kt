package com.productschallenge.core.router.extension

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.productschallenge.core.router.interfaces.Destination
import com.productschallenge.core.router.util.getNavTypes

inline fun <reified D : Destination> SavedStateHandle.getDestination() =
    toRoute<D>(getNavTypes<D>())