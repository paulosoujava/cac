package com.jorge.paulo.cac.features.profile.presentation.cac

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppBanner
import com.jorge.paulo.cac.core.commom.ui.components.AppBannerList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppMidia
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionWrapper
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.IconWithText
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White

@Composable
fun ProfileCacRead(
    finish: () -> Unit,
) {
    val showAlert = remember {
        mutableStateOf(false)
    }
    Scaffold() {
        Card(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(0)
        ) {

            Column {
                Row(
                    modifier = Modifier
                        .background(Black),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    AppButtons(
                        appICons = { AppIcons(appIcons = AppIconList.BACK) },
                        appButtons = AppButtonList.ICON, onClick = { finish() },
                        colorButton = Black
                    )
                    AsyncImage(
                        model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                        placeholder = painterResource(R.drawable.placeholder),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(CircleShape)
                            .border(1.dp, Orange, shape = CircleShape)
                            .size(50.dp)
                    )

                    Column(Modifier.padding(15.dp)) {
                        AppText(
                            appTextTypes = AppTextList.TITLE,
                            text = "Paulo Jorge",
                            color = White,
                            modifier = Modifier.padding(top = 10.dp)
                        )

                        AppDivider(
                            Modifier
                                .padding(top = 10.dp, bottom = 10.dp),
                            color = Black25
                        )
                    }
                }
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .background(Black25)
                        .padding(15.dp)
                ) {


                    AppSectionWrapper(
                        titleSection = "Alertas",
                        isShow = showAlert.value,
                        hasButton = false,
                        onShow = { showAlert.value = !showAlert.value }) {
                        Column {
                            AppText(
                                modifier = Modifier.padding(top=1.dp, bottom = 25.dp),
                                appTextTypes = AppTextList.SMALL,
                                text = "Somente os estandes tem acesso a estas mensagens."
                            )
                            repeat(4) {
                                Column {
                                    AppText(
                                        color = LightGray,
                                        appTextTypes = AppTextList.SMALL,
                                        maxLines = 10,
                                        text = "A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado na produção gráfica para preencher os espaços de texto em publicações para testar e ajustar aspectos visuais antes de utilizar conteúdo real."
                                    )
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
                        }
                    }


                    AppDivider(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp),
                        color = LightGray
                    )
                    IconWithText(
                        appICons = AppIconList.CONTACTS,
                        text = "Contatos & Mídias"
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(10.dp)
                    ) {
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(10.dp)
                    ) {
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(10.dp)
                    ) {
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
                            .padding(top = 20.dp, bottom = 20.dp),
                        color = LightGray
                    )
                    IconWithText(
                        appICons = AppIconList.CONTACTS,
                        text = "Certificações"
                    )
                    AppBanner(
                        widthImage = 400,
                        countPage = 3,
                        appBanner = AppBannerList.IMAGE,
                        onClick = { }
                    )
                    AppSpace(appSizes = AppSpaceList.LARGE)
                }
            }
        }
    }
}
