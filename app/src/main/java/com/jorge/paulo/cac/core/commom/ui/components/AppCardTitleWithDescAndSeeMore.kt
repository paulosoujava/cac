package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Black

const val SIZE_CARD = 180

@Composable
fun AppCardTitleWithDescAndSeeMore(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier
            .width(SIZE_CARD.dp)
            .clickable { onClick() },
        elevation = 12.dp
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "image",
                modifier = Modifier.size(SIZE_CARD.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(10.dp)) {
                AppText(
                    appTextTypes = AppTextList.BODY,
                    color = Black,
                    text = "Titulo do produto"
                )
                AppDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))
                AppText(
                    appTextTypes = AppTextList.SMALL,
                    maxLines = 3,
                    color = Black,
                    text = "breve descricao do produto breve descricao do produto breve descricao do produto breve descricao do produto  breve descricao do produto breve descricao do produto breve descricao do produto breve descricao do produto breve descricao do produto breve descricao do produto"
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onClick) {
                        AppText(
                            appTextTypes = AppTextList.SMALL,
                            maxLines = 5,
                            color = Black,
                            text = "ver mais"
                        )
                    }
                }

            }

        }
    }
}