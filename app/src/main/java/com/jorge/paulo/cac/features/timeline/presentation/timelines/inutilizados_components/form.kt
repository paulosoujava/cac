package com.jorge.paulo.cac.features.timeline.presentation.timelines.inutilizados_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
import com.jorge.paulo.cac.core.commom.ui.components.AppInputEmail
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes

@Composable
fun Form(
    onClick: () -> Unit
) {

    var valueEmail by remember { mutableStateOf("") }
    var valueName by remember { mutableStateOf("") }
    var valueCpf by remember { mutableStateOf("") }

    Card(
        elevation = 12.dp,
        contentColor = Black50
    ) {
        Column(
            Modifier
                .padding(10.dp)
                .clip(Shapes.small)
                .background(Black50),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AppText(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                appTextTypes = AppTextList.TITLE,
                maxLines = 3,
                text = "Informe os campos abaixo:"
            )
            AppInputDefault(
                onValueChange = { valueName = it },
                value = valueName,
                label = "Seu nome"
            )
            AppInputDefault(
                onValueChange = { valueCpf = it },
                value = valueCpf,
                label = "cpf"
            )
            AppInputEmail(
                onValueChange = { valueEmail = it },
                valueEmail
            )

            AppSpace(appSizes = AppSpaceList.MEDIUM)
            AppButtons(
                appButtons = AppButtonList.DEFAULT,
                label = "Cadastrar",
                onClick = {
                    onClick()
                }
            )

            AppSpace(appSizes = AppSpaceList.LARGE)

        }
    }
}