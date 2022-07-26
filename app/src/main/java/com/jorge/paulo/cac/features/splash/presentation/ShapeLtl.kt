package com.jorge.paulo.cac.features.splash.presentation

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path


fun ltrCurve(size: Size) = Path().apply {
    reset()
    val width = size.width
    val height = size.height
    val radius = 100f
    val upShift = height * (1f - 0.2f)
    // arc C1
    arcTo(
        rect = Rect(
            left = 0f,
            top = 0f,
            right = radius * 2,
            bottom = radius * 2
        ),
        startAngleDegrees = 180f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
    // line C1 to C2
    lineTo(width - radius, 0f)
    // arc C2
    arcTo(
        rect = Rect(
            left = width - radius * 2,
            top = 0f,
            right = width,
            bottom = radius * 2
        ),
        startAngleDegrees = 270f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
    // line C2 to C3
    lineTo(width, height - (radius * 2))
    // arc C3
    arcTo(
        rect = Rect(
            left = width - radius * 2,
            top = height - (radius * 2),
            right = width,
            bottom = height
        ),
        startAngleDegrees = 0f,
        sweepAngleDegrees = 115f,
        forceMoveTo = false
    )
    // arc C4
    arcTo(
        rect = Rect(
            left = 0f,
            top = upShift - radius * 2,
            right = radius * 2,
            bottom = upShift
        ),
        startAngleDegrees = 115f,
        sweepAngleDegrees = 65f,
        forceMoveTo = false
    )
}