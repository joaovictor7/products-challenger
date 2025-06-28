package com.productschallenge.feature.form.presenter.model

import androidx.compose.ui.text.input.KeyboardType
import com.productschallenge.core.designsystem.enums.textfield.TextFieldIcon
import com.productschallenge.feature.form.presenter.enums.FormFieldType

internal data class FormTextFieldModel(
    val type: FormFieldType,
    val value: String = String(),
    val keyboardType: KeyboardType = KeyboardType.Text,
    val leadingIcon: TextFieldIcon? = null,
    val error: String? = null,
) {
    val isError get() = error != null
    val isDeliveryDate  get() = type == FormFieldType.DELIVERY_DATE
}