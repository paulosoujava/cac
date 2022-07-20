package com.jorge.paulo.cac.features.profile.presentation.store

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppCardTitleWithDescAndSeeMore
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme

@Composable
fun ProfileProduct(
    navigateToDetail: () -> Unit,
    finish: () -> Unit
) {


                Scaffold(
                    topBar = {
                            AppToolbar(
                                onBack = {
                                    finish()
                                },
                                title = "Nome do Produto"
                            )
                    }
                ) {
                    Column(
                        Modifier
                            .padding(top = it.calculateTopPadding())
                            .verticalScroll(rememberScrollState())
                    ) {
                        repeat(5) {
                            repeat(4) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                ) {
                                    AppCardTitleWithDescAndSeeMore(onClick = {
                                        navigateToDetail()
                                        /*startActivity(
                                            Intent(
                                                this@ProductActivity,
                                                ProductDetailActivity::class.java
                                            )
                                        )*/
                                    })
                                    AppCardTitleWithDescAndSeeMore(onClick = {
                                        navigateToDetail()
                                        /**/
                                    })
                                }
                            }

                        }

                    }

                }
            }


