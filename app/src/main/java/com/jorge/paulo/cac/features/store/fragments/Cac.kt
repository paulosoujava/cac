package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Sections

@Composable
fun Cac(
    navigate: NavigateViewModel,
    seeProfile: () -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(onBack = { navigate.onNavigate(Sections.HOME) }, title = "Cac's")
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ){
            items(5){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                topStartPercent = 50,
                                bottomStartPercent = 50,
                                bottomEndPercent = 10,
                                topEndPercent = 10
                            )
                        )
                        .clickable { seeProfile() }
                        .background(Black)

                ) {
                    AsyncImage(
                        model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                        placeholder = painterResource(R.drawable.placeholder),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .border(1.dp, Black50, shape = RoundedCornerShape(50))
                            .size(90.dp)

                    )
                    Column(
                        Modifier
                            .weight(3f)
                            .padding(start = 10.dp)) {
                        AppText(appTextTypes = AppTextList.BODY, text = "NAME DO CABRA")
                        AppText(appTextTypes = AppTextList.SMALL, text = "nome da empresa que é socio", color = Color.LightGray)
                    }
                    AppIcons(appIcons = AppIconList.ARROW_RIGHT, color = Color.LightGray)

                }
            }

        }

    }
}