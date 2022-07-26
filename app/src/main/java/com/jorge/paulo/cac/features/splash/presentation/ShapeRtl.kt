package com.jorge.paulo.cac.features.splash.presentation


import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path

fun rtlCurve(size: Size) = Path().apply {
    reset()
    val width = size.width
    val height = size.height
    val radius = 100f
    val upShift = height * (1f - 0.5f)
    // arc C1
    arcTo(
        rect = Rect(
            left = 0f,
            top = 0f,
            right = radius * 2,
            bottom = radius * 2
        ),
        startAngleDegrees = 180f,
        sweepAngleDegrees = 110f,
        forceMoveTo = false
    )
    // arc C2
    arcTo(
        rect = Rect(
            left = width - radius * 2,
            top = upShift - 10,
            right = width,
            bottom = upShift + radius * 2
        ),
        startAngleDegrees = -60f,
        sweepAngleDegrees = 65f,
        forceMoveTo = false
    )
    // arc C3
    arcTo(
        rect = Rect(
            left = width - radius * 2,
            top = height - radius * 2,
            right = width,
            bottom = height
        ),
        startAngleDegrees = 0f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
    // arc C4
    arcTo(
        rect = Rect(
            left = 0f,
            top = height - radius * 2,
            right = radius * 2,
            bottom = height
        ),
        startAngleDegrees = 90f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
}