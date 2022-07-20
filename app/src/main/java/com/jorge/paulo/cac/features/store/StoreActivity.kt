package com.jorge.paulo.cac.features.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.features.store.domain.Sections
import com.jorge.paulo.cac.features.store.fragments.Clients
import com.jorge.paulo.cac.features.store.fragments.Home
import com.jorge.paulo.cac.features.store.fragments.Instructor
import com.jorge.paulo.cac.features.store.fragments.Section


class StoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigate: NavigateViewModel = hiltViewModel()
            val stateFragment = navigate.event.collectAsState()

            AppTheme {
                when (stateFragment.value.currentFragment) {
                    Sections.HOME -> Home(navigate){finish()}
                    Sections.STORE -> Section(navigate)
                    Sections.INSTRUCTOR -> Instructor(navigate)
                    Sections.CLIENT -> Clients(navigate)
                    Sections.ADMINISTRATOR -> TODO()
                    Sections.CAC -> TODO()
                    Sections.NOTIFICATION -> TODO()
                    Sections.COURSE -> TODO()
                    Sections.CHALLENGE -> TODO()
                }
            }
        }
    }
}