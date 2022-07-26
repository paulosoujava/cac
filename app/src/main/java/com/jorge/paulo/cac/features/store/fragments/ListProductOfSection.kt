package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppDeletePopUp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppSearchInput
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun ListSection(
    navigate: NavigateViewModel
) {

    val context = LocalContext.current
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val showPopUp = remember { mutableStateOf(false) }


    Box(modifier = Modifier.fillMaxSize()) {
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = rememberCollapsingToolbarScaffoldState(),
            scrollStrategy = ScrollStrategy.EnterAlways, // EnterAlways, EnterAlwaysCollapsed, ExitUntilCollapsed are available,
            toolbar = {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Black),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppToolbar(
                            modifier = Modifier.weight(4f),
                            onBack = { navigate.onNavigate(Fragments.STORE) },
                            title = "Seções"
                        )
                        AppButtons(
                            modifier = Modifier.weight(1f),
                            colorButton = Color.Transparent,
                            appICons = { AppIcons(appIcons = AppIconList.ADD) },
                            appButtons = AppButtonList.ICON, onClick = {
                                navigate.onNavigate(Fragments.EDIT_PRODUCT_SECTION)
                            })
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AppSearchInput(textState)
                    }
                }
            }
        ) {
            LazyColumn {
                items(120) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, start = 10.dp, end = 15.dp)
                            .clip(shape = RoundedCornerShape(10))
                            .background(Black.copy(alpha = .7f))
                            .padding(10.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(CircleShape)
                                .border(1.dp, Black.copy(alpha = .9f), shape = CircleShape)
                                .size(60.dp)
                        )
                        Column {
                            AppText(
                                appTextTypes = AppTextList.TITLE,
                                text = "Title",
                                color = LightGray
                            )
                            AppDivider(
                                modifier = Modifier.padding(10.dp),
                                color = Black.copy(alpha = .9f)
                            )

                            AppText(
                                appTextTypes = AppTextList.SMALL,
                                text = "Desc de  linhas Desc de  linhas Desc de  linhas Desc de  linhas Desc de  linhas ",
                                color = LightGray
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        top = 10.dp,
                                        bottom = 10.dp,
                                        end = 10.dp
                                    ),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AppText(
                                    appTextTypes = AppTextList.SMALL,
                                    text = "VALOR",
                                    color = LightGray
                                )
                            }

                            AppDivider(
                                modifier = Modifier.padding(
                                    start = 150.dp, top = 15.dp, bottom = 10.dp
                                ),
                                color = Black.copy(alpha = .9f)
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AppButtons(
                                    colorButton = Color.Transparent,
                                    appICons = {
                                        AppIcons(
                                            appIcons = AppIconList.DELETE,
                                            color = Red700
                                        )
                                    },
                                    appButtons = AppButtonList.ICON,
                                    onClick = { showPopUp.value = !showPopUp.value }
                                )
                                AppSpace(appSizes = AppSpaceList.MEDIUM)
                                AppButtons(
                                    colorButton = Color.Transparent,
                                    appICons = {
                                        AppIcons(
                                            appIcons = AppIconList.EDIT,
                                            color = Color.Green
                                        )
                                    },
                                    appButtons = AppButtonList.ICON,
                                    onClick = { navigate.onNavigate(Fragments.EDIT_PRODUCT_SECTION) }
                                )
                            }
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