package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jorge.paulo.cac.core.commom.ui.theme.Black25

@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    color: Color = Black25,
) {
    Divider(
        color = color,
        modifier = modifier
    )
}