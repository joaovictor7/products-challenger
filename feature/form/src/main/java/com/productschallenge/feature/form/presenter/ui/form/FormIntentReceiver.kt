package com.productschallenge.feature.form.presenter.ui.form

import com.productschallenge.core.ui.interfaces.IntentReceiver
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import java.time.LocalDate

internal interface FormIntentReceiver : IntentReceiver<FormIntentReceiver> {
    fun watchingFormField(index: Int, newValue: String, formFieldType: FormFieldType)
    fun selectedDate(selectedDate: LocalDate)
    fun watchingClassification(classification: FormClassification)
    fun submit()
}