@file:OptIn(ExperimentalMaterial3Api::class)

package com.productschallenge.feature.form.presenter.ui.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import com.productschallenge.common.extension.convertedFromUnix2
import com.productschallenge.core.designsystem.component.button.Button
import com.productschallenge.core.designsystem.component.datepicker.DatePicker
import com.productschallenge.core.designsystem.component.textfield.TextField
import com.productschallenge.core.designsystem.dimension.Spacing
import com.productschallenge.core.designsystem.extension.horizontalScreenMargin
import com.productschallenge.core.designsystem.extension.stringResource
import com.productschallenge.core.ui.interfaces.Intent
import com.productschallenge.feature.form.domain.emuns.FormClassification
import com.productschallenge.feature.form.presenter.extension.textId
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneOffset
import com.productschallenge.core.designsystem.R as DesignSystemRes

@Composable
internal fun FormScreen(
    uiState: FormUiState,
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit = {},
) {
    var showDatePicker by remember { mutableStateOf(false) }
    if (showDatePicker) {
        DatePicker(
            selectableDates = PastOrPresentSelectableDates,
            onDismissRequest = { showDatePicker = false },
            onDateSelected = {
                onExecuteIntent(FormIntent.SelectedDate(it))
                showDatePicker = false
            }
        )
    }
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
        Column(verticalArrangement = Arrangement.spacedBy(Spacing.large)) {
            uiState.fields.forEachIndexed { index, field ->
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {

                        },
                    labelText = stringResource(field.type.labelId),
                    textValue = field.value,
                    leadingIcon = field.leadingIcon,
                    keyboardInput = field.keyboardType,
                    readOnly = field.isDeliveryDate,
                    onClick = if (field.isDeliveryDate) {
                        { showDatePicker = true }
                    } else null
                ) {
                    onExecuteIntent(FormIntent.WatchingFormField(index, it, field.type))
                }
            }
            ClassificationField(onExecuteIntent, uiState.classification)
            Button(text = "Submeter") {
                onExecuteIntent(FormIntent.Submit)
            }
        }
    }
}

@Composable
private fun ClassificationField(
    onExecuteIntent: (Intent<FormIntentReceiver>) -> Unit = {},
    classification: FormClassification
) {
    val isDropDownExpanded = remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            isDropDownExpanded.value = true
        }
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
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                onClick = {
                    isDropDownExpanded.value = false
                    onExecuteIntent(FormIntent.WatchingClassification(it))
                }
            )
        }
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