package com.jorge.paulo.cac.features.profile.presentation.store

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppAlert
import com.jorge.paulo.cac.core.commom.ui.components.AppAlertList
import com.jorge.paulo.cac.core.commom.ui.components.AppBanner
import com.jorge.paulo.cac.core.commom.ui.components.AppBannerList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppDefaultCard
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppImage
import com.jorge.paulo.cac.core.commom.ui.components.AppMidia
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.components.IconWithText


import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.Red800
import com.jorge.paulo.cac.core.commom.ui.theme.Red900
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.fragments.TypeModal
import kotlinx.coroutines.launch
import kotlin.math.min

enum class TypeModalHome {
    REPORT,
    INSCRIPTION,
    NONE
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileStore(
    finish: () -> Unit,
    onProduct: () -> Unit,
    onInstructor: () -> Unit,
) {
    val viewModel: ProfileStoreViewModel = hiltViewModel()
    val stateAlert = viewModel.state.collectAsState()
    val scrollState = rememberScrollState()

    val type = remember { mutableStateOf(TypeModalHome.NONE) }
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()


    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topEndPercent = 10, topStartPercent = 10),
        sheetState = state,
        sheetBackgroundColor = Black,
        scrimColor = Black.copy(alpha = .6f),
        sheetContent = {
            when (type.value) {
                TypeModalHome.REPORT -> {
                    ContentModalHome(
                        type.value,
                        "Reportar este usuário",
                        "Texto explicativo Texto explicativo Texto explicativo Texto explicativoTexto explicativo Texto explicativo Texto explicativo Texto explicativoTexto explicativo Texto explicativo Texto explicativo Texto explicativoTexto explicativo Texto explicativo Texto explicativo Texto explicativoTexto explicativo Texto explicativo Texto explicativo Texto explicativo",
                        onCloseClick = {
                            scope.launch {
                                type.value = TypeModalHome.NONE
                                scope.launch { state.hide() }
                            }
                        }
                    )
                }
                else -> {
                    ContentModalHome(
                        type.value,
                        "Titulo",
                        "Mensagem",
                        onCloseClick = {
                            scope.launch {
                                type.value = TypeModalHome.NONE
                                scope.launch { state.hide() }
                            }
                        }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Black25)
                    .graphicsLayer {
                        alpha =
                            1f - ((scrollState.value.toFloat() / scrollState.maxValue) * 1.5f)
                        translationY = 0.5f * scrollState.value
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(id = R.drawable.bg),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    Modifier
                        .padding(top = 250.dp)
                        .clip(
                            RoundedCornerShape(
                                topEndPercent = 30,
                                topStartPercent = 30
                            )
                        )
                        .background(Black25)
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    AppButtons(
                        appICons = { AppIcons(appIcons = AppIconList.BACK) },
                        appButtons = AppButtonList.ICON, onClick = { finish() },
                        colorButton = Black25
                    )

                    AppText(
                        modifier = Modifier.padding(start = 48.dp, top = 12.dp),
                        appTextTypes = AppTextList.TITLE,
                        text = "Nome do lugar"
                    )
                }
            }
            Column(
                Modifier
                    .clip(RoundedCornerShape(topEndPercent = 5, topStartPercent = 5))
                    .background(Black25)
                    .padding(10.dp)
            ) {
                AppSpace(appSizes = AppSpaceList.MEDIUM)
                IconWithText(
                    appICons = AppIconList.PLACE,
                    text = "Endereço: ",
                )
                Column(Modifier.padding(start = 40.dp)) {
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "Avenida jorge lacerda 12345\nCep: 88047005\nFlorianópolis - SC",
                        maxLines = 5,
                        color = LightGray
                    )
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "Horário: Seg - Sext 13:30 às 21h\nSab 15:00 às 21h",
                        maxLines = 5,
                        color = LightGray
                    )
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "Formas de pagamentos: CARTÕES, DINHEIRO, PIX",
                        maxLines = 5,
                        color = LightGray
                    )

                    AppButtons(
                        appButtons = AppButtonList.ROUNDED,
                        onClick = { },
                        label = "como chegar?"
                    )
                }

                AppDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))

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

                AppDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))

                IconWithText(
                    appICons = AppIconList.PISTOL,
                    text = "Conheça nossos instrutores",
                    subtitle = "clique na imagem para ver o perfil",
                )

                Column(Modifier.padding(start = 5.dp, end = 5.dp)) {
                    repeat(2) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppImage {
                                onInstructor()
                            }
                            AppSpace(appSizes = AppSpaceList.MEDIUM)
                            AppImage {
                                onInstructor()
                            }
                            AppSpace(appSizes = AppSpaceList.MEDIUM)
                            AppImage {
                                onInstructor()
                            }
                        }
                        AppSpace(appSizes = AppSpaceList.MEDIUM)
                    }
                }

                AppDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))


                IconWithText(
                    appICons = AppIconList.PISTOL,
                    text = "Conhença nossos desafios"
                )
                AppDefaultCard(
                    title = "Acerte no Alvo",
                    desc = "Descrição breve 250 caracteres Descrição breve 250 caracteres Descrição breve 250 caracteres",
                    prizeValue = "Premio: R$ 4.500"
                )
                AppSpace(appSizes = AppSpaceList.LARGE)
                IconWithText(
                    appICons = AppIconList.PISTOL,
                    text = "Conhença o/s  ganhadore/s"
                )
                AppDefaultCard(
                    title = "Acerte no Alvo",
                    desc = "Descrição breve 250 caracteres Descrição breve 250 caracteres Descrição breve 250 caracteres",
                    prizeValue = "Premio: R$ 4.500",
                    hasWinner = true,
                    nameWinner = "Paulo Oliveira"
                )

                AppDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))
                IconWithText(appICons = AppIconList.SCHOOL, text = "Cursos")

                AppBanner(
                    backgroundColor = listOf(Red700, Red800, Red900),
                    countPage = 3,
                    onClick = {
                        type.value = TypeModalHome.INSCRIPTION
                        scope.launch {
                            state.show()
                        }
                    },
                    appBanner = AppBannerList.CARD,
                    labelBtn = "Inscrição"
                )



                AppDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))
                IconWithText(appICons = AppIconList.SCHOOL, text = "Loja")

                AppBanner(
                    backgroundColor = listOf(Orange, Black, Green),
                    countPage = 3,
                    onClick = {
                        onProduct()
                    },
                    appBanner = AppBannerList.CARD,
                    labelBtn = "ver mais"
                )

                AppSpace(appSizes = AppSpaceList.LARGE)

                AppButtons(
                    appButtons = AppButtonList.REPORT,
                    onClick = {
                        type.value = TypeModalHome.REPORT
                        scope.launch {
                            state.show()
                        }
                    }
                )
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
                title = "Nome do Produto"
            )
        }

    }

}

@Composable
private fun ContentModalHome(
    typeModal: TypeModalHome,
    title: String,
    message: String,
    onCloseClick: () -> Unit
) {
    Column(
        Modifier
            .height(400.dp)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                modifier = Modifier.weight(4f),
                appTextTypes = AppTextList.TITLE,
                color = White,
                text = title
            )
            AppButtons(
                modifier = Modifier.weight(1f),
                colorButton = Color.Transparent,
                colorLabel = White,
                appButtons = AppButtonList.ICON,
                appICons = { AppIcons(appIcons = AppIconList.CLOSE, color = LightGray) },
                onClick = { onCloseClick() })
        }
        AppDivider(
            Modifier.padding(10.dp)
        )

        when (typeModal) {
            TypeModalHome.REPORT -> {
                var text by remember { mutableStateOf("") }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val maxChar = 31
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        AppText(
                            appTextTypes = AppTextList.SMALL,
                            text = "máximo de $maxChar caracteres",
                            color = if (text.length == maxChar) Red700 else LightGray
                        )
                    }
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10))
                            .background(LightGray)

                            .height(140.dp),
                        value = text,
                        onValueChange = {
                            if (it.length <= maxChar) text = it
                        },
                        maxLines = 10,
                        textStyle = TextStyle(color = Color.Black),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Black,
                            cursorColor = Black,
                            backgroundColor = White
                        )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        AppText(
                            appTextTypes = AppTextList.SMALL,
                            text = "${text.length} / $maxChar",
                            color = if (text.length == maxChar) Red700 else LightGray
                        )
                    }
                    AppDivider(
                        Modifier.padding(10.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        AppButtons(
                            appButtons = AppButtonList.ROUNDED,
                            onClick = {},
                            colorLabel = White,
                            colorBorderButton = White.copy(alpha = .7f),
                            label = "Reportar"
                        )
                    }
                }
            }
            else ->
                Column {
                    AppText(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        appTextTypes = AppTextList.BODY,
                        text = message,
                        color = LightGray
                    )
                    AppDivider(
                        Modifier.padding(10.dp)
                    )
                }

        }

    }
}



