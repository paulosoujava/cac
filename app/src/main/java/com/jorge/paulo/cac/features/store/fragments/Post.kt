package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Sections

@Composable
fun Post(navigate: NavigateViewModel) {
    val visible = remember { mutableStateOf(false) }
    var text = remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            AppToolbar(
                onBack = {
                    navigate.onNavigate(Sections.HOME)
                },
                title = "Instrutores"
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

            if (visible.value) {
                OutlinedTextField(
                    value = text.value,
                    onValueChange = {
                        text.value = it
                    },
                    textStyle = TextStyle(
                        color = White
                    ),
                    label = {
                        AppText(
                            appTextTypes = AppTextList.SMALL,
                            text = "Nome da seção",
                            color = White
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = White,
                        focusedBorderColor = LightGray,
                        unfocusedBorderColor = White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    AppButtons(

                        appICons = {
                            AppIcons(
                                appIcons = AppIconList.ACCOUNT,
                                color = White
                            )
                        },
                        appButtons = AppButtonList.ICON,
                        onClick = { /*TODO*/ })
                }
                AppSpace(appSizes = AppSpaceList.SMALL)
            }
        }
    }

}