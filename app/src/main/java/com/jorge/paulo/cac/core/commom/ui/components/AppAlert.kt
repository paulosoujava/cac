package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.Red900
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White

enum class AppAlertList {
    INFO,
    REPORT,
    CONFIRMATION,
    DELETE_ACCOUNT
}

@Composable
fun AppAlert(
    modifier: Modifier = Modifier,
    appAlertList: AppAlertList,
    description: String,
    title: String,
    onClick: () -> Unit,
    onClose: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    when (appAlertList) {
        AppAlertList.INFO -> Alert(
            modifier = modifier,
            mutableInteractionSource = interactionSource,
            onClose = onClose,
            title = title,
            slot = {
                ContentAlertInf(description = description)
            }
        )
        AppAlertList.REPORT ->
            Alert(
                modifier = modifier,
                mutableInteractionSource = interactionSource,
                onClose = onClose,
                title = title,
                slot = {
                    ContentAlertReport(
                        onConfirm = onClick
                    )
                }
            )
        AppAlertList.CONFIRMATION ->
            Alert(
                modifier = modifier,
                mutableInteractionSource = interactionSource,
                onClose = onClose,
                title = title,
                slot = {
                    ContentAlertConfirmation(
                        description = description,
                        onConfirm = onClick
                    )
                }
            )
        AppAlertList.DELETE_ACCOUNT -> {
            Alert(
                modifier = modifier,
                background = White,
                mutableInteractionSource = interactionSource,
                onClose = onClose,
                title = title,
                slot = {
                    ContentDeleteAccount(description = description) {
                        onClick()
                    }
                }
            )
        }
    }
}


@Composable
fun Alert(
    modifier: Modifier,
    background: Color = LightGray,
    colorText: Color = Black,
    mutableInteractionSource: MutableInteractionSource,
    onClose: () -> Unit,
    title: String,
    slot: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .background(background)
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppText(
                    appTextTypes = AppTextList.BODY,
                    text = title,
                    color = colorText,
                    modifier = Modifier.weight(8f)
                )
                Box(
                    modifier = Modifier
                        .border(1.dp, Black, shape = Shapes.large)
                        .height(45.dp)
                        .weight(1f)
                        .clickable(
                            interactionSource = mutableInteractionSource,
                            indication = null
                        ) {
                            onClose()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    AppIcons(appIcons = AppIconList.CLOSE, color = Black)
                }
            }

            AppDivider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

            slot()
        }
    }
}


@Composable
private fun ContentAlertInf(
    description: String,
) {
    AppText(
        appTextTypes = AppTextList.BODY,
        maxLines = 10,
        color = Black,
        text = description
    )
}

@Composable
private fun ContentAlertConfirmation(
    onConfirm: () -> Unit,
    description: String
) {
    Column {

        ContentAlertInf(description)

        AppDivider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

        AppButtons(
            appButtons = AppButtonList.ROUNDED,
            onClick = {
                onConfirm()
            },
            colorLabel = Black,
            colorBorderButton = Black.copy(alpha = .7f),
            label = "Confirmar",
        )
    }
}

@Composable
private fun ContentAlertReport(
    onConfirm: () -> Unit,
) {
    var text by remember { mutableStateOf("") }

    Column {

        ContentAlertInf("Informe o motivo:")

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            value = text,
            onValueChange = { text = it },
            maxLines = 10,
            textStyle = TextStyle(color = Color.Black),

            )

        AppButtons(
            appButtons = AppButtonList.ROUNDED,
            onClick = {
                onConfirm()
            },
            colorLabel = Black,
            colorBorderButton = Black.copy(alpha = .7f),
            label = "Reportar"
        )
    }
}

@Composable
fun ContentDeleteAccount(
    description: String,
    onConfirm: () -> Unit
) {
    Column {
        AppText(
            appTextTypes = AppTextList.BODY,
            maxLines = 10,
            color = Black,
            text = description
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppButtons(
                appButtons = AppButtonList.DEFAULT,
                onClick = {
                    onConfirm()
                },
                colorLabel = White,
                colorButton = Red900,
                colorBorderButton = Red700.copy(alpha = .7f),
                label = "DELETAR"
            )
        }

    }
}
