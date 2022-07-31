package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppSectionMidia(
    isShow: Boolean,
    onShow: () -> Unit,
    onSave: () -> Unit,
) {
    AppSectionWrapper(
        onShow =  onShow ,
        onSave = onSave,
        isShow = isShow,
        titleSection = "Dados de Mídias",
        slot = {
            Column {
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite a url",
                    label = "Facebook"
                )
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite o @seunome",
                    label = "Instagram"
                )
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite a url",
                    label = "Site"
                )
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite a url",
                    label = "Youtube"
                )
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite o @seunome",
                    label = "TikTok"
                )
            }
        }
    )
}

