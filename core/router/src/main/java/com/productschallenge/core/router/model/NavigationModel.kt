package com.productschallenge.core.router.model

import com.productschallenge.core.router.enums.NavigationMode
import com.productschallenge.core.router.interfaces.Destination

data class NavigationModel(
    val destination: Destination,
    val navigationMode: NavigationMode? = null
)
