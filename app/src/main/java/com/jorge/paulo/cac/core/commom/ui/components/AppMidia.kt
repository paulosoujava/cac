package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jorge.paulo.cac.core.commom.ui.theme.Black

@Composable
fun AppMidia(
    modifier: Modifier = Modifier,
    colorButton: Color = Black,
    appICons: AppIconList,
    onClick: () -> Unit
) {
    AppButtons(
        modifier = modifier,
        appButtons = AppButtonList.ICON,
        onClick = onClick,
        colorButton = colorButton,
        appICons = {
            AppIcons(appIcons = appICons)
        }
    )
}