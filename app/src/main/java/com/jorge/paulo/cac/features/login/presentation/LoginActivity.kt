package com.jorge.paulo.cac.features.login.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppBackground
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
import com.jorge.paulo.cac.core.commom.ui.components.AppInputPassword
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.features.about.AboutActivity
import com.jorge.paulo.cac.features.store.StoreActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: LoginViewModel = hiltViewModel()
            val state = viewModel.state.collectAsState()

            AppTheme {
                var valueEmail by remember { mutableStateOf("") }
                var valuePass by remember { mutableStateOf("") }
                var valuePassRep by remember { mutableStateOf("") }

                Scaffold(
                    bottomBar = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 10.dp,
                                        topEnd = 10.dp,
                                    )
                                )
                                .background(Black50.copy(alpha = .98f)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .background(Orange)
                            ) {
                                AppButtons(
                                    appButtons = AppButtonList.ICON,
                                    appICons = {
                                        AppIcons(
                                            appIcons = AppIconList.BACK,
                                            color = Black
                                        )
                                    },
                                    onClick = {
                                        if (state.value.login) {
                                            finish()
                                        } else {
                                            viewModel.onEvent(LoginEvent.Login)
                                        }
                                    }
                                )
                                AppText(
                                    appTextTypes = AppTextList.TITLE,
                                    text = state.value.label,
                                    color = Black25,
                                    modifier = Modifier.padding(
                                        start = 15.dp,
                                        bottom = 15.dp,
                                        top = 15.dp
                                    )
                                )
                            }

                            AppSpace(appSizes = AppSpaceList.LARGE)
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AppInputDefault(
                                    onValueChange = {
                                        valueEmail = it
                                    },
                                    value = valueEmail,
                                    label = "digite o email ",
                                    keyboardType = KeyboardType.Email,
                                    modifier = Modifier.padding(start =45.dp, end = 45.dp, bottom = 15.dp)
                                )
                                AnimatedVisibility(visible = !state.value.recovery) {
                                    AppInputPassword(
                                        onTextChanged = { valuePass = it },
                                        text = valuePass,
                                        label = "Senha",
                                        modifier = Modifier.padding(start =45.dp, end = 45.dp)
                                    )
                                }
                                AnimatedVisibility(visible = state.value.login) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 60.dp, bottom = 25.dp),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        AppButtons(
                                            appButtons = AppButtonList.TEXT,
                                            onClick = {
                                                viewModel.onEvent(LoginEvent.Recovery)
                                            },
                                            colorLabel = LightGray,
                                            label = "esqueci a senha",
                                        )
                                    }

                                }
                                AnimatedVisibility(visible = state.value.register) {
                                    AppInputPassword(
                                        onTextChanged = {
                                            valuePassRep = it
                                        },
                                        text = valuePassRep,
                                        label = "Rep. Senha",
                                        modifier = Modifier.padding(start =45.dp, end = 45.dp, bottom = 15.dp)
                                    )

                                }
                            }
                            //TODO remover depois
                            val scope = rememberCoroutineScope()
                            AppButtons(
                                appButtons = AppButtonList.LOADING,
                                onClick = {
                                    scope.launch {
                                        delay(2000)
                                        viewModel.onEvent(LoginEvent.Login)
                                        startActivity(
                                            Intent(
                                                this@LoginActivity,
                                                StoreActivity::class.java
                                            )
                                        )
                                        finish()
                                    }
                                },
                                label = state.value.label,
                                colorBorderButton = Black,
                                colorLabel = Black,
                                colorButton = Orange
                            )
                            AppSpace(appSizes = AppSpaceList.LARGE)
                        }
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = it.calculateTopPadding())
                            .fillMaxSize()
                    ) {
                        AppBackground(
                            painter = painterResource(id = R.drawable.bg),
                            backgroundDrawableResId = R.drawable.bg,
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize()
                        )
                        Column {
                            ItemMenu("Cadastro") {
                                viewModel.onEvent(LoginEvent.Register)
                            }
                            ItemMenu("Sobre") {
                                startActivity(Intent(this@LoginActivity, AboutActivity::class.java))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun ItemMenu(
    title: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(120.dp, 50.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 30.dp,
                        topStart = 30.dp
                    )
                )
                .background(Black.copy(alpha = .97f))
                .clickable(
                    indication = rememberRipple(color = Orange),
                    interactionSource = remember { MutableInteractionSource() },
                ) { onClick() }
        ) {
            Text(
                text = title,
                color = Orange,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
            )
        }
    }
}