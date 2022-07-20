package com.jorge.paulo.cac.core.commom.ui.components


import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White

@Composable
fun AppFloatingButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    backgroundColor: Color = White,
    contentColor: Color = Orange,
    onClick: () -> Unit,
    shape: CornerBasedShape = Shapes.medium
) {

    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .clip(shape),
        contentColor = contentColor,
        backgroundColor = backgroundColor
    ) {
        icon()
    }
}