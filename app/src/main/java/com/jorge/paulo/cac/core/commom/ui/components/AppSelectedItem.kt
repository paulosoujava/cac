package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange

@Composable
fun AppSelectedItem(
    selected: Boolean,
    label: String,
    width: Int = 153,
    leftOrRight: Boolean = true,
    onSelect: () -> Unit,

) {
    Card(
        shape = RoundedCornerShape(20),
        elevation = Elevations.DEFAULT.size,
        backgroundColor = Color.Black,
        modifier = Modifier
            .padding(10.dp)
            .size(width.dp, 46.dp)
            .border(1.dp, if (selected) Orange else Black, shape = RoundedCornerShape(20))
            .clickable { onSelect() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leftOrRight.not()) {
                Box(Modifier.padding(end = 10.dp)){
                    Check(selected)
                }

            }
            AppText(
                modifier = Modifier.weight(3f),
                appTextTypes = AppTextList.TITLE,
                text = label, color = if (selected) Orange else LightGray
            )
            if (leftOrRight) {
                Check(selected)
            }


        }

    }
}

@Composable
private fun Check(selected: Boolean) {
    Box {
        AppIcons(
            appIcons = AppIconList.OUTLINE_EMPTY_CHECK,
            color = if (selected) Orange else LightGray
        )
        androidx.compose.animation.AnimatedVisibility(
            visible = selected,
            enter = fadeIn(),
        ) {
            AppIcons(
                appIcons = AppIconList.CLOSE,
                color = Orange
            )
        }

    }

}