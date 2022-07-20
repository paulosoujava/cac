package com.jorge.paulo.cac.features.timeline.presentation.timelines.inutilizados_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray

@Composable
fun Status() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppText(
            appTextTypes = AppTextList.BODY,
            text = "Obrigado por efetuar se cadastro.",
            color = Green
        )
        AppText(
            appTextTypes = AppTextList.SMALL,
            maxLines = 5,
            text = "Seu acesso será liberado pelo clube ao qual você é afiliado.\n" +
                    "Em caso de dúvidas, entre em contato com seu estande.",
            color = LightGray
        )
        AppDivider(
            modifier = Modifier.padding(25.dp),
            color = LightGray.copy(alpha = .7f)
        )
        AppText(appTextTypes = AppTextList.BODY, text = "Status:", color = LightGray)
        AppText(appTextTypes = AppTextList.BODY, text = "Em Análise", color = LightGray)
    }
}