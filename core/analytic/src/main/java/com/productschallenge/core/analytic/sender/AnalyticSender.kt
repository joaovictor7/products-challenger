package com.productschallenge.core.analytic.sender

import com.productschallenge.core.analytic.event.AnalyticEvent
import com.productschallenge.core.analytic.event.ErrorAnalyticEvent

interface AnalyticSender {
    fun sendEvent(event: AnalyticEvent)
    fun sendErrorEvent(event: ErrorAnalyticEvent)
}