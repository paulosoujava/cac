package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.Orange

@Composable
fun AppSectionWrapper(
    titleSection: String,
    isShow: Boolean,
    onShow: () -> Unit,
    onSave: () -> Unit = {},
    hasButton: Boolean = true,
    slot: @Composable () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Black)
            .padding(20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .clickable { onShow() }
                .background(Black)
                .padding(10.dp)
        ) {
            AppText(
                modifier = Modifier.weight(9f),
                appTextTypes = AppTextList.TITLE, text = titleSection
            )
            Box(
                modifier = Modifier.weight(1f)
            ) {
                AppIcons(
                    appIcons = if (isShow) AppIconList.ARROW_UP else AppIconList.ARROW_DOWN,
                    color = Orange
                )
            }

        }

        AnimatedVisibility(visible = isShow) {
            Column {
                AppDivider(
                    modifier = Modifier.padding(top = 10.dp, bottom = 35.dp),
                    color = Orange.copy(.3f)
                )

                slot()

                if (hasButton) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppButtons(
                            colorButton = Green.copy(alpha = .5f),
                            label = "Cadastrar",
                            appButtons = AppButtonList.DEFAULT, onClick = { onSave() })
                    }
                }

            }
        }
    }
}