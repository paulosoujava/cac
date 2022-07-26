package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppCard
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.components.CardList
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments

const val MAX_CELLS_SECTION = 2

@Composable
fun Section(navigate: NavigateViewModel) {
    val list = mapOf(
        AppIconList.PISTOL to "Armas",
        AppIconList.SHARE to "Roupas",
        AppIconList.PLACE to "Acessórios"
    )

    val visible = remember { mutableStateOf(false) }
    val text = remember { mutableStateOf(TextFieldValue("")) }


    Scaffold(
        topBar = {
            AppToolbar(
                onBack = {
                    navigate.onNavigate(Fragments.HOME)
                },
                title = "Loja"
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                AppText(
                    appTextTypes = AppTextList.BODY,
                    text = "Crie aqui seções de lojas"
                )
                AppButtons(
                    label = if (visible.value) "Fechar" else "Criar uma seção",
                    colorBorderButton = Orange,
                    appButtons = AppButtonList.ROUNDED,
                    onClick = { visible.value = !visible.value })
            }
            AnimatedVisibility(visible = visible.value) {
                Box(Modifier
                    .background(Black.copy(alpha = .9f)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {

                        OutlinedTextField(
                            value = text.value,
                            onValueChange = {
                                text.value = it
                            },
                            textStyle = TextStyle(
                                color = White
                            ),
                            label = {
                                AppText(
                                    appTextTypes = AppTextList.SMALL,
                                    text = "Nome da seção",
                                    color = White
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                cursorColor = White,
                                focusedBorderColor = LightGray,
                                unfocusedBorderColor = White
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        AppSpace(appSizes = AppSpaceList.SMALL)
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
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

            AppDivider(
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 25.dp,
                    bottom = 25.dp,
                    end = 10.dp
                ),
                color = Black.copy(alpha = .7f)
            )
            AppText(
                modifier = Modifier.padding(start = 15.dp),
                appTextTypes = AppTextList.TITLE,
                text = "Seções"
            )
            AppText(
                modifier = Modifier.padding(start = 15.dp, bottom = 20.dp),
                appTextTypes = AppTextList.SMALL,
                color = LightGray,
                text = "edite, delete os itens das seções abaixo"
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(MAX_CELLS),
                contentPadding = it
            ) {
                items(list.toList()) { section ->
                    AppCard(
                        modifier = Modifier.clickable { },
                        label = section.second,
                        icon = section.first,
                        cardList = CardList.DEFAULT,
                        onClick = {
                            navigate.onNavigate(Fragments.LIST_STORE_SECTION)
                        }
                    )
                }
            }
        }
    }
}