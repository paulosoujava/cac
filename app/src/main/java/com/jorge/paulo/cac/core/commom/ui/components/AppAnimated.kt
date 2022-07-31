package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable

@Composable
fun AppAnimated(visible: Boolean, animationTime: Int, slot: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(
            initialOffsetX = { it }, // it == fullWidth
            animationSpec = tween(
                durationMillis = animationTime,
                easing = LinearEasing
            )
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(
                durationMillis = animationTime,
                easing = LinearEasing
            )
        )
    ) {
        slot()
    }
}
