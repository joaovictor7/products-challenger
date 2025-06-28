package com.productschallenge.core.designsystem.component.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.productschallenge.core.designsystem.enums.textfield.TextFieldIcon
import com.productschallenge.core.designsystem.extension.opacity
import com.productschallenge.core.designsystem.theme.ProductsChallengeTheme
import com.productschallenge.core.designsystem.util.getTextFieldTrailingIcon

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    textValue: String,
    labelText: String,
    placeholderText: String? = null,
    supportingText: String? = null,
    trailingIcon: TextFieldIcon? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    leadingIcon: TextFieldIcon? = null,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardInput: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onClick: (() -> Unit)? = null,
    onTextChanged: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val passwordHidden = rememberSaveable { mutableStateOf(true) }
    val password = keyboardInput == KeyboardType.Password
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect {
            if (it is PressInteraction.Release) onClick?.invoke()
        }
    }
    TextField(
        value = textValue,
        enabled = enabled,
        singleLine = singleLine,
        isError = trailingIcon == TextFieldIcon.ERROR,
        readOnly = readOnly,
        modifier = modifier,
        interactionSource = interactionSource,
        onValueChange = { onTextChanged(it) },
        label = { Text(text = labelText, style = MaterialTheme.typography.bodyLarge) },
        placeholder = placeholderText?.let {
            { Text(text = it, style = MaterialTheme.typography.bodyLarge) }
        },
        supportingText = supportingText?.let {
            { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
        },
        leadingIcon = leadingIcon?.iconId?.let {
            { Icon(painter = painterResource(it), contentDescription = null) }
        },
        trailingIcon = getTextFieldTrailingIcon(
            trailingIcon,
            onTrailingIconClick,
            textValue,
            password,
            passwordHidden,
            onTextChanged
        ),
        visualTransformation = if (password && passwordHidden.value)
            PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardInput,
            imeAction = imeAction
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            errorContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface.opacity(0.04f)
        )
    )
}

@Composable
@Preview
private fun Preview() {
    ProductsChallengeTheme {
        val textValue by rememberSaveable { mutableStateOf("teste") }
        TextField(
            enabled = true,
            textValue = textValue,
            labelText = "Label",
            placeholderText = "Placeholder",
            supportingText = "Supporting text",
            trailingIcon = TextFieldIcon.CLEAR_TEXT
        ) { }
    }
}