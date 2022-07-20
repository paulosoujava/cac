package com.jorge.paulo.cac.core.commom.ui.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Orange25
import com.jorge.paulo.cac.core.commom.ui.theme.Orange50
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White

enum class Type {
    PUBLIC,
    PRIVATE
}

@Composable
fun AppProfile(
    type: Type,
    onInactive: () -> Unit,
    onActive: () -> Unit,
    seeProfile: () -> Unit,
) {
    val width = if(type == Type.PUBLIC) 290 else 400
    Card(
        modifier = Modifier
            .width(width.dp)
            .padding(top = 8.dp, bottom = 8.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Black50)

    ) {

        Column {
            Row(
                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Black25,
                                Black,
                                Black50
                            )
                        )
                    ),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
            ) {
                AsyncImage(
                    model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
                    placeholder = painterResource(R.drawable.placeholder),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(CircleShape)
                        .border(1.dp, White, shape = CircleShape)
                        .size(60.dp)
                )

                Column(Modifier
                    .padding(15.dp)
                    .width(width.dp)
                ) {
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
                    if (type == Type.PRIVATE) {
                        AppText(
                            appTextTypes = AppTextList.SMALL,
                            text = "Opções",
                            color = White
                        )
                    }
                    if (type == Type.PUBLIC) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            SeeProfile(onClick = { seeProfile() })
                        }
                    }
                    if (type == Type.PRIVATE) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            AppButtons(
                                colorLabel = Green,
                                label = "Liberar",
                                appButtons = AppButtonList.TEXT, onClick = { onActive() }
                            )


                            SeeProfile(onClick = { seeProfile() })


                            AppButtons(
                                colorLabel = Red700,
                                label = "Bloquear",
                                appButtons = AppButtonList.TEXT, onClick = { onInactive() }
                            )
                        }
                    }

                }
            }
        }
    }
}


@Composable
private fun SeeProfile(onClick: () -> Unit) {
    AppButtons(
        colorLabel = LightGray,
        label = "Ver Perfil",
        appButtons = AppButtonList.TEXT,
        onClick = { onClick() }
    )
}