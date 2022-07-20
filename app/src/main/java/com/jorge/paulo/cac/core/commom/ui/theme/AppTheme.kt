package com.jorge.paulo.cac.core.commom.ui.theme

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTheme(
    slot: @Composable () -> Unit
) {
    CacTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            contentColor = White,
        ) {
            slot()
        }
    }
}