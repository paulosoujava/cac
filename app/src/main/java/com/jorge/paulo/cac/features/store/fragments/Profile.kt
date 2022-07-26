package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
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
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionContact
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionMidia
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionWrapper
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Profile(
    navigate: NavigateViewModel?
) {
    val showSectionStore = remember { mutableStateOf(false) }
    val showSectionMidia = remember { mutableStateOf(false) }
    val showSectionContact = remember { mutableStateOf(false) }
    val stateScrollState = rememberScrollState()
    Scaffold(
        topBar = {
            AppToolbar(
                onBack = { navigate?.onNavigate(Fragments.HOME) },
                title = "Profile Estande"
            )
        }
    ) {
        Column(
            Modifier
                .verticalScroll(stateScrollState)
                .padding(
                    top = 20.dp,
                    bottom = it.calculateBottomPadding(),
                    start = 10.dp,
                    end = 10.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppText(
                appTextTypes = AppTextList.SMALL,
                text = "Adicione uma foto do estande",
                color = Orange
            )
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
            Divider(
                modifier = Modifier.padding(
                    top = 20.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
                color = Black
            )

            AppSectionWrapper(
                onShow = { showSectionStore.value = !showSectionStore.value },
                onSave = {},
                isShow = showSectionStore.value,
                titleSection = "Dados do estande",
                slot = {
                    Column {
                        AppInputDefault(
                            onValueChange = {},
                            value = "digite o nome",
                            label = "Nome do estande"
                        )
                        AppInputDefault(
                            modifier = Modifier
                                .height(130.dp)
                                .padding(top = 20.dp, bottom = 20.dp),
                            singleLine = false,
                            onValueChange = {},
                            value = "digite o horário de funcionamento",
                            label = "Horários"
                        )

                        AppInputDefault(
                            modifier = Modifier
                                .height(130.dp)
                                .padding(top = 20.dp, bottom = 20.dp),
                            singleLine = false,
                            onValueChange = {},
                            value = "digite o endereço completo",
                            label = "Endereço"
                        )
                        AppInputDefault(
                            modifier = Modifier
                                .height(130.dp)
                                .padding(top = 20.dp, bottom = 20.dp),
                            singleLine = false,
                            onValueChange = {},
                            value = "digite as formas de pagamento",
                            label = "Formas de Pagamento"
                        )

                    }
                })
            AppSpace(appSizes = AppSpaceList.MEDIUM)
            AppSectionWrapper(
                onShow = { showSectionContact.value = !showSectionContact.value },
                onSave = {},
                isShow = showSectionContact.value,
                titleSection = "Serviços oferecidos",
                slot = {
                    AppInputDefault(
                        modifier = Modifier
                            .height(130.dp)
                            .padding(top = 20.dp, bottom = 20.dp),
                        singleLine = false,
                        onValueChange = {},
                        value = "quais serviço o estande oferece?",
                        label = "Serviços"
                    )
                }
            )
            AppSpace(appSizes = AppSpaceList.MEDIUM)
            AppSectionContact(
                onShow = {
                    showSectionContact.value = !showSectionContact.value
                },
                isShow = showSectionContact.value
            ){}

            AppSpace(appSizes = AppSpaceList.MEDIUM)

            AppSectionMidia(
                onShow = {
                    showSectionMidia.value = !showSectionMidia.value
                },
                isShow = showSectionMidia.value
            ){}

        }
    }
}

