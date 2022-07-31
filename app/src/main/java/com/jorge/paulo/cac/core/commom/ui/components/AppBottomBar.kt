package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.features.store.fragments.TypeModal
import kotlinx.coroutines.launch

@Composable
fun AppBottomBar(
    onDeleteClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Black)
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppButtons(
            label = "DELETAR CONTA",
            colorLabel = Red700,
            appButtons = AppButtonList.TEXT,
            onClick = onDeleteClick
        )
        AppIcons(appIcons = AppIconList.DASHBOARD, color = LightGray)

        AppButtons(
            label = "DESLOGAR",
            colorLabel = Green,
            appButtons = AppButtonList.TEXT,
            onClick = onLogoutClick
        )


    }
}