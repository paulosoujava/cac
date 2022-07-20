package com.jorge.paulo.cac.core.commom.ui.components


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.jorge.paulo.cac.core.commom.ui.theme.Orange


enum class AppTextList{
    TITLE,
    BODY,
    SMALL
}

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    appTextTypes: AppTextList,
    text: String,
    color: Color = Orange,
    maxLines: Int = 1
){
    Text(
        text = text,
        color = color,
        style = when(appTextTypes){
            AppTextList.TITLE -> MaterialTheme.typography.caption
            AppTextList.BODY -> MaterialTheme.typography.body1
            AppTextList.SMALL -> MaterialTheme.typography.body2
        },
        modifier = modifier,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis
    )
}