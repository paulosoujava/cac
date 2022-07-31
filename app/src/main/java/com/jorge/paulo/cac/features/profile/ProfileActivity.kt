package com.jorge.paulo.cac.features.profile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.features.profile.presentation.ProfileScreens
import com.jorge.paulo.cac.features.profile.presentation.cac.ProfileCacRead
import com.jorge.paulo.cac.features.profile.presentation.instructor.ProfileInstructorRead
import com.jorge.paulo.cac.features.profile.presentation.store.ProfileProduct
import com.jorge.paulo.cac.features.profile.presentation.store.ProfileProductDetail
import com.jorge.paulo.cac.features.profile.presentation.store.ProfileStore

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val it = intent
                val intent = Intent(
                    this@ProfileActivity,
                    ProfileActivity::class.java
                )
                when (it.action) {
                    ProfileScreens.CAC.screen -> {
                        ProfileCacRead(){
                            finish()
                        }
                    }
                    ProfileScreens.STORE.screen -> {
                        ProfileStore(
                            finish = { finish() },
                            onProduct = {

                                intent.action = ProfileScreens.PRODUCT.screen
                                startActivity(intent)
                            },
                            onInstructor = {
                                intent.action = ProfileScreens.INSTRUCTOR.screen
                                startActivity(intent)
                            }
                        )
                    }
                    ProfileScreens.INSTRUCTOR.screen -> {
                        ProfileInstructorRead(){ finish() }
                    }
                    ProfileScreens.PRODUCT.screen -> {
                        ProfileProduct(
                            navigateToDetail = {

                                intent.action = ProfileScreens.PRODUCT_DETAIL.screen
                                startActivity(intent)
                            },
                            finish = { finish() }
                        )
                    }
                    ProfileScreens.PRODUCT_DETAIL.screen -> {
                        ProfileProductDetail {
                            finish()
                        }
                    }
                    else -> finish()
                }
            }
        }
    }
}