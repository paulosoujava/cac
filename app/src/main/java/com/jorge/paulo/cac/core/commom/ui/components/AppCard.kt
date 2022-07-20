package com.jorge.paulo.cac.core.commom.ui.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange50
import com.jorge.paulo.cac.core.commom.ui.theme.White


enum class CardList {
    DEFAULT,
    IMAGE,

}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    label: String,
    icon: AppIconList? = null,
    cardList: CardList,
    onClick: () -> Unit,
    numBadge: Int? = null
) {

    when (cardList) {
        CardList.DEFAULT -> {
            CardDefault(modifier = modifier,
                onClick = onClick,
                slot = {
                    Column {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(40.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Black25.copy(.7f)),
                            contentAlignment = Alignment.Center
                        ) {
                            AppIcons(appIcons = icon!!, color = White)
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            BadgedBox(
                                badge = {
                                    if (numBadge != null) {
                                        if(numBadge>0)Badge { Text(numBadge.toString()) }
                                    }
                                }
                            ) {
                                AppText(
                                    appTextTypes = AppTextList.TITLE,
                                    text = label
                                )
                            }

                            AppSpace(appSizes = AppSpaceList.XXXLARGE)
                        }
                    }
                }
            )
        }

        CardList.IMAGE -> {
            CardDefault(modifier = modifier,
                onClick = onClick,
                slot = {
                    Column {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(40.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Black25.copy(.7f)),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                                placeholder = painterResource(R.drawable.placeholder),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .border(1.dp, LightGray, shape = CircleShape)
                                    .size(50.dp)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {

                            AppText(
                                appTextTypes = AppTextList.TITLE,
                                text = label
                            )

                            AppSpace(appSizes = AppSpaceList.XXXLARGE)
                        }
                    }
                }
            )
        }

    }
}


@Composable
private fun CardDefault(modifier: Modifier, slot: @Composable () -> Unit, onClick: () -> Unit, ) {
        Card(
            elevation = Elevations.DEFAULT.size,
            shape = RoundedCornerShape(10),
            backgroundColor = Black,
            modifier = modifier
                .padding(8.dp)
                .size(120.dp)
                .border(1.dp, Black25, RoundedCornerShape(10))
                .clip(RoundedCornerShape(10))
                .clickable { onClick() }
        ) {
            slot()
        }

}