package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import com.jorge.paulo.cac.core.commom.ui.theme.Orange


@Composable
 fun AppInputPassword(
    onValueChange: (String) -> Unit,
    value: String,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            AppText(
                appTextTypes = AppTextList.SMALL,
                text = label,
                color = Orange
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Orange,
            focusedIndicatorColor = Orange,
            textColor = Orange

        )
    )
}
