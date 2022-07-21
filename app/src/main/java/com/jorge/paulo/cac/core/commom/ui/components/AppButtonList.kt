package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Orange50
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White
import okhttp3.internal.wait


enum class AppButtonList {
    TEXT,
    ROUNDED,
    SOLID,
    ICON,
    REPORT,
    DEFAULT,
    LOADING,
}

@Composable
fun AppButtons(
    modifier: Modifier = Modifier,
    appButtons: AppButtonList,
    onClick: () -> Unit,
    label: String = "",
    colorLabel: Color = White,
    colorButton: Color = Orange,
    colorBorderButton: Color = Orange50,
    appICons: @Composable () -> Unit = {},
) {
    when (appButtons) {
        AppButtonList.TEXT -> {
            TextButton(
                onClick = onClick,
            ) {
                AppText(
                    appTextTypes = AppTextList.SMALL,
                    maxLines = 5,
                    color = colorLabel,
                    text = label
                )
            }
        }
        AppButtonList.ROUNDED -> {

            TextButton(
                onClick = onClick,
                border = BorderStroke(1.dp, colorBorderButton),

                ) {
                AppText(
                    appTextTypes = AppTextList.SMALL,
                    text = label,
                    color = colorLabel,
                )
            }
        }

        AppButtonList.SOLID -> {
            TextButton(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Orange.copy(alpha = .5f)
                )
            ) {
                Text(
                    text = label,
                    color = colorLabel,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.End,
                )
            }
        }

        AppButtonList.ICON -> {
            IconButton(
                onClick = onClick,
                modifier = modifier
                    .padding(end = 5.dp, start = 5.dp)
                    .clip(Shapes.small)
                    .background(colorButton)
            ) {
                appICons()
            }
        }

        AppButtonList.REPORT -> {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier
                        .clickable { onClick() }
                        .padding(10.dp)
                        .height(40.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AppIcons(
                        appIcons = AppIconList.REPORT,
                        color = LightGray,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    AppText(
                        appTextTypes = AppTextList.SMALL,
                        text = "Reportar este usário",
                        color = LightGray
                    )
                }

            }
        }

        AppButtonList.DEFAULT -> {
            Button(
                onClick = { onClick() },
                modifier = Modifier.padding(
                    start = 60.dp,
                    end = 60.dp,
                    top = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Orange,
                    backgroundColor = colorButton
                )
            ) {
                Text(
                    text = label,
                    color = colorLabel,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }
        }

        AppButtonList.LOADING -> {
            LoadingButton(
                onClick = onClick,
                label = label,
                colorLabel = colorLabel,
                colorButton = colorButton,
                colorCircular = colorBorderButton,
            )
        }
    }


}

@Composable
private fun LoadingButton(
    onClick: () -> Unit,
    label: String,
    colorLabel: Color,
    colorButton: Color,
    colorCircular: Color
) {
    var state by remember { mutableStateOf(true) }

    val offsetAnimation: Dp by animateDpAsState(
        if (state) 320.dp else 60.dp,
    )
    val offsetAnimationRounded: Int by animateIntAsState(targetValue = if (state) 10 else 60)
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            shape = RoundedCornerShape(offsetAnimationRounded),
            modifier = Modifier
                .size(offsetAnimation, 60.dp),

            onClick = {
                state = !state
                onClick()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Orange,
                backgroundColor = colorButton
            )
        ) {
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (state) {
                    AppText(appTextTypes = AppTextList.BODY, text = label, color = colorLabel)
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier.size(30.dp),
                        color = colorCircular,
                        strokeWidth = 2.dp
                    )

                }
            }

        }
    }
}
