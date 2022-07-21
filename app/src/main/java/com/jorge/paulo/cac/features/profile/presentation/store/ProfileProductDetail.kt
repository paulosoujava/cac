package com.jorge.paulo.cac.features.profile.presentation.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppBanner
import com.jorge.paulo.cac.core.commom.ui.components.AppBannerList
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.White

@Composable
fun ProfileProductDetail(
    finish: () -> Unit
){
    Scaffold(
        topBar = {
            AppToolbar(
                onBack = {
                    finish()
                },
                title = "Nome do Produto"
            )

        }
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = it.calculateTopPadding())
        ) {

            AppBanner(
                countPage = 3,
                appBanner = AppBannerList.IMAGE,
                onClick = {})

            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .border(1.dp, Green),
                backgroundColor = Black25,
                elevation = 12.dp,

                ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    AppText(
                        appTextTypes = AppTextList.TITLE,
                        text = "Title",
                        color = White
                    )

                    AppDivider(
                        color = LightGray,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )


                    AppText(
                        appTextTypes = AppTextList.BODY,
                        maxLines = 10,
                        color = White,
                        text = "A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado na produção gráfica para preencher os espaços de texto em publicações para testar e ajustar aspectos visuais antes de utilizar conteúdo rea A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado na produção gráfica para preencher os espaços de texto em publicações para testar e ajustar aspectos visuais antes de utilizar conteúdo rea"
                    )

                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "12x de 450 ou A vista 4000",
                        color = White,
                        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
                    )

                }
            }
            AppSpace(appSizes = AppSpaceList.MEDIUM)

        }
    }
}