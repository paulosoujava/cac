package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes

@Composable
fun AppLoading() {
    Row(
        Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .clip(Shapes.large)
                .border(1.dp, Orange, shape = Shapes.large)
                .size(80.dp)
                .background(Black25),
            contentAlignment = Alignment.Center,

            ) {
            CircularProgressIndicator(
                color = Orange,
                strokeWidth = 1.dp
            )

            Icon(
                painterResource(id = R.drawable.pistol),
                tint = Orange,
                contentDescription = null
            )
        }
    }
}
