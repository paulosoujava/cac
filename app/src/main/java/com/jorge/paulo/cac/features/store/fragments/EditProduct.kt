package com.jorge.paulo.cac.features.store.fragments

import android.util.Size
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppDefault3Input
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments

@Composable
fun EditProduct(
    navigate: NavigateViewModel
) {
    Scaffold(
        topBar = {
            AppToolbar(
                onBack = { navigate.onNavigate(Fragments.LIST_STORE_SECTION) },
                title = "Cadastro de itens"
            )
        }
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(
                    bottom = it.calculateBottomPadding(),
                    top = 25.dp,
                    start = 15.dp,
                    end = 15.dp
                )
        ) {

            AnimatedVisibility(visible = false) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AppIcons(appIcons = AppIconList.INFO, color = Red700)
                    AppText(
                        appTextTypes = AppTextList.SMALL,
                        text = "Erros vão aqui",
                        color = Red700
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AppText(
                    modifier = Modifier.padding(10.dp),
                    appTextTypes = AppTextList.SMALL,
                    text = "Adicione 3 imagens",
                    color = LightGray
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Black.copy(.5f))
                        .padding(10.dp)
                ) {
                    BoxClickableImage(Modifier.weight(1f)) {}
                    BoxClickableImage(Modifier.weight(1f)) {}
                    BoxClickableImage(Modifier.weight(1f)) {}
                }
            }
            AppDefault3Input(
                onValueChangeOne = {},
                labelInputOne = "Título",
                labelOne = "digite um título",
                onValueChangeTwo = {},
                labelInputTwo = "Valor",
                labelTwo = "qual o valor",
                onValueChangeThree = {},
                labelInputThree = "Descrição",
                labelThree = "digite uma descrição",
                labelButton = "Cadastrar",
                modifier = Modifier
                    .padding(1.dp)
                    .graphicsLayer {
                        shadowElevation = 8.dp.toPx()
                        clip = true
                    }
                    .padding(start = 32.dp, top = 64.dp, end = 32.dp, bottom = 64.dp)
            )


        }


    }

}

@Composable
fun BoxClickableImage(
    modifier: Modifier = Modifier,
    onCLick: () -> Unit
) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .size(90.dp)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.placehold_image),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )
            Box(
                modifier = modifier
                    .padding(
                        top = 40.dp,
                        start = 60.dp
                    )
                    .clip(RoundedCornerShape(10))
                    .background(Black)
                    .padding(5.dp)
            ) {
                AppIcons(appIcons = AppIconList.CAMERA, color = White)
            }
        }


}
