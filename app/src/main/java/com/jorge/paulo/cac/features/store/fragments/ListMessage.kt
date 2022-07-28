package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDefault3Input
import com.jorge.paulo.cac.core.commom.ui.components.AppDeletePopUp
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppSelectedItem
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
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
fun Message(
    navigate: NavigateViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val showPopList = remember { mutableStateOf(false) }
        val showPopListMessage = remember { mutableStateOf(false) }
        val showPopUpDelete = remember { mutableStateOf(false) }
        val visible = remember { mutableStateOf(true) }
        val text = remember { mutableStateOf("") }
        val maxChar = 31

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Black),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppToolbar(
                        modifier = Modifier.weight(4f),
                        onBack = {
                            navigate.onNavigate(Fragments.HOME)
                        },
                        title = "Mensagems"
                    )
                    AppButtons(
                        modifier = Modifier.weight(1f),
                        colorButton = Color.Transparent,
                        appICons = { AppIcons(appIcons = AppIconList.LIST_MESSAGE) },
                        appButtons = AppButtonList.ICON, onClick = {
                            showPopListMessage.value = !showPopListMessage.value
                        })
                }
            },
            bottomBar = {
                Column(Modifier.background(Black.copy(.4f))) {
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

                        AppText(
                            appTextTypes = AppTextList.SMALL,
                            text = "Mensagem tipo: PUSH NOTIFICATION",
                            color = Green
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
                                .padding(start = 10.dp, end = 10.dp)
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
                Modifier.padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = it.calculateBottomPadding()
                ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                AppText(appTextTypes = AppTextList.TITLE, text = "Selecione o destinatário")

                AppSelectedItem(
                    selected = false, label = "TODOS SOCIOS", width = 240,
                    leftOrRight = false
                ) {}
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppSelectedItem(
                        selected = false,
                        label = "TODOS INSTRUTORES",
                        width = 240
                    ) {}
                }

                AppSelectedItem(
                    selected = false, label = "AMBOS", width = 240,
                    leftOrRight = false
                ) {}

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppButtons(
                        modifier = Modifier.width(250.dp),
                        colorButton = Black,
                        label = "SELECIONAR ",
                        appButtons = AppButtonList.DEFAULT,
                        onClick = {
                            showPopList.value = !showPopList.value
                        })
                }

                AnimatedVisibility(visible = true) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 75.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppIcons(appIcons = AppIconList.ALERT, color = Orange)
                        AppText(
                            modifier = Modifier.width(200.dp),
                            appTextTypes = AppTextList.SMALL,
                            maxLines = 3,
                            text = "Somente estandes podem ver este alerta adicionado a este usuário",
                            color = Orange
                        )
                    }
                }

            }
        }

        AnimatedVisibility(visible = showPopList.value) {
            CollapsingToolbarScaffold(
                modifier = Modifier.background(Black),
                state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
                scrollStrategy = ScrollStrategy.EnterAlways, // EnterAlways, EnterAlwaysCollapsed, ExitUntilCollapsed are available,
                toolbar = {
                    Column(Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppText(
                                modifier = Modifier.weight(3f),
                                appTextTypes = AppTextList.TITLE, text = "SELECIONE UM USUÁRIO"
                            )

                            AppButtons(
                                colorButton = Black,
                                appICons = {
                                    AppIcons(
                                        appIcons = AppIconList.CLOSE,
                                        color = LightGray
                                    )
                                },
                                appButtons = AppButtonList.ICON, onClick = {
                                    showPopList.value = showPopList.value.not()
                                }
                            )
                        }


                        Divider(
                            modifier = Modifier.padding(10.dp),
                            color = LightGray.copy(.5f)
                        )
                    }
                }
            ) {
                LazyColumn(modifier = Modifier.padding(10.dp)) {
                    items(10) {
                        Card(
                            modifier = Modifier.padding(10.dp),
                            elevation = Elevations.DEFAULT.size,
                            backgroundColor = Black25,
                            shape = RoundedCornerShape(
                                topStartPercent = 50,
                                bottomStartPercent = 90,
                                topEndPercent = 90,
                                bottomEndPercent = 10
                            )
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Image(
                                    modifier = Modifier
                                        .size(90.dp)
                                        .border(
                                            3.dp,
                                            color = LightGray,
                                            shape = RoundedCornerShape(50)
                                        )
                                        .clip(RoundedCornerShape(50)),
                                    painter = painterResource(id = R.drawable.placeholder),
                                    contentDescription = null
                                )
                                Column(
                                    Modifier.weight(3f),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.Center

                                ) {
                                    AppText(
                                        modifier = Modifier.padding(8.dp),
                                        color = LightGray,
                                        appTextTypes = AppTextList.TITLE,
                                        text = "NOME DO BOY"
                                    )
                                    Divider(
                                        modifier = Modifier.padding(top = 15.dp), color = LightGray
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AppButtons(
                                            colorButton = Black,
                                            appICons = {
                                                AppIcons(
                                                    appIcons = AppIconList.ALERT,
                                                    color = Orange
                                                )
                                            },
                                            appButtons = AppButtonList.ICON, onClick = { /*TODO*/ }
                                        )
                                        AppButtons(
                                            colorButton = Black,
                                            appICons = {
                                                AppIcons(
                                                    appIcons = AppIconList.MESSAGE,
                                                    color = Green
                                                )
                                            },
                                            appButtons = AppButtonList.ICON, onClick = { /*TODO*/ }
                                        )
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }


        AnimatedVisibility(visible = showPopListMessage.value) {
            Box {
                CollapsingToolbarScaffold(
                    modifier = Modifier.background(Black),
                    state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
                    scrollStrategy = ScrollStrategy.EnterAlways, // EnterAlways, EnterAlwaysCollapsed, ExitUntilCollapsed are available,
                    toolbar = {
                        Column(Modifier.padding(10.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AppText(
                                    modifier = Modifier.weight(3f),
                                    appTextTypes = AppTextList.TITLE, text = "Mensagens enviadas"
                                )

                                AppButtons(
                                    colorButton = Black,
                                    appICons = {
                                        AppIcons(
                                            appIcons = AppIconList.CLOSE,
                                            color = LightGray
                                        )
                                    },
                                    appButtons = AppButtonList.ICON, onClick = {
                                        showPopListMessage.value = !showPopListMessage.value
                                    }
                                )
                            }
                            Divider(
                                modifier = Modifier.padding(10.dp),
                                color = LightGray.copy(.5f)
                            )
                        }
                    }
                ) {
                    LazyColumn(Modifier.padding(10.dp)) {
                        items(10) {
                            ItemMessage(onDelete = {
                                showPopUpDelete.value = !showPopUpDelete.value
                            })
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (showPopUpDelete.value) Black.copy(.9f) else Color.Transparent
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedVisibility(visible = showPopUpDelete.value) {
                        AppDeletePopUp(onClose = {
                            showPopUpDelete.value = !showPopUpDelete.value
                        }
                        ) {}
                    }
                }
            }
        }
    }
}


@Composable
fun ItemMessage(
    onDelete: () -> Unit
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
        }
        Divider(
            modifier = Modifier.padding(
                top = 10.dp,
                start = 15.dp,
                end = 15.dp,
                bottom = 15.dp,
            ),
            color = LightGray.copy(.5f)
        )
    }
}