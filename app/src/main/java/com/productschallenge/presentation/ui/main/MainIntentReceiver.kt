package com.productschallenge.presentation.ui.main

import com.productschallenge.core.ui.interfaces.IntentReceiver

internal interface MainIntentReceiver : IntentReceiver<MainIntentReceiver> {
    fun fetchRemoteConfig()
    fun dismissAlertDialog()
}