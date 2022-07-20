package com.jorge.paulo.cac.features.timeline.presentation.timelines

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppBackground
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.profile.ProfileActivity
import com.jorge.paulo.cac.features.profile.presentation.ProfileScreens


@Composable
fun Store(
    context: Context
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        contentAlignment = Alignment.Center
    ) {

        repeat(5) {
            Card(
                shape = Shapes.medium,
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        val intent  = Intent(context, ProfileActivity::class.java)
                        intent.action = ProfileScreens.STORE.screen
                        context.startActivity(intent)
                    }

                    .padding(10.dp)
                    .border(1.dp, Orange, shape = Shapes.medium),
                elevation = Elevations.DEFAULT.size
            ) {
                Box {
                    AppBackground(
                        painter = painterResource(id = R.drawable.bg),
                        backgroundDrawableResId = R.drawable.bg,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)
                    )
                    AppText(
                        modifier = Modifier
                            .padding(top = 260.dp)
                            .fillMaxWidth()
                            .background(Black25.copy(alpha = .7f)).padding(20.dp),
                        appTextTypes = AppTextList.TITLE,
                        color = White,
                        text = "Estande tio paulada, um tiro uma cagada"
                    )
                }
            }
        }
    }
}



