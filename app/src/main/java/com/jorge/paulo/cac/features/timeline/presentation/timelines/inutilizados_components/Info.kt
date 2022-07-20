package com.jorge.paulo.cac.features.timeline.presentation.timelines.inutilizados_components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes

@Composable
fun Info(
    onClickable: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AppText(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            appTextTypes = AppTextList.BODY,
            maxLines = 2,
            text = "Por favor, informe seu estande",
            color = LightGray
        )
        Row(
            modifier = Modifier
                .clip(Shapes.small)
                .border(1.dp, LightGray.copy(alpha = .7f), shape = Shapes.small)
                .size(220.dp, 40.dp)
                .clickable {
                    onClickable()
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .weight(4f)
                    .padding(start = 10.dp)
            ) {
                AppText(
                    appTextTypes = AppTextList.SMALL,
                    text = "Selecione seu estande",
                    color = LightGray.copy(alpha = .7f)
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                AppIcons(
                    appIcons = AppIconList.ARROW_DROP_DOWN,
                    color = LightGray.copy(alpha = .7f)
                )
            }
        }
        AppDivider(
            modifier = Modifier.padding(25.dp),
            color = Black.copy(alpha = .7f)
        )
        AppText(
            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 5.dp),
            appTextTypes = AppTextList.BODY,
            maxLines = 3,
            text = "Não encontrou?\n" +
                    "Compartilhe este app, com o estande ao qual você é afiliado.\n" +
                    "Para assim você ter acesso completo ao app.",
            color = LightGray
        )
        AppButtons(
            label = "Compartilhar",
            appButtons = AppButtonList.DEFAULT, onClick = { /*TODO*/ })

    }
}