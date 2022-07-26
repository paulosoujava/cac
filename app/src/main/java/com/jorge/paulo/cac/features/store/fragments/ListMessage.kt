package com.jorge.paulo.cac.features.store.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments

@Composable
fun Message(navigate: NavigateViewModel
) {
    Scaffold(
        topBar = {
            AppToolbar(
                onBack = { navigate.onNavigate(Fragments.HOME) },
                title = "Title")
        }
    ) {
        Column(Modifier.padding(it)) {

        }
    }

}