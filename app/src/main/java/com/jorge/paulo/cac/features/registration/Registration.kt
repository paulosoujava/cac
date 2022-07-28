package com.jorge.paulo.cac.features.registration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
import com.jorge.paulo.cac.core.commom.ui.components.AppSelectedItem
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.features.splash.presentation.SplashViewModel
import kotlinx.coroutines.launch


class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(topBar = {
                    AppToolbar(onBack = { finish() }, title = "Nome do lugar")
                }) {
                    Box(modifier = Modifier.padding(it)) {
                        Registration()
                    }
                }

            }
        }
    }
}


@Composable
private fun Registration() {

    var selectedCac by remember { mutableStateOf(false) }
    var selectedInstructor by remember { mutableStateOf(false) }
    val name = remember { mutableStateOf("") }

    Column(Modifier.padding(20.dp)) {
        AppText(appTextTypes = AppTextList.TITLE, text = "Pré Cadastro", color = LightGray)
        Divider(Modifier.padding(top = 10.dp, bottom = 20.dp), color = LightGray)

        AppText(appTextTypes = AppTextList.SMALL, text = "Selecione um tipo: ", color = LightGray)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppSelectedItem(selected = selectedCac, label = "CAC") {
                selectedCac = true
                selectedInstructor = !selectedCac
            }
            AppSelectedItem(selected = selectedInstructor, label = "Instrutor") {
                selectedInstructor = true
                selectedCac = !selectedInstructor
            }
        }
        Column(Modifier.padding(10.dp)) {
            AppInputDefault(
                onValueChange = {
                    name.value = it
                },
                value = name.value,
                label = "Nome Completo",
                keyboardType = KeyboardType.Text
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            AppInputDefault(
                onValueChange = {
                    name.value = it
                },
                value = name.value,
                label = "Email",
                keyboardType = KeyboardType.Text
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            AppInputDefault(
                onValueChange = {
                    name.value = it
                },
                value = name.value,
                label = "CPF",
                keyboardType = KeyboardType.Text
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
        }

        AppButtons(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            colorButton = Black,
            label = "Cadastrar",
            appButtons = AppButtonList.DEFAULT,
            onClick = { /*TODO*/ })

        Divider(Modifier.padding(top = 40.dp, bottom = 20.dp), color = LightGray)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppIcons(appIcons = AppIconList.INFO, color = LightGray)
        }
        AppText(
            modifier = Modifier.padding(20.dp),
            appTextTypes = AppTextList.SMALL,
            maxLines = 10,
            text = "Lembramos que este é um pré cadastro e está sujeito a aprovação da caso a qual" +
                    "você é afiliado/instrutor ",
            color = LightGray
        )

    }

}


