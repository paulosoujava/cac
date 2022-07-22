package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White


enum class AppBannerList {
    CARD,
    IMAGE
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppBanner(
    initialPage: Int = 0,
    widthImage: Int = 250,
    countPage: Int,
    appBanner: AppBannerList,
    backgroundColor: List<Color> = listOf(Black25),
    cardHasFooter: Boolean = true,
    onClick: () -> Unit = {},
    labelBtn: String = "",
) {

    val state = rememberPagerState(initialPage = initialPage)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(Shapes.small)

    ) {
        HorizontalPager(
            state = state,
            count = countPage,
            modifier = Modifier.padding(top = 10.dp)
        ) { index ->
            when (appBanner) {
                AppBannerList.CARD -> JustCard(
                    onClick = onClick,
                    backgroundColor = backgroundColor,
                    indiceCard = index,
                    cardHasFooter = cardHasFooter,
                    labelBtn = labelBtn
                )
                AppBannerList.IMAGE -> JustImage(onClick = onClick, widthImage = widthImage)
            }
        }
        Box(modifier = Modifier.padding(20.dp)) {
            PageIndicator(totalPages = countPage, currentPage = state.currentPage)
        }
    }

}

@Composable
fun PageIndicator(
    totalPages: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    indicatorSize: Dp = 6.dp,
    color: Color = Orange,
    spacing: Dp = indicatorSize,
    selectedMultiplier: Int = 3
) {
    assert(
        value = currentPage in 0 until totalPages,
        lazyMessage = { "Current page index is out of range." }
    )

    val rowWidth =
        (indicatorSize * (selectedMultiplier + (totalPages - 1))) + (spacing * (totalPages - 1))

    Row(
        modifier = modifier
            .requiredWidth(rowWidth),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 0 until totalPages) {
            val selected = i == currentPage

            val height = indicatorSize
            val width: Dp by animateDpAsState(
                if (selected) indicatorSize * selectedMultiplier else indicatorSize
            )

            Canvas(
                modifier = Modifier
                    .size(width, height),
                onDraw = {
                    drawRoundRect(
                        color = color,
                        cornerRadius = CornerRadius(height.toPx() / 2),
                        size = Size(width.toPx(), height.toPx())
                    )
                }
            )
        }
    }
}


@Composable
private fun JustImage(
    onClick: () -> Unit,
    widthImage: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(250.dp)
                .width(widthImage.dp)
                .padding(end = 8.dp)
                .clickable { onClick() }

        )
    }
}

@Composable
private fun JustCard(
    onClick: () -> Unit,
    backgroundColor: List<Color>,
    indiceCard: Int,
    cardHasFooter: Boolean,
    labelBtn: String,
) {
    Column(
        Modifier
            .clip(Shapes.small)
            .background(
                if (backgroundColor.size > 1) {
                    backgroundColor[indiceCard]
                } else {
                    backgroundColor[0]
                }
            )
            .width(350.dp),
    ) {
        AppText(
            appTextTypes = AppTextList.TITLE,
            text = "Title",
            color = White,
            modifier = Modifier.padding(10.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(450.dp, 250.dp)
                .padding(6.dp)
        )
        AnimatedVisibility(visible = cardHasFooter) {
            AppText(
                appTextTypes = AppTextList.BODY,
                color = White,
                text = "Descrição breve 250 caracteres Descrição breve 250 caracteres Descrição breve 250 caracteres Descrição breve 250 caracteres Descrição breve 250 caracteres Descrição breve 250 caracteres",
                maxLines = 10,
                modifier = Modifier.padding(10.dp)
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(end = 15.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            AppButtons(
                appButtons = AppButtonList.SOLID,
                onClick = { onClick() },
                label = labelBtn,
                colorLabel = White
            )
        }

    }
}