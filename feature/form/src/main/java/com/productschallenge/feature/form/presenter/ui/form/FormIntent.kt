package com.productschallenge.feature.form.presenter.ui.form

import com.productschallenge.core.ui.interfaces.Intent
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import java.time.LocalDate

internal sealed interface FormIntent : Intent<FormIntentReceiver> {
    data class WatchingFormField(
        private val index: Int,
        private val newValue: String,
        private val formFieldType: FormFieldType,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.watchingFormField(index, newValue, formFieldType)
        }
    }

    data class SelectedDate(
        private val selectedDate: LocalDate,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.selectedDate(selectedDate)
        }
    }

    data class WatchingClassification(
        private val classification: FormClassification,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.watchingClassification(classification)
        }
    }

    data object Submit : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.submit()
        }
    }
}