package com.productschallenge.feature.form.presenter.ui.form

import com.productschallenge.core.ui.interfaces.Intent
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import java.time.LocalDate

internal sealed interface FormIntent : Intent<FormIntentReceiver> {
    data class SetFormTextField(
        private val index: Int,
        private val newValue: String,
        private val formFieldType: FormFieldType,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.setFormTextField(index, newValue, formFieldType)
        }
    }

    data class FormTextFieldFocused(
        private val index: Int,
        private val formFieldType: FormFieldType,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.formTextFieldFocused(index, formFieldType)
        }
    }

    data class FormTextFieldUnfocused(
        private val index: Int,
        private val formFieldType: FormFieldType,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.formTextFieldUnfocused(index, formFieldType)
        }
    }

    data class SelectedDate(
        private val selectedDate: LocalDate,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.selectedDate(selectedDate)
        }
    }

    data class SetClassification(
        private val classification: FormClassification,
    ) : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.setClassification(classification)
        }
    }

    data object SubmitForm : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.submitForm()
        }
    }

    data object DismissSimpleDialog : FormIntent {
        override fun execute(intentReceiver: FormIntentReceiver) {
            intentReceiver.dismissSimpleDialog()
        }
    }
}