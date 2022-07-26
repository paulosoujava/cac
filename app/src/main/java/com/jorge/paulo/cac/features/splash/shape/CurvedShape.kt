package com.jorge.paulo.cac.features.splash.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class CurvedShape(private val type: CurveType) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = when(type){
                 CurveType.LTR -> {ltrCurve(size)}
                 CurveType.RTL -> {rtlCurve(size)}
            }
        )
    }
}

class CurvedShape2(private val type: CurveType) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = when(type){
                CurveType.LTR -> {ltrCurve(size)}
                CurveType.RTL -> {rtlCurve(size)}
            }
        )
    }
}