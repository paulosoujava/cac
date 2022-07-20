package com.jorge.paulo.cac.core.commom.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(50.dp)
)

enum class Elevations(val size: Dp){
    DEFAULT(12.dp)
}
