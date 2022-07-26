package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDeletePopUp
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
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

@Composable
fun Challenge(
    navigate: NavigateViewModel
) {
    val showPopUp = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth().background(Black),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                AppToolbar(
                    modifier = Modifier.weight(4f),
                    onBack = { navigate.onNavigate(Fragments.HOME) },
                    title = "Desafios"
                )
                AppButtons(
                    modifier = Modifier.weight(1f),
                    colorButton = Color.Transparent,
                    appICons ={ AppIcons(appIcons = AppIconList.ADD)},
                    appButtons = AppButtonList.ICON, onClick = {
                        navigate.onNavigate(Fragments.EDIT_CHALLENGE_SECTION)  })
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive( minSize = 158.dp),
                modifier = Modifier.padding(it)
            ) {
                items(15) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(
                                    topStartPercent = 10,
                                    bottomStartPercent = 40,
                                    bottomEndPercent = 10,
                                    topEndPercent = 10
                                )
                            )
                            .clickable { }
                            .background(Black)

                    ) {
                        Column(
                            modifier = Modifier
                                .size(158.dp)
                                .padding(
                                    start = 19.dp,
                                    top = 20.dp,
                                    end = 5.dp,
                                    bottom = 10.dp
                                )
                        ) {
                            AppText(
                                modifier = Modifier.padding(bottom = 15.dp),
                                appTextTypes = AppTextList.BODY,
                                text = "Nome do Desafio"
                            )
                            AppText(
                                appTextTypes = AppTextList.SMALL,
                                maxLines = 2,
                                text = "descricao descricao descricao descricao descricao descricao descricao descricao descricao descricao descricao descricao ",
                                color = Color.LightGray
                            )
                            AppDivider(
                                modifier = Modifier
                                    .padding( 15.dp),
                                color = LightGray
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AppButtons(
                                    modifier = Modifier.size(35.dp),
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
                                    modifier = Modifier.size(35.dp),
                                    colorButton = Color.Transparent,
                                    appICons = {
                                        AppIcons(
                                            appIcons = AppIconList.EDIT,
                                            color = Color.Green
                                        )
                                    },
                                    appButtons = AppButtonList.ICON,
                                    onClick = {navigate.onNavigate(Fragments.EDIT_CHALLENGE_SECTION)   }
                                )
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

}