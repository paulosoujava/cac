package com.jorge.paulo.cac.features.store

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.features.profile.ProfileActivity
import com.jorge.paulo.cac.features.profile.presentation.ProfileScreens
import com.jorge.paulo.cac.features.store.domain.Fragments
import com.jorge.paulo.cac.features.store.fragments.Administrator
import com.jorge.paulo.cac.features.store.fragments.Cac
import com.jorge.paulo.cac.features.store.fragments.Challenge
import com.jorge.paulo.cac.features.commom.Course
import com.jorge.paulo.cac.features.store.fragments.EditChallenge
import com.jorge.paulo.cac.features.commom.EditCourse
import com.jorge.paulo.cac.features.store.fragments.EditProduct
import com.jorge.paulo.cac.features.store.fragments.Partner
import com.jorge.paulo.cac.features.store.fragments.Home
import com.jorge.paulo.cac.features.store.fragments.Instructor
import com.jorge.paulo.cac.features.store.fragments.ListSection
import com.jorge.paulo.cac.features.store.fragments.Message
import com.jorge.paulo.cac.features.store.fragments.Post
import com.jorge.paulo.cac.features.store.fragments.Profile
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

                    Fragments.POST -> Post(navigate)

                    Fragments.STORE -> Section(navigate)

                    Fragments.PARTNER -> Partner(navigate)

                    Fragments.ADMINISTRATOR -> Administrator(navigate)

                    Fragments.NOTIFICATION -> Message(navigate)

                    Fragments.COURSE -> Course(
                        onClickBack = { navigate.onNavigate(Fragments.HOME) },
                        onNavigate = {
                            navigate.onNavigate(Fragments.EDIT_COURSE_SECTION)
                        }
                    )

                    Fragments.EDIT_COURSE_SECTION -> EditCourse(onNavigate = {
                        navigate.onNavigate(Fragments.COURSE)
                    })

                    Fragments.CHALLENGE -> Challenge(navigate)

                    Fragments.EDIT_CHALLENGE_SECTION -> EditChallenge(navigate)

                    Fragments.PROFILE -> Profile(navigate)

                    Fragments.LIST_STORE_SECTION -> ListSection(navigate)

                    Fragments.EDIT_PRODUCT_SECTION -> EditProduct(navigate)

                    Fragments.INSTRUCTOR -> Instructor(navigate) {
                        intent.action = ProfileScreens.INSTRUCTOR.screen
                        startActivity(intent)
                    }
                    Fragments.CAC -> Cac(navigate) {
                        intent.action = ProfileScreens.CAC.screen
                        startActivity(intent)
                    }
                    else -> {
                        Home(navigate,
                            onDeleteAccount = {},
                            onBack = { finish() },
                            onClick = { navigateSection(it, navigate) }
                        )
                    }
                }


            }
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Toast.makeText(
            this@StoreActivity,
            "Por favor use as setas do app para navegar",
            Toast.LENGTH_LONG
        ).show()
    }
}


private fun navigateSection(type: String?, navigate: NavigateViewModel) {
    if (type.isNullOrBlank()) return
    return when (type) {
        Fragments.POST.name -> navigate.onNavigate(Fragments.POST)
        Fragments.HOME.name -> navigate.onNavigate(Fragments.HOME)
        Fragments.STORE.name -> navigate.onNavigate(Fragments.STORE)
        Fragments.INSTRUCTOR.name -> navigate.onNavigate(Fragments.INSTRUCTOR)
        Fragments.PARTNER.name -> navigate.onNavigate(Fragments.PARTNER)
        Fragments.CAC.name -> navigate.onNavigate(Fragments.CAC)
        Fragments.ADMINISTRATOR.name -> navigate.onNavigate(Fragments.ADMINISTRATOR)
        Fragments.NOTIFICATION.name -> navigate.onNavigate(Fragments.NOTIFICATION)
        Fragments.COURSE.name -> navigate.onNavigate(Fragments.COURSE)
        Fragments.CHALLENGE.name -> navigate.onNavigate(Fragments.CHALLENGE)
        Fragments.PROFILE.name -> navigate.onNavigate(Fragments.PROFILE)
        Fragments.LIST_STORE_SECTION.name -> navigate.onNavigate(Fragments.LIST_STORE_SECTION)
        Fragments.EDIT_PRODUCT_SECTION.name -> navigate.onNavigate(Fragments.EDIT_PRODUCT_SECTION)
        Fragments.EDIT_COURSE_SECTION.name -> navigate.onNavigate(Fragments.EDIT_COURSE_SECTION)
        Fragments.EDIT_CHALLENGE_SECTION.name -> navigate.onNavigate(Fragments.EDIT_CHALLENGE_SECTION)
        else -> throw Exception("ERROR PAGE")
    }
}