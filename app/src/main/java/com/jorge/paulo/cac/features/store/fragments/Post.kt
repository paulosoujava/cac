package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppDeletePopUp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun Post(navigate: NavigateViewModel) {
    val visible = remember { mutableStateOf(true) }
    val text = remember { mutableStateOf("") }
    val maxChar = 31
    val showPopUp = remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = rememberCollapsingToolbarScaffoldState(),
            scrollStrategy = ScrollStrategy.EnterAlways, // EnterAlways, EnterAlwaysCollapsed, ExitUntilCollapsed are available,
            toolbar = {
                Column {
                    AppToolbar(
                        onBack = {
                            navigate.onNavigate(Fragments.HOME)
                        },
                        title = "Post"
                    )
                    Row(
                        modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppText(
                            modifier = Modifier.weight(4f),
                            appTextTypes = AppTextList.SMALL,
                            text = if (visible.value) "* apenas 250 caracteres" else "Mostrar formulário",
                            color = LightGray
                        )
                        AppButtons(
                            modifier = Modifier.weight(1f),
                            appICons = {
                                AppIcons(
                                    appIcons = if (visible.value) AppIconList.ARROW_UP else AppIconList.ARROW_DOWN,
                                    color = Orange
                                )
                            },
                            colorButton = Color.Transparent,
                            appButtons = AppButtonList.ICON,
                            onClick = {
                                visible.value = !visible.value
                            })
                    }
                    if (visible.value) {
                        OutlinedTextField(
                            value = text.value,
                            onValueChange = { it ->
                                //text.value = it
                                if (it.length <= maxChar) text.value = it
                            },
                            textStyle = TextStyle(
                                color = White
                            ),
                            label = {
                                AppText(
                                    appTextTypes = AppTextList.SMALL,
                                    text = "escreva seu post",
                                    color = White
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                cursorColor = White,
                                focusedBorderColor = LightGray,
                                unfocusedBorderColor = White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            AppText(
                                appTextTypes = AppTextList.SMALL,
                                text = "${text.value.length} / $maxChar",
                                color = if (text.value.length == maxChar) Red700 else LightGray
                            )
                            AppButtons(
                                appICons = {
                                    AppIcons(
                                        appIcons = AppIconList.EDIT,
                                        color = White
                                    )
                                },
                                colorButton = Color.Transparent,
                                appButtons = AppButtonList.ICON,
                                onClick = { /*TODO*/ })
                        }
                        AppSpace(appSizes = AppSpaceList.SMALL)
                    }
                }

            }
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {


                AppText(
                    color = LightGray,
                    appTextTypes = AppTextList.TITLE,
                    maxLines = 10,
                    text = "Posts:"
                )
                Divider(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        start = 15.dp,
                        end = 15.dp,
                        bottom = 10.dp,

                        )
                )
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    repeat(10) {
                        ItemPost(onEdit = {}, onDelete = {
                            showPopUp.value =! showPopUp.value
                        })
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (showPopUp.value) Black.copy(.9f) else Color.Transparent
                ),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(visible = showPopUp.value) {
                AppDeletePopUp(onClose = { showPopUp.value = !showPopUp.value }) {
                }
            }
        }
    }
}

@Composable
 private fun ItemPost(
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    Column {
        AppText(
            color = LightGray,
            appTextTypes = AppTextList.SMALL,
            maxLines = 10,
            text = "A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado na produção gráfica para preencher os espaços de texto em publicações para testar e ajustar aspectos visuais antes de utilizar conteúdo real."
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppButtons(
                appICons = {
                    AppIcons(
                        appIcons = AppIconList.DELETE,
                        color = Red700
                    )
                },
                colorButton = Color.Transparent,
                appButtons = AppButtonList.ICON,
                onClick = { onDelete() })

            AppButtons(
                appICons = {
                    AppIcons(
                        appIcons = AppIconList.EDIT,
                        color = Green
                    )
                },
                colorButton = Color.Transparent,
                appButtons = AppButtonList.ICON,
                onClick = { onEdit() })
        }
        Divider(
            modifier = Modifier.padding(
                top = 10.dp,
                start = 15.dp,
                end = 15.dp,
                bottom = 10.dp,

                )
        )
    }
}