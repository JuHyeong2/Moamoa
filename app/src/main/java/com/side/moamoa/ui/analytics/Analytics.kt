package com.side.moamoa.ui.analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.side.moamoa.R
import com.side.moamoa.ui.theme.AppBackgroundColor

@Composable
fun AnalyticsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackgroundColor)
    ) {
        Text(
            text = stringResource(id = R.string.navigation_title_analytics),
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2
        )
    }
}