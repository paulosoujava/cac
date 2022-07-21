package com.jorge.paulo.cac.features.profile.presentation.instructor


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppBanner
import com.jorge.paulo.cac.core.commom.ui.components.AppBannerList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppChip
import com.jorge.paulo.cac.core.commom.ui.components.AppDefaultCard
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppMidia
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.components.IconWithText
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import kotlin.math.min

@Composable
fun ProfileInstructor(
    finish: () -> Unit
) {
    val scrollState = rememberScrollState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Black25)
                    .graphicsLayer {
                        alpha =
                            1f - ((scrollState.value.toFloat() / scrollState.maxValue) * 1.5f)
                        translationY = 0.5f * scrollState.value
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        AppButtons(
                            appICons = { AppIcons(appIcons = AppIconList.BACK) },
                            appButtons = AppButtonList.ICON, onClick = { finish() },
                            colorButton = Black25
                        )

                        AppText(
                            appTextTypes = AppTextList.TITLE,
                            text = "Paulo Jorge de Oliveira"
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Black)
                            .clip(
                                RoundedCornerShape(50),
                            )
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = R.drawable.bg),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(120.dp)
                                .clip(RoundedCornerShape(10))
                        )
                    }

                }
            }
            Column(
                Modifier
                    .background(Black25)
                    .padding(10.dp)
            ) {
                AppSpace(appSizes = AppSpaceList.MEDIUM)
                IconWithText(
                    appICons = AppIconList.PLACE,
                    text = "Habilitação: ",
                )
                Container {
                    repeat(2) {
                        Row {
                            AppChip(
                                text = "fuzil",
                                color = LightGray,
                                labelColor = Black,
                            )
                            AppChip(
                                text = "fuzil",
                                color = LightGray,
                                labelColor = Black,
                            )
                            AppChip(
                                text = "fuzil",
                                color = LightGray,
                                labelColor = Black,
                            )
                            AppChip(
                                text = "fuzil",
                                color = LightGray,
                                labelColor = Black,
                            )
                        }
                    }
                    AppDivider(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 40.dp),
                        color = Black.copy(alpha = .7f)
                    )
                }

                IconWithText(
                    appICons = AppIconList.CONTACTS,
                    text = "Perfil"
                )
                AppSpace(appSizes = AppSpaceList.MEDIUM)
                Container {
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description ",
                        color = LightGray,
                        maxLines = 10,
                    )
                    AppDivider(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 40.dp),
                        color = Black.copy(alpha = .7f)
                    )
                }

                IconWithText(
                    appICons = AppIconList.CONTACTS,
                    text = "Cursos que Ministro"
                )
                AppSpace(appSizes = AppSpaceList.MEDIUM)

                LazyRow {
                    items(5) {
                        Card(
                            elevation = Elevations.DEFAULT.size,
                            backgroundColor = Black.copy(alpha = .6f),
                            shape = RoundedCornerShape(5),
                            modifier = Modifier
                                .size(320.dp, 350.dp)
                                .padding(end = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    bottom = 15.dp,
                                    start = 15.dp,
                                    end = 15.dp
                                )
                            ) {
                                AppDefaultCard(
                                    title = "PISTOLA 1",
                                    desc = "linha 01\n" +
                                            "linha 02\n" +
                                            "linha 03\n" +
                                            "linha 04\n" +
                                            "linha 05\n" +
                                            "linha 06\n" +
                                            "linha 07\n" +
                                            "linha 08\n" +
                                            "linha 09\n" +
                                            "linha 10\n",
                                )
                            }

                        }

                    }
                }

                AppDivider(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp, end = 40.dp),
                    color = Black.copy(alpha = .7f)
                )

                IconWithText(
                    appICons = AppIconList.CONTACTS,
                    text = "Certificações"
                )

                Container(modifier = Modifier.background(Black.copy(alpha = .7f))) {
                    AppSpace(appSizes = AppSpaceList.MEDIUM)
                    AppBanner(
                        countPage = 3,
                        appBanner = AppBannerList.IMAGE,
                        hasBackground = false,
                        onClick = { }
                    )

                }
                Container {
                    AppDivider(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 40.dp),
                        color = Black.copy(alpha = .7f)
                    )
                }

                IconWithText(
                    appICons = AppIconList.CONTACTS,
                    text = "Vendo ou troco"
                )
                Container {
                    LazyRow {
                        items(5) {
                            Box(
                                Modifier
                                    .size(320.dp, 320.dp)
                                    .padding(end = 8.dp)
                            ) {
                                AppDefaultCard(
                                    title = "G2C",
                                    desc = "linha 01\n" +
                                            "linha 02\n" +
                                            "linha 03\n" +
                                            "linha 04\n" +
                                            "linha 05\n" +
                                            "linha 06\n" +
                                            "linha 07\n" +
                                            "linha 08\n" +
                                            "linha 09\n" +
                                            "linha 10\n",
                                    prizeValue = "R$:12.00"
                                )
                            }

                        }
                    }
                    AppDivider(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 40.dp),
                        color = Black.copy(alpha = .7f)
                    )
                }

                IconWithText(
                    appICons = AppIconList.CONTACTS,
                    text = "Contatos & Mídias"
                )
                AppSpace(appSizes = AppSpaceList.MEDIUM)
                Container {
                    RowContainer {
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.WHATS,
                            onClick = {}
                        )
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.SITE,
                            onClick = {}
                        )
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.LINKEDIM,
                            onClick = {}
                        )

                    }
                    RowContainer {
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.PHONE,
                            onClick = {}
                        )
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.EMAIL,
                            onClick = {}
                        )
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.YOUTUBE,
                            onClick = {}
                        )

                    }
                    RowContainer {
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.INSTAGRAM,
                            onClick = {}
                        )
                        AppMidia(
                            modifier = Modifier.weight(1f),
                            appICons = AppIconList.FACEBOOK,
                            onClick = {}
                        )

                    }
                    AppDivider(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 40.dp),
                        color = Black.copy(alpha = .7f)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .alpha(
                    min(
                        1f,
                        (scrollState.value.toFloat() / scrollState.maxValue) * 9f
                    )
                )
                .fillMaxWidth()
                .height(70.dp)
        ) {

            AppToolbar(
                onBack = {
                    finish()
                },
                title = "Paulo Jorge de Oliveira"
            )
        }
    }
}

@Composable
fun RowContainer(
    slot: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(10.dp)
    ) {
        slot()
    }
}

@Composable
fun Container(
    modifier: Modifier = Modifier,
    slot: @Composable () -> Unit
) {
    Column(modifier.padding(start = 20.dp, end = 20.dp)) {
        slot()
    }

}



