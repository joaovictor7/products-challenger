package com.productschallenge.feature.form.presenter.ui.form

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewModelScope
import com.productschallenge.common.extension.convertToString
import com.productschallenge.core.analytic.event.CommonAnalyticEvent
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.ui.base.BaseViewModel
import com.productschallenge.core.ui.di.qualifier.AsyncTaskUtilsQualifier
import com.productschallenge.core.ui.extension.uiStateValue
import com.productschallenge.core.ui.interfaces.UiState
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.form.analytic.screen.FormScreenAnalytic
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.domain.model.FormModel
import com.productschallenge.feature.form.domain.usecase.CheckDataFormUseCase
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
internal class FormViewModel @Inject constructor(
    private val analyticSender: AnalyticSender,
    private val checkDataFormUseCase: CheckDataFormUseCase,
    @param:AsyncTaskUtilsQualifier(FormScreenAnalytic.SCREEN) private val asyncTaskUtils: AsyncTaskUtils,
) : BaseViewModel(),
    UiState<FormUiState>,
    FormIntentReceiver {

    private var form = FormModel()

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

    override fun watchingFormField(index: Int, newValue: String, formFieldType: FormFieldType) {
        when (formFieldType) {
            FormFieldType.PROMOTIONAL_CODE -> handlePromotionalCodeField(index, newValue)
            FormFieldType.PHONE -> handlePhoneCodeField(index, newValue)
            else -> handleFormField(index, newValue)
        }
    }

    override fun selectedDate(selectedDate: LocalDate) {
        val dateString = selectedDate.convertToString("dd/MM/yyyy")
        val index = uiStateValue.fields.indexOfFirst {
            it.type == FormFieldType.DELIVERY_DATE
        }.takeIf { it != -1 } ?: return
        handleFormField(index, dateString)
    }

    override fun watchingClassification(classification: FormClassification) {
        _uiState.update { it.copy(classification = classification) }
    }

    override fun submit() {
        TODO("Not yet implemented")
    }

    private fun handleFormField(index: Int, newValue: String) {
        _uiState.update {
            val field = it.fields.getOrNull(index) ?: return
            val formTextFieldModels = it.fields.toMutableList().apply {
                this[index] = field.copy(value = newValue)
            }
            it.copy(fields = formTextFieldModels)
        }
    }

    private fun handlePhoneCodeField(index: Int, newValue: String) {
        if (newValue.isDigitsOnly()) {
            handleFormField(index, newValue)
        }
    }

    private fun handlePromotionalCodeField(index: Int, newValue: String) {
        if (newValue.length > MAX_PROMOTIONAL_CODE_LENGTH) return
        val upper = newValue.uppercase()
        if (Regex("^[A-Z0-9-]*$").matches(upper)) {
            handleFormField(index, upper)
        }
    }

    private companion object {
        const val MAX_PROMOTIONAL_CODE_LENGTH = 7
    }
}