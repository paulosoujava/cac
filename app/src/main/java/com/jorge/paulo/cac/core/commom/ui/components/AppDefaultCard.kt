package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes

@Composable
fun AppDefaultCard(
    hasWinner: Boolean = false,
    title: String,
    desc: String,
    prizeValue: String = "",
    nameWinner: String = ""
) {
    Column(
        Modifier
            .padding(top = 10.dp)
            .border(1.dp, if (hasWinner) Green else LightGray, shape = Shapes.small)
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(Modifier.weight(3f)) {
                AppText(
                    appTextTypes = AppTextList.TITLE,
                    text = title,
                    color = LightGray
                )

                AnimatedVisibility(visible = hasWinner) {
                    Column{
                        AppText(
                            appTextTypes = AppTextList.TITLE,
                            text = "Ganhador:",
                            color = LightGray
                        )
                        AppText(
                            appTextTypes = AppTextList.TITLE,
                            text = nameWinner,
                            color = Green
                        )
                    }
                }
            }
            AnimatedVisibility(visible = hasWinner) {
                AsyncImage(
                    model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                    placeholder = painterResource(R.drawable.placeholder),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(CircleShape)
                        .border(1.dp, Green, shape = CircleShape)
                        .size(80.dp)
                        .weight(1f)
                )
            }
        }

        AppDivider(Modifier.padding(end = 20.dp, top = 10.dp, bottom = 5.dp), color = LightGray)
        AppText(
            appTextTypes = AppTextList.BODY,
            text = desc,
            color = LightGray,
            modifier = Modifier.padding(top = 10.dp, end = 20.dp),
            maxLines = 10
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                appTextTypes = AppTextList.TITLE,
                text = prizeValue,
                modifier = Modifier.padding(top = 10.dp, end = 10.dp),
                color = if (hasWinner) Green else LightGray
            )
        }

    }
}