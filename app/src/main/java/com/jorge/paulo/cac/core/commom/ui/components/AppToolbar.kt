package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.White

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    title: String
) {

    TopAppBar(
        modifier = modifier,
        contentColor = Black,
        elevation = 8.dp
    ) {
        AppButtons(
            appICons = { AppIcons(appIcons = AppIconList.BACK) },
            appButtons = AppButtonList.ICON, onClick = { onBack() },
            colorButton = Black
        )

        AppText(
            appTextTypes = AppTextList.TITLE,
            text = title,
            color = White
        )
    }
}