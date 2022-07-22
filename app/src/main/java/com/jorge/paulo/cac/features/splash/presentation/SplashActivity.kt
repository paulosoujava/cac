package com.jorge.paulo.cac.features.splash.presentation


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppBackground
import com.jorge.paulo.cac.core.commom.ui.components.AppLoading
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White


import com.jorge.paulo.cac.features.timeline.presentation.timelines.TimelineActivity
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel: SplashViewModel = hiltViewModel()
            AppTheme {
                val state = viewModel.state.collectAsState()
                Content(state){
                    startActivity(Intent(this@SplashActivity, TimelineActivity::class.java))
                    finish()
                }
            }
        }
    }
}

@Composable
private fun Content(
    state: State<SplashState>,
    onFinish: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppBackground(
            painter = painterResource(id = R.drawable.bg),
            backgroundDrawableResId = R.drawable.bg,
            contentDescription = "background",
            modifier = Modifier.fillMaxSize()
        )
        if (state.value.loading)
            AppLoading()
        else {
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(Shapes.medium)
                        .border(1.dp, Orange, shape = Shapes.medium)
                        .background(Black)
                        .padding(20.dp)
                ) {
                    AppText(
                        appTextTypes = AppTextList.BODY,
                        text = "redirecionando...",
                        color = White
                    )
                }
            }
            onFinish()
        }
    }
}


