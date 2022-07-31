package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppSectionContact(
    isShow: Boolean,
    onShow: () -> Unit,
    onSave: () -> Unit,
) {
    AppSectionWrapper(
        onShow =  onShow ,
        onSave = onSave,
        isShow = isShow,
        titleSection = "Dados para Contatos",
        slot = {
            Column {
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite o email",
                    label = "Email"
                )
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite o número",
                    label = "WhatsApp"
                )
                AppInputDefault(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    singleLine = false,
                    onValueChange = {},
                    value = "digite o número",
                    label = "Telefone"
                )
            }
        }
    )
}
