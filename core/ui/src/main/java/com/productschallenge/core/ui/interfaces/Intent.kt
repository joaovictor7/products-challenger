package com.productschallenge.core.ui.interfaces

interface Intent<IntentReceiver> {
    fun execute(intentReceiver: IntentReceiver)
}