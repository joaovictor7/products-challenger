package com.productschallenge.presentation.ui.main

import com.productschallenge.core.ui.interfaces.Intent

internal sealed interface MainIntent : Intent<MainIntentReceiver> {
    data object FetchRemoteConfig : MainIntent {
        override fun execute(intentReceiver: MainIntentReceiver) {
            intentReceiver.fetchRemoteConfig()
        }
    }

    data object DismissAlertDialog : MainIntent {
        override fun execute(intentReceiver: MainIntentReceiver) {
            intentReceiver.dismissAlertDialog()
        }
    }
}