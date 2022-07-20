package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Orange50
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White


enum class AppButtonList {
    TEXT,
    ROUNDED,
    SOLID,
    ICON,
    REPORT,
    DEFAULT
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
    }

}