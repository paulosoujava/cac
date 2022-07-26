package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.Red900

@Composable
fun AppDeletePopUp(
    onClose: () -> Unit,
    onConfirm: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(350.dp)
            .height(260.dp)
            .border(1.dp, Red900)
            .background(Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AppText(
                modifier = Modifier.padding(start = 15.dp).weight(3f),
                appTextTypes = AppTextList.TITLE,
                text = "Deletar",
                color = LightGray
            )
            AppButtons(
                modifier = Modifier.weight(1f),
                appICons = {
                    AppIcons(
                        appIcons = AppIconList.CLOSE,
                        color = LightGray
                    )
                },
                colorButton = Color.Transparent,
                appButtons = AppButtonList.ICON, onClick = { onClose() })
        }
        Divider(
            modifier = Modifier.padding( 15.dp),
            color = LightGray
        )
        AppText(
            appTextTypes = AppTextList.TITLE,
            text = "Você deseja deletar este item?",
            color = LightGray,
            modifier = Modifier.padding(bottom = 20.dp, top = 20.dp)
        )
        Divider(
            modifier = Modifier.padding(15.dp),
            color = LightGray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            AppButtons(
                modifier = Modifier.padding(10.dp),
                label = "Deletar",
                colorButton = Red700,
                appButtons = AppButtonList.DEFAULT,
                onClick = { onConfirm() })
        }
    }
}