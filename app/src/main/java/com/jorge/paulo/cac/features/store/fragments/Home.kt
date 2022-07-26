package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppCard
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.components.CardList
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments
import com.jorge.paulo.cac.features.store.domain.LabelIconOfHome
import kotlinx.coroutines.launch

const val MAX_CELLS = 2

enum class TypeModal {
    DELETE,
    LOGOUT,
    NONE
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(
    navigate: NavigateViewModel,
    onDeleteAccount: () -> Unit,
    onBack: () -> Unit,
    onClick: (String?) -> Unit,
) {

    val list = LabelIconOfHome.values().asList()
    val type = remember { mutableStateOf(TypeModal.NONE) }
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()


    Scaffold(
        topBar = {
            AppToolbar(
                onBack = { onBack() },
                title = "DASHBOARD"
            )

        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppButtons(
                    label = "DELETAR CONTA",
                    colorLabel = Red700,
                    appButtons = AppButtonList.TEXT,
                    onClick = {
                        type.value = TypeModal.DELETE
                        scope.launch { state.show() }
                    }
                )
                AppIcons(appIcons = AppIconList.DASHBOARD, color = LightGray)

                AppButtons(
                    label = "DESLOGAR",
                    colorLabel = Green,
                    appButtons = AppButtonList.TEXT,
                    onClick = {
                        type.value = TypeModal.LOGOUT
                        scope.launch { state.show() }
                    }
                )


            }

        }) { it ->
        ModalBottomSheetLayout(
            sheetState = state,
            sheetBackgroundColor = Black,
            scrimColor = Black.copy(alpha = .6f),
            sheetContent = {
                when (type.value) {
                    TypeModal.DELETE -> {
                        ContentModal(
                            "Deletar Conta",
                            "Você tem certeza que deseja deletar sua conta?  Após executar esta ação não poderemos recuperar os dados.",
                            "DELETAR",
                            onActionClick = {},
                            onCloseClick = {
                                type.value = TypeModal.NONE
                                scope.launch { state.hide() }
                            }
                        )
                    }
                    else -> {
                        ContentModal(
                            "Deslogar",
                            "Você deseja deslogar do app? Para retornar ao seu dashboard será necessário fazer o login, novamente.",
                            "OK, DESLOGAR",
                            colorButton = Green,
                            onActionClick = {
                                onBack()
                            },
                            onCloseClick = {
                                type.value = TypeModal.NONE
                                scope.launch { state.hide() }
                            }
                        )
                    }
                }
            }
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(MAX_CELLS),
                contentPadding = it
            ) {
                items(list) { fr ->
                    val (label, icon)= labelAndIconSectionHome(fr)
                    label?.let { it1 ->
                        AppCard(
                            label = it1,
                            icon = icon,
                            cardList = CardList.DEFAULT,
                            numBadge = numBadge(fr),
                            onClick ={onClick(fr.name)}
                        )
                    }
                    }
                }
            }
        }
    }

private fun numBadge(fragments: LabelIconOfHome): Int?{
   return when (fragments) {
       LabelIconOfHome.STORE -> 3
       LabelIconOfHome.INSTRUCTOR -> 10
       LabelIconOfHome.PARTNER -> 10
       LabelIconOfHome.CAC -> 100
       LabelIconOfHome.COURSE -> 10
       LabelIconOfHome.CHALLENGE -> 3
        else -> null
    }
}
private fun labelAndIconSectionHome(fragments: LabelIconOfHome):Pair<String?, AppIconList?>  {
    return when( fragments){
        LabelIconOfHome.POST -> Pair(LabelIconOfHome.POST.type, LabelIconOfHome.POST.icon)
        LabelIconOfHome.STORE ->   Pair(LabelIconOfHome.STORE.type, LabelIconOfHome.STORE.icon)
        LabelIconOfHome.INSTRUCTOR ->  Pair(LabelIconOfHome.INSTRUCTOR.type, LabelIconOfHome.INSTRUCTOR.icon)
        LabelIconOfHome.ADMINISTRATOR ->  Pair(LabelIconOfHome.ADMINISTRATOR.type, LabelIconOfHome.ADMINISTRATOR.icon)
        LabelIconOfHome.PARTNER ->   Pair(LabelIconOfHome.PARTNER.type, LabelIconOfHome.PARTNER.icon)
        LabelIconOfHome.CAC ->   Pair(LabelIconOfHome.CAC.type, LabelIconOfHome.CAC.icon)
        LabelIconOfHome.NOTIFICATION ->  Pair(LabelIconOfHome.NOTIFICATION.type, LabelIconOfHome.NOTIFICATION.icon)
        LabelIconOfHome.COURSE ->   Pair(LabelIconOfHome.COURSE.type, LabelIconOfHome.COURSE.icon)
        LabelIconOfHome.CHALLENGE ->  Pair(LabelIconOfHome.CHALLENGE.type, LabelIconOfHome.CHALLENGE.icon)
        LabelIconOfHome.PROFILE ->  Pair(LabelIconOfHome.PROFILE.type, LabelIconOfHome.PROFILE.icon)
        
    }
}


@Composable
private fun ContentModal(
    title: String,
    message: String,
    label: String,
    colorButton: Color = Red700,
    onCloseClick: () -> Unit,
    onActionClick: () -> Unit,
) {
    Column(
        Modifier
            .height(400.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                modifier = Modifier.weight(4f),
                appTextTypes = AppTextList.TITLE,
                color = White,
                text = title
            )
            AppButtons(
                modifier = Modifier.weight(1f),
                colorButton = Color.Transparent,
                colorLabel = White,
                appButtons = AppButtonList.ICON,
                appICons = { AppIcons(appIcons = AppIconList.CLOSE, color = LightGray) },
                onClick = { onCloseClick() })
        }

        AppDivider(
            Modifier.padding(10.dp)
        )
        AppText(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp),
            appTextTypes = AppTextList.BODY,
            maxLines = 10,
            color = LightGray,
            text = message
        )
        AppDivider(
            Modifier.padding(10.dp)
        )
        AppButtons(
            appButtons = AppButtonList.DEFAULT,
            onClick = { onActionClick() },
            colorButton = colorButton,
            label = label
        )
    }
}

