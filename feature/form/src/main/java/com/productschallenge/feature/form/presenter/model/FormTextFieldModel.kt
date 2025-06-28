package com.productschallenge.feature.form.presenter.model

import androidx.annotation.StringRes
import androidx.compose.ui.text.input.KeyboardType
import com.productschallenge.core.designsystem.enums.textfield.TextFieldIcon
import com.productschallenge.feature.form.presenter.enums.FormFieldType

internal data class FormTextFieldModel(
    val type: FormFieldType,
    val value: String = String(),
    val keyboardType: KeyboardType = KeyboardType.Text,
    val leadingIcon: TextFieldIcon? = null,
    val isValid: Boolean = false,
    @param:StringRes val errorMsgId: Int? = null,
) {
    val trailingIcon get() = if (errorMsgId != null) TextFieldIcon.ERROR else null
    val isDeliveryDate get() = type == FormFieldType.DELIVERY_DATE
}