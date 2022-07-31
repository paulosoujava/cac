package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White

@Composable
 fun AppContentModal(
    title: String,
    message: String,
    label: String,
    colorButton: Color = Red700,
    onCloseClick: () -> Unit,
    onActionClick: () -> Unit,
) {
    Column(
        Modifier
            .height(400.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                modifier = Modifier.weight(4f),
                appTextTypes = AppTextList.TITLE,
                color = White,
                text = title
            )
            AppButtons(
                modifier = Modifier.weight(1f),
                colorButton = Color.Transparent,
                colorLabel = White,
                appButtons = AppButtonList.ICON,
                appICons = { AppIcons(appIcons = AppIconList.CLOSE, color = LightGray) },
                onClick = { onCloseClick() })
        }

        AppDivider(
            Modifier.padding(10.dp)
        )
        AppText(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp),
            appTextTypes = AppTextList.BODY,
            maxLines = 10,
            color = LightGray,
            text = message
        )
        AppDivider(
            Modifier.padding(10.dp)
        )
        AppButtons(
            appButtons = AppButtonList.DEFAULT,
            onClick = { onActionClick() },
            colorButton = colorButton,
            label = label
        )
    }
}