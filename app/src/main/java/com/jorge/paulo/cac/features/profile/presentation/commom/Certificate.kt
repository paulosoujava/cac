package com.jorge.paulo.cac.features.profile.presentation.cac

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDeletePopUp
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.domain.Fragments
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun Certificate(
    onBack: () -> Unit
) {
    val visible = remember { mutableStateOf(true) }
    val showPopUp = remember { mutableStateOf(false) }

    val title = " Certificado"
    Box(modifier = Modifier.fillMaxSize()) {
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
            scrollStrategy = ScrollStrategy.EnterAlways, // EnterAlways, EnterAlwaysCollapsed, ExitUntilCollapsed are available,
            toolbar = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AppToolbar(
                        onBack = onBack,
                        title = "Certificado"
                    )
                    AppIcons(
                        modifier = Modifier.padding(top = 20.dp),
                        appIcons = AppIconList.ALERT, color = Orange
                    )
                    AppText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp),
                        appTextTypes = AppTextList.SMALL,
                        maxLines = 4,
                        text = "Os itens cadastrados aqui, serão visiveis SOMENTE aos: Estande, e orgãos da segurança publica",
                        color = Orange
                    )
                    Row(
                        modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppText(
                            modifier = Modifier.weight(4f),
                            appTextTypes = AppTextList.SMALL,
                            text = if (visible.value) "Fechar $title" else "Mostrar $title",
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
                    AnimatedVisibility(visible = visible.value) {
                        Box(
                            Modifier
                                .padding(start = 10.dp, end = 10.dp)
                                .clip(RoundedCornerShape(5))
                                .background(Black.copy(alpha = .9f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            ) {

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .size(200.dp)
                                        .clickable { },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.placehold_image),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop
                                    )
                                    Box(
                                        modifier = Modifier
                                            .padding(
                                                top = 110.dp,
                                                start = 170.dp
                                            )
                                            .clip(RoundedCornerShape(30))
                                            .background(Black)
                                            .padding(5.dp)
                                    ) {
                                        AppIcons(appIcons = AppIconList.CAMERA, color = White)
                                    }

                                }

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
                }

            }
        ) {

            LazyColumn {
                items(5) {

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(10)
                            )
                            .background(Color.LightGray),
                    ) {
                        AsyncImage(
                            model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(
                                    RoundedCornerShape(10)
                                )
                                .border(
                                    1.dp, LightGray, shape = RoundedCornerShape(10)
                                )
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(end = 20.dp, bottom = 10.dp),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppButtons(
                                colorButton = Black,
                                appICons = {
                                    AppIcons(
                                        appIcons = AppIconList.DELETE,
                                        color = Red700
                                    )
                                },
                                appButtons = AppButtonList.ICON,
                                onClick = { showPopUp.value = !showPopUp.value })
                        }
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