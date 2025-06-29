package com.productschallenge.feature.form.presenter.ui.form

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewModelScope
import com.productschallenge.common.extension.convertToString
import com.productschallenge.common.extension.isEmailAddress
import com.productschallenge.common.extension.orFalse
import com.productschallenge.core.analytic.event.CommonAnalyticEvent
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.base.BaseViewModel
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.extension.uiStateValue
import com.productschallenge.core.ui.interfaces.UiState
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.form.R
import com.productschallenge.feature.form.analytic.screen.FormScreenAnalytic
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import com.productschallenge.feature.form.presenter.model.FormTextFieldModel
import com.productschallenge.feature.form.presenter.ui.dialog.FormSimpleDialogParam
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
internal class FormViewModel @Inject constructor(
    private val analyticSender: AnalyticSender,
    @param:AsyncTaskUtilsQualifier(FormScreenAnalytic.SCREEN) private val asyncTaskUtils: AsyncTaskUtils,
) : BaseViewModel(), UiState<FormUiState>, FormIntentReceiver {

    override val intentReceiver = this

    private val _uiState = MutableStateFlow(FormUiState())
    override val uiState = _uiState.asStateFlow()

    init {
        sendOpenScreenAnalytic()
    }

    override fun sendOpenScreenAnalytic() {
        asyncTaskUtils.runAsyncTask(viewModelScope) {
            analyticSender.sendEvent(CommonAnalyticEvent.OpenScreen(FormScreenAnalytic))
        }
    }

    override fun setFormTextField(index: Int, newValue: String) {
        val formTextField = uiStateValue.fields.getOrNull(index) ?: return
        when (formTextField.type) {
            FormFieldType.PROMOTIONAL_CODE -> setPromotionalCodeFormTextField(
                index, newValue, formTextField
            )
            FormFieldType.PHONE_NUMBER -> setPhoneNumberFormTextField(index, newValue, formTextField)
            FormFieldType.EMAIL -> setEmailFormTextField(index, newValue, formTextField)
            else -> updateFormTextFields(index, formTextField.copy(value = newValue))
        }
    }

    override fun formTextFieldFocused(index: Int) {
        val formTextField = uiStateValue.fields.getOrNull(index) ?: return
        updateFormTextFields(index, formTextField.copy(errorMsgId = null))
    }

    override fun formTextFieldUnfocused(index: Int) {
        val formTextField = uiStateValue.fields.getOrNull(index)
            .takeIf { it?.value?.isNotBlank().orFalse } ?: return
        when (formTextField.type) {
            FormFieldType.EMAIL -> checkEmailField(index, formTextField)
            FormFieldType.PROMOTIONAL_CODE -> checkPromotionalCodeField(index, formTextField)
            else -> Unit
        }
    }

    override fun selectedDate(selectedDate: LocalDate) {
        val dateString = selectedDate.convertToString("dd/MM/yyyy")
        val index = uiStateValue.fields.indexOfFirst {
            it.type == FormFieldType.DELIVERY_DATE
        }.takeIf { it != -1 } ?: return
        val formTextField = uiStateValue.fields.getOrNull(index) ?: return
        updateFormTextFields(index, formTextField.copy(value = dateString, isValid = true))
    }

    override fun setClassification(classification: FormClassification) {
        _uiState.update { it.copy(classification = classification) }
    }

    override fun submitForm() {
        _uiState.update { it.copy(simpleDialogParam = FormSimpleDialogParam.Success) }
    }

    override fun dismissSimpleDialog() {
        _uiState.update { it.copy(simpleDialogParam = null) }
    }

    private fun setEmailFormTextField(
        index: Int,
        newValue: String,
        formTextField: FormTextFieldModel
    ) {
        updateFormTextFields(
            index,
            formTextField.copy(value = newValue, isValid = newValue.isEmailAddress)
        )
    }

    private fun setPhoneNumberFormTextField(
        index: Int,
        newValue: String,
        formTextField: FormTextFieldModel
    ) {
        if (newValue.isDigitsOnly()) {
            updateFormTextFields(
                index,
                formTextField.copy(
                    value = newValue,
                    isValid = newValue.isNotBlank()
                )
            )
        }
    }

    private fun setPromotionalCodeFormTextField(
        index: Int,
        newValue: String,
        formTextField: FormTextFieldModel
    ) {
        if (newValue.length > MAX_PROMOTIONAL_CODE_LENGTH) return
        val upper = newValue.uppercase()
        if (Regex("^[A-Z0-9-]*$").matches(upper)) {
            updateFormTextFields(
                index,
                formTextField.copy(
                    value = upper,
                    isValid = upper.length >= MIN_PROMOTIONAL_CODE_LENGTH
                )
            )
        }
    }

    private fun updateFormTextFields(index: Int, formTextField: FormTextFieldModel) {
        _uiState.update {
            val formTextFieldModels = it.fields.toMutableList().apply {
                this[index] = formTextField
            }
            it.copy(fields = formTextFieldModels)
        }
    }

    private fun checkEmailField(index: Int, formTextField: FormTextFieldModel) {
        if (!formTextField.value.isEmailAddress) {
            updateFormTextFields(index, formTextField.copy(errorMsgId = R.string.form_email_error))
        }
    }

    private fun checkPromotionalCodeField(index: Int, formTextField: FormTextFieldModel) {
        if (formTextField.value.length < MIN_PROMOTIONAL_CODE_LENGTH) {
            updateFormTextFields(
                index,
                formTextField.copy(errorMsgId = R.string.form_promotional_code_error)
            )
        }
    }

    private companion object {
        const val MAX_PROMOTIONAL_CODE_LENGTH = 7
        const val MIN_PROMOTIONAL_CODE_LENGTH = 3
    }
}