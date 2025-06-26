package com.productschallenge.core.ui.provider

import android.location.Location

interface LocationProvider {
    suspend fun getCurrentLocation(): Location
    suspend fun isLocationEnabled(): Boolean
}