package com.productschallenge.feature.form.presenter.ui.form

import com.productschallenge.core.ui.interfaces.IntentReceiver
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import java.time.LocalDate

internal interface FormIntentReceiver : IntentReceiver<FormIntentReceiver> {
    fun setFormTextField(index: Int, newValue: String, formFieldType: FormFieldType)
    fun formTextFieldFocused(index: Int, formFieldType: FormFieldType)
    fun formTextFieldUnfocused(index: Int, formFieldType: FormFieldType)
    fun selectedDate(selectedDate: LocalDate)
    fun setClassification(classification: FormClassification)
    fun submitForm()
    fun dismissSimpleDialog()
}