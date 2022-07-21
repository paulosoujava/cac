package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Black50

@Composable
fun AppImage(seeProfile: () -> Unit) {
    AsyncImage(
        model = "https://escolaeducacao.com.br/wp-content/uploads/2019/05/download.jpeg",
        placeholder = painterResource(R.drawable.placeholder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(10))
            .border(1.dp, Black50, shape = RoundedCornerShape(10))
            .size(120.dp)
            .clickable { seeProfile() }
    )

}