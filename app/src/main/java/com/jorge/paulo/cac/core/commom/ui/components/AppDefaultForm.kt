package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.White

@Composable
fun AppDefault3Input(
    modifier: Modifier = Modifier,
    onValueChangeOne: (String)-> Unit,
    labelInputOne: String,
    labelOne: String,
    onValueChangeTwo: (String)-> Unit,
    labelInputTwo: String,
    labelTwo: String,
    onValueChangeThree: (String)-> Unit,
    labelInputThree: String,
    labelThree: String,
    colorButton: Color = Black,
    colorLabel: Color = White,
    labelButton: String,
    showAuxInput: Boolean = false,
    onValueChangeAux: (String)-> Unit = {},
    labelInputAux: String = "",
    labelAux: String = "",
) {
    Column(modifier = modifier) {
        AppInputDefault(
            onValueChange = onValueChangeOne,
            value = labelInputOne,
            label = labelOne
        )
        AppSpace(appSizes = AppSpaceList.MEDIUM)
        AppInputDefault(
            onValueChange = onValueChangeTwo,
            value = labelInputTwo,
            label = labelTwo
        )
        AppSpace(appSizes = AppSpaceList.MEDIUM)
        AppInputDefault(
            modifier = Modifier.height(140.dp),
            onValueChange = onValueChangeThree,
            value = labelInputThree,
            label = labelThree,
            singleLine = false
        )
        AppSpace(appSizes = AppSpaceList.LARGE)
        if(showAuxInput){
            AppInputDefault(
                modifier = Modifier.height(140.dp),
                onValueChange = onValueChangeAux,
                value = labelInputAux,
                label = labelAux,
                singleLine = false
            )
            AppSpace(appSizes = AppSpaceList.LARGE)
        }
        AppButtons(
            label = labelButton,
            colorButton = colorButton,
            colorLabel = colorLabel,
            appButtons = AppButtonList.DEFAULT,
            onClick = { /*TODO*/ }
        )
    }
}