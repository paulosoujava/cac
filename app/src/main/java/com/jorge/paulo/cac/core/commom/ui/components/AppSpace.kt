package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class AppSpaceList(val size: Int) {
    SMALL(5),
    MEDIUM(10),
    LARGE(15),
    XXXLARGE(135),
}


@Composable
fun AppSpace(appSizes: AppSpaceList) {
    Spacer(
        modifier = Modifier.size(
            when (appSizes) {
                AppSpaceList.SMALL -> AppSpaceList.SMALL.size.dp
                AppSpaceList.MEDIUM -> AppSpaceList.MEDIUM.size.dp
                AppSpaceList.LARGE -> AppSpaceList.LARGE.size.dp
                AppSpaceList.XXXLARGE -> AppSpaceList.XXXLARGE.size.dp
            }

        )
    )
}