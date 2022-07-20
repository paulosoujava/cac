package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppInfo(
    state: ModalBottomSheetState,
    slot: @Composable () -> Unit,
) {

    ModalBottomSheetLayout(
        scrimColor = Black.copy(alpha = .7f),
        sheetShape = RoundedCornerShape(topStartPercent = 10, topEndPercent = 10),
        sheetState = state,
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .background(Black25)
            ) {

                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(start = 20.dp, top = 30.dp)
                ) {
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "Ops",
                        color = LightGray
                    )
                }
                AppDivider(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 20.dp,
                        start = 10.dp,
                        end = 10.dp
                    ),
                    color = Black.copy(alpha = .4f)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(30.dp)
                ) {
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        color = LightGray,
                        maxLines = 6,
                        text = "Precisamos de permissões, para acessar a camera e fazer a leitura do" +
                                "QRCode. Par favor vá nas configurações do app e conceda para que tudo funcione perfeitamente."
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppButtons(
                        label = "Ok, entendi",
                        colorButton = Orange,
                        appButtons = AppButtonList.ROUNDED,
                        onClick = { /*TODO*/ })
                }

            }
        }
    ) {
        slot()
    }
}
