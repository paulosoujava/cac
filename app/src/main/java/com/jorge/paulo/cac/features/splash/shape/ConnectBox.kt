package com.jorge.paulo.cac.features.splash.shape

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout


@Composable
fun Modifier.placeAt(
    x: Int,
    y: Int,
) = layout { measurables, constraints ->
    val placeable = measurables.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x,y)
    }
}