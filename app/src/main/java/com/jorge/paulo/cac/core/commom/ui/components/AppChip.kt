package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes



@Composable
fun AppChip(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = LightGray,
    labelColor: Color = Black,
) {
    Surface(
        color = color,
        shape = Shapes.small,
        modifier = modifier.padding(10.dp)
    ) {

        AppText(
            appTextTypes = AppTextList.SMALL,
            text = text,
            color = labelColor,
            modifier = Modifier.padding(8.dp)
        )

    }
}