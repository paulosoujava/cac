package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Sections

@Composable
fun Administrator(
    navigate: NavigateViewModel
) {

    val name = remember { mutableStateOf("") }
    val cpf = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppToolbar(
                onBack = { navigate.onNavigate(Sections.HOME) },
                title = "Aministrador"
            )
        }
    ) { padding ->
        Column(
            Modifier.padding(
                top = padding.calculateTopPadding(),
                end = 10.dp,
                start = 10.dp
            )
        ) {

            AppSpace(appSizes = AppSpaceList.SMALL)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppIcons(appIcons = AppIconList.INFO, color = LightGray)
            }
            AppText(
                modifier = Modifier.padding(20.dp),
                appTextTypes = AppTextList.SMALL,
                maxLines = 10,
                text = "Estes dados são privados, e se tratam de dados do administrador do app.\n" +
                        "A responsabilidade do conteúdo cadastrado no app, referente ao seu estande é exclusiva sua.",
                color = LightGray
            )

            Divider(Modifier.padding(top = 40.dp, bottom = 20.dp), color = LightGray)

            AppInputDefault(
                onValueChange = {
                    name.value = it
                },
                value = name.value,
                label = "Nome completo ",
                keyboardType = KeyboardType.Text
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            AppInputDefault(
                onValueChange = {
                    cpf.value = it
                },
                value = cpf.value,
                label = "CPF",
                keyboardType = KeyboardType.Text
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            AppInputDefault(
                onValueChange = {
                    email.value = it
                },
                value = email.value,
                label = "Email",
                keyboardType = KeyboardType.Email
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            AppInputDefault(
                onValueChange = {
                    phone.value = it
                },
                value = phone.value,
                label = "Celular com ddd",
                keyboardType = KeyboardType.Phone
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                AppButtons(
                    colorButton = Green,
                    label = "Cadastrar",
                    appButtons = AppButtonList.DEFAULT,
                    onClick = { /*TODO*/ })
            }
        }
    }

}