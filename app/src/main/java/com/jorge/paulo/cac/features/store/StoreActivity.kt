package com.jorge.paulo.cac.features.store

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.features.profile.ProfileActivity
import com.jorge.paulo.cac.features.profile.presentation.ProfileScreens
import com.jorge.paulo.cac.features.store.domain.Sections
import com.jorge.paulo.cac.features.store.fragments.Cac
import com.jorge.paulo.cac.features.store.fragments.Partner
import com.jorge.paulo.cac.features.store.fragments.Home
import com.jorge.paulo.cac.features.store.fragments.Instructor
import com.jorge.paulo.cac.features.store.fragments.Section


class StoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigate: NavigateViewModel = hiltViewModel()
            val stateFragment = navigate.event.collectAsState()
            val intent = Intent(
                this@StoreActivity,
                ProfileActivity::class.java
            )

            AppTheme {
                when (stateFragment.value.currentFragment) {
                    Sections.HOME -> Home(navigate) { finish() }
                    Sections.STORE -> Section(navigate)
                    Sections.INSTRUCTOR -> Instructor(navigate){
                        intent.action = ProfileScreens.INSTRUCTOR.screen
                        startActivity(intent)
                    }
                    Sections.PARTNER -> Partner(navigate)
                    Sections.CAC -> Cac(navigate){
                        intent.action = ProfileScreens.CAC.screen
                        startActivity(intent)
                    }
                    Sections.ADMINISTRATOR -> TODO()
                    Sections.NOTIFICATION -> TODO()
                    Sections.COURSE -> TODO()
                    Sections.CHALLENGE -> TODO()
                }
            }
        }
    }
}