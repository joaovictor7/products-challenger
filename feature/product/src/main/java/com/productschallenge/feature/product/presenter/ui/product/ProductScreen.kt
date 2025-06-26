package com.productschallenge.feature.product.presenter.ui.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.productschallenge.core.designsystem.extension.horizontalScreenMargin
import com.productschallenge.core.designsystem.theme.ComposeTestTheme
import com.productschallenge.feature.product.R

@Composable
internal fun ProductScreen() {
    Column(
        modifier = Modifier
            .horizontalScreenMargin()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.home_text),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeTestTheme {
        ProductScreen()
    }
}