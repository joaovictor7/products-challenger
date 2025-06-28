package com.productschallenge.feature.form.presenter.ui.form

import androidx.compose.ui.text.input.KeyboardType
import com.productschallenge.core.designsystem.enums.textfield.TextFieldIcon
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import com.productschallenge.feature.form.presenter.model.FormTextFieldModel

internal data class FormUiState(
    val fields: List<FormTextFieldModel> = initialFields,
    val classification: FormClassification = FormClassification.EXCELLENT,
) {
    private companion object {
        val initialFields = listOf(
            FormTextFieldModel(FormFieldType.NAME),
            FormTextFieldModel(FormFieldType.EMAIL, keyboardType = KeyboardType.Email),
            FormTextFieldModel(FormFieldType.PHONE, keyboardType = KeyboardType.Number),
            FormTextFieldModel(FormFieldType.PROMOTIONAL_CODE, keyboardType = KeyboardType.Ascii),
            FormTextFieldModel(FormFieldType.DELIVERY_DATE, leadingIcon = TextFieldIcon.CALENDAR),
        )
    }
}
