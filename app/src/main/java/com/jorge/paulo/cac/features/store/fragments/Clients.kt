package com.jorge.paulo.cac.features.store.fragments

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppProfile
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.components.Type
import com.jorge.paulo.cac.features.profile.ProfileActivity
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Sections


@Composable
fun Clients(navigate: NavigateViewModel) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppToolbar(
                onBack = {
                    navigate.onNavigate(Sections.HOME)
                },
                title = "Clientes"
            )
        }
    ) {
        Column(
            Modifier
                .padding(
                    top = it.calculateTopPadding(),
                    start = 10.dp, end = 10.dp
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(5) {
                AppProfile(
                    type = Type.PRIVATE,
                    onInactive = { /*TODO*/ },
                    onActive = { /*TODO*/ }) {
                    val intent = Intent(context, ProfileActivity::class.java)
                    intent.action = "CAC"
                    context.startActivity(intent)
                }
            }
        }
    }
}
