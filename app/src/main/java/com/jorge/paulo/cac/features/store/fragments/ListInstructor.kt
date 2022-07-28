package com.jorge.paulo.cac.features.store.fragments

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.jorge.paulo.cac.core.commom.ui.components.AppCArdWithOptions
import com.jorge.paulo.cac.core.commom.ui.components.AppCard
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
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
import com.jorge.paulo.cac.features.profile.ProfileActivity
import com.jorge.paulo.cac.features.profile.presentation.ProfileScreens
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments

const val MAX_CELLS_INSTRUCTOR = 2

@Composable
fun Instructor(
    navigate: NavigateViewModel,
    seeProfile: () -> Unit
) {
    val list = mapOf(
        AppIconList.PISTOL to "Paulo Jorge oliveira",
        AppIconList.SHARE to "Renata de Souza",
        AppIconList.PLACE to "Malu Machado"
    )
    val visible = remember { mutableStateOf(false) }
    var text = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppToolbar(
                onBack = {
                    navigate.onNavigate(Fragments.HOME)
                },
                title = "Instrutores"
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
                    text = "Cadastro de instrutores e acesso"
                )
                AppButtons(
                    label = if (visible.value) "Fechar" else "Novo",
                    colorBorderButton = Orange,
                    appButtons = AppButtonList.ROUNDED,
                    onClick = { visible.value = !visible.value })
            }
            AnimatedVisibility(visible = visible.value) {
                Box(
                    Modifier
                        .background(Black.copy(alpha = .9f)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {

                        AppInputDefault(
                            onValueChange = {
                                text.value = it
                            },
                            value = text.value,
                            label = "digite o email ",
                            keyboardType = KeyboardType.Email
                        )

                        AppSpace(appSizes = AppSpaceList.SMALL)

                        AppInputDefault(
                            onValueChange = {
                                text.value = it
                            },
                            value = text.value,
                            label = "digite o CPF ",
                            keyboardType = KeyboardType.Number
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
                text = "Instrutores"
            )
            AppText(
                modifier = Modifier.padding(start = 15.dp, bottom = 20.dp),
                appTextTypes = AppTextList.SMALL,
                color = LightGray,
                text = "Libere, bloqueia ou cadastre acesso a seus intrutores"
            )

            LazyColumn(
                contentPadding = it
            ) {
                items(120) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AppCArdWithOptions(
                            onInactive = { /*TODO*/ },
                            onActive = { /*TODO*/ }) {
                            seeProfile()
                        }
                    }
                }
            }
        }
    }
}