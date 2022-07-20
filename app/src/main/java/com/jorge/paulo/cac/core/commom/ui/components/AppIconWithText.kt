package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IconWithText(
    appICons: AppIconList,
    text: String,
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AppIcons(appIcons = appICons, modifier = Modifier.padding(end = 10.dp))
            AppText(appTextTypes = AppTextList.TITLE, text = text)

        }
        AppSpace(appSizes = AppSpaceList.MEDIUM)
    }

}