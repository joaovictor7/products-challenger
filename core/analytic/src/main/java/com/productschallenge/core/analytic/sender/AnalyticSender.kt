package com.productschallenge.core.analytic.sender

import com.productschallenge.core.analytic.event.AnalyticEvent
import com.productschallenge.core.analytic.event.ErrorAnalyticEvent

interface AnalyticSender {
    suspend fun sendEvent(event: AnalyticEvent)
    suspend fun sendErrorEvent(event: ErrorAnalyticEvent)
}