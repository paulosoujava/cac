package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppCard
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.components.CardList
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Sections

const val MAX_CELLS = 2

@Composable
fun Home(
    navigate: NavigateViewModel,
    onBack: () -> Unit
) {


    val list = Sections.values().asList()

    Scaffold(
        topBar = {
            AppToolbar(
                onBack = { onBack() },
                title = "Dashboard"
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
                    onClick = { /*TODO*/ }
                )
                AppButtons(
                    label = "DESLOGAR",
                    colorLabel = Green,
                    appButtons = AppButtonList.TEXT,
                    onClick = { /*TODO*/ }
                )
            }

        }) { it ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(MAX_CELLS),
            contentPadding = it
        ) {
            items(list) { section ->
                AppCard(
                    label = section.type,
                    icon = section.icon,
                    cardList = CardList.DEFAULT,
                    numBadge = when (section) {
                        Sections.HOME -> null
                        Sections.STORE -> 3
                        Sections.INSTRUCTOR -> 10
                        Sections.ADMINISTRATOR -> null
                        Sections.CLIENT -> 10
                        Sections.CAC -> 100
                        Sections.NOTIFICATION -> null
                        Sections.COURSE -> 10
                        Sections.CHALLENGE -> 3
                    },

                    onClick = {
                        when (section) {
                            Sections.HOME -> navigate.onNavigate(Sections.HOME)
                            Sections.STORE -> navigate.onNavigate(Sections.STORE)
                            Sections.INSTRUCTOR -> navigate.onNavigate(Sections.INSTRUCTOR)
                            Sections.CLIENT -> navigate.onNavigate(Sections.CLIENT)
                            Sections.ADMINISTRATOR -> TODO()
                            Sections.CAC -> TODO()
                            Sections.NOTIFICATION -> TODO()
                            Sections.COURSE -> TODO()
                            Sections.CHALLENGE -> TODO()
                        }
                    }
                )
            }
        }
    }
}