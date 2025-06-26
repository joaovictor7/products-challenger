package com.productschallenge.core.analytic.event

import com.productschallenge.core.analytic.screen.ScreenAnalytic

interface AnalyticEvent : ScreenAnalytic {
    val tag: String
    val params: Map<String, *>
}