@file:OptIn(ExperimentalMaterial3Api::class)

package com.productschallenge.feature.form.presenter.ui.form

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.productschallenge.common.extension.convertedFromUnix2
import com.productschallenge.core.designsystem.component.button.Button
import com.productschallenge.core.designsystem.component.datepicker.DatePicker
import com.productschallenge.core.designsystem.component.dialog.SimpleDialog
import com.productschallenge.core.designsystem.component.textfield.TextField
import com.productschallenge.core.designsystem.dimension.Spacing
import com.productschallenge.core.designsystem.extension.horizontalScreenMargin
import com.productschallenge.core.designsystem.extension.opacity
import com.productschallenge.core.designsystem.extension.stringResource
import com.productschallenge.core.designsystem.theme.ProductsChallengeTheme
import com.productschallenge.core.ui.interfaces.Intent
import com.productschallenge.feature.form.R
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.enums.FormFieldType
import com.productschallenge.feature.form.presenter.extension.textId
import com.productschallenge.feature.form.presenter.model.FormTextFieldModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneOffset
import com.productschallenge.core.designsystem.R as DesignSystemRes

@Composable
internal fun FormScreen(
    uiState: FormUiState,
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit = {},
) {
    val showDatePicker = remember { mutableStateOf(false) }
    DialogHandler(uiState = uiState, onExecuteIntent = onExecuteIntent)
    FormDatePicker(onExecuteIntent = onExecuteIntent, showDatePicker = showDatePicker)
    Column(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .horizontalScreenMargin()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(Spacing.tiny)) {
            uiState.fields.forEachIndexed { index, field ->
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .formTextFieldFocusManager(onExecuteIntent, index),
                    labelText = stringResource(field.type.labelId),
                    textValue = field.value,
                    leadingIcon = field.leadingIcon,
                    supportingText = stringResource(field.errorMsgId),
                    trailingIcon = field.trailingIcon,
                    keyboardInput = field.keyboardType,
                    readOnly = field.isDeliveryDate,
                    onClick = if (field.isDeliveryDate) {
                        { showDatePicker.value = true }
                    } else null
                ) { onExecuteIntent(FormIntent.SetFormTextField(index, it)) }
            }
            ClassificationField(
                onExecuteIntent = onExecuteIntent,
                classification = uiState.classification
            )
            Spacer(Modifier.height(Spacing.xxLarge))
            Button(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.form_submit_button),
                enabled = uiState.buttonEnabled,
            ) { onExecuteIntent(FormIntent.SubmitForm) }
        }
    }
}

@Composable
private fun FormDatePicker(
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit,
    showDatePicker: MutableState<Boolean>,
) {
    if (showDatePicker.value) {
        DatePicker(
            selectableDates = PastOrPresentSelectableDates,
            onDismissRequest = { showDatePicker.value = false },
            onDateSelected = {
                onExecuteIntent(FormIntent.SelectedDate(it))
                showDatePicker.value = false
            }
        )
    }
}

@Composable
private fun ClassificationField(
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit = {},
    classification: FormClassification
) {
    val isDropDownExpanded = remember { mutableStateOf(false) }
    Text(text = "Categoria", style = MaterialTheme.typography.bodyMedium)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.onSurface.opacity(0.08f))
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isDropDownExpanded.value = true }
                .padding(Spacing.semiLarge)
        ) {
            Text(
                text = stringResource(classification.textId),
                style = MaterialTheme.typography.bodyMedium,
            )
            Icon(
                painter = painterResource(id = DesignSystemRes.drawable.ic_arrow_down),
                contentDescription = null
            )
        }
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = isDropDownExpanded.value,
            onDismissRequest = {
                isDropDownExpanded.value = false
            }
        ) {
            FormClassification.entries.forEach {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(it.textId),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    },
                    onClick = {
                        isDropDownExpanded.value = false
                        onExecuteIntent(FormIntent.SetClassification(it))
                    }
                )
            }
        }
    }
}

@Composable
private fun DialogHandler(
    uiState: FormUiState,
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit
) = uiState.simpleDialogParam?.let {
    SimpleDialog(param = it) {
        onExecuteIntent(FormIntent.DismissSimpleDialog)
    }
}

@Composable
private fun Modifier.formTextFieldFocusManager(
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit,
    index: Int,
) = onFocusChanged {
    if (it.isFocused) {
        onExecuteIntent(FormIntent.FormTextFieldFocused(index))
    } else {
        onExecuteIntent(
            FormIntent.FormTextFieldUnfocused(index)
        )
    }
}

private object PastOrPresentSelectableDates : SelectableDates {
    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        val date = utcTimeMillis.convertedFromUnix2
        val isPastOrPresent = !date.isAfter(LocalDate.now(ZoneOffset.UTC))
        val isNotMonday = date.dayOfWeek != DayOfWeek.MONDAY
        return isPastOrPresent && isNotMonday
    }

    override fun isSelectableYear(year: Int): Boolean {
        return year <= LocalDate.now(ZoneOffset.UTC).year
    }
}

@Preview
@Composable
private fun Preview() {
    ProductsChallengeTheme {
        FormScreen(
            uiState = FormUiState(
                fields = listOf(
                    FormTextFieldModel(
                        value = "Notebook Gamer",
                        type = FormFieldType.NAME,
                        isValid = true
                    ),
                    FormTextFieldModel(
                        value = "R$ 4.500,00",
                        type = FormFieldType.EMAIL,
                        keyboardType = KeyboardType.Email,
                        isValid = true
                    ),
                    FormTextFieldModel(
                        value = "10/10/2023",
                        type = FormFieldType.PROMOTIONAL_CODE,
                        isValid = true
                    )
                ),
                classification = FormClassification.EXCELLENT
            )
        )
    }
}