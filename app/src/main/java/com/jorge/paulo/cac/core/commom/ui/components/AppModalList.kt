package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppModalList(
    onClick: () -> Unit,
    onClickable: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Black50)
    ) {
        stickyHeader {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .weight(4f)
                            .padding(start = 10.dp)
                    ) {
                        AppText(
                            appTextTypes = AppTextList.TITLE,
                            text = "Selecione o estande"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    ) {
                        AppButtons(
                            modifier = Modifier.padding(10.dp),
                            appButtons = AppButtonList.ICON,
                            appICons = {
                                AppIcons(
                                    appIcons = AppIconList.CLOSE,
                                    color = White
                                )
                            },
                            onClick = {
                                onClick()
                            })
                    }
                }
                AppDivider(
                    color = Black25.copy(alpha = .7f),
                    modifier = Modifier.padding(10.dp)
                )
                AppSpace(appSizes = AppSpaceList.MEDIUM)
            }
        }

        items(5) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        onClickable()

                    }
            ) {

                AppText(
                    modifier = Modifier.padding(15.dp),
                    appTextTypes = AppTextList.TITLE,
                    color = LightGray,
                    text = "NAME DO LUGAR"
                )

                AppDivider(
                    color = LightGray.copy(alpha = .7f),
                    modifier = Modifier.padding(15.dp)
                )
            }

        }

    }
}