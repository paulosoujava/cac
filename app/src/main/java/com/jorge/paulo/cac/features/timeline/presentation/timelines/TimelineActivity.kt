package com.jorge.paulo.cac.features.timeline.presentation.timelines

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.jorge.paulo.cac.core.commom.ui.components.AppFloatingButton
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInfo
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.AppTheme
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black25
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Orange50
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.about.AboutActivity
import com.jorge.paulo.cac.features.login.presentation.LoginActivity
import com.jorge.paulo.cac.features.registration.RegistrationActivity
import com.jorge.paulo.cac.features.timeline.presentation.util.TabPages
import com.jorge.paulo.cac.features.util.Permissions
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import kotlinx.coroutines.launch


class TimelineActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current

            var hasCamPermission by remember {
                mutableStateOf(
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED
                )
            }

            Permissions(onGranted = {
                hasCamPermission = it
            })
            val scope = rememberCoroutineScope()

            val scanLauncher = rememberLauncherForActivityResult(
                contract = ScanContract(),
                onResult = { result ->
                    if (result != null) {
                        Log.d("LOG", "scanned code: ${result.contents}")
                        startActivity(
                            Intent(
                                this@TimelineActivity,
                                RegistrationActivity::class.java
                            )
                        )

                    }
                }
            )
            val skipHalfExpanded by remember { mutableStateOf(false) }

            val stateModal = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                skipHalfExpanded = skipHalfExpanded
            )

            AppTheme {
                var state by remember { mutableStateOf(TabPages.STORE) }
                val titles = TabPages.values()

                AppInfo(state = stateModal) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                backgroundColor = Black,
                                title = {
                                    AppText(
                                        appTextTypes = AppTextList.TITLE,
                                        text = "Timeline",
                                        color = LightGray
                                    )
                                },
                                actions = {
                                    IconButton(onClick = {
                                        startActivity(
                                            Intent(
                                                this@TimelineActivity,
                                                AboutActivity::class.java
                                            )
                                        )
                                    }) {
                                        AppIcons(appIcons = AppIconList.INFO, color = LightGray)
                                    }
                                    IconButton(onClick = {
                                        startActivity(
                                            Intent(
                                                this@TimelineActivity,
                                                LoginActivity::class.java
                                            )
                                        )
                                    }) {
                                        AppIcons(appIcons = AppIconList.ACCOUNT, color = White)
                                    }
                                },
                            )
                        },
                        floatingActionButton = {
                            Column {
                                AppFloatingButton(
                                    icon = {
                                        AppIcons(
                                            appIcons = AppIconList.QRCODE,
                                            color = White
                                        )
                                    },
                                    onClick = {
                                        if (hasCamPermission)
                                            scanLauncher.launch(ScanOptions())
                                        else {
                                            scope.launch {
                                                stateModal.show()
                                            }
                                        }
                                    },
                                    shape = Shapes.large,
                                    backgroundColor = Black
                                )
                            }
                        }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .background(Black25)
                                .fillMaxSize()
                                .padding(top = it.calculateTopPadding())

                        ) {
                            TabRow(
                                selectedTabIndex = state.ordinal,
                                contentColor = Orange,
                                indicator = { position ->
                                    Box(
                                        Modifier
                                            .tabIndicatorOffset(position[state.ordinal])
                                            .height(1.dp)
                                            .border(1.dp, Orange)
                                    )
                                },
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(
                                            bottomEnd = 20.dp,
                                            bottomStart = 20.dp
                                        )
                                    ),
                                divider = {
                                    Box(
                                        Modifier
                                            .height(1.dp)
                                            .border(1.dp, Black)
                                    )
                                }
                            ) {
                                titles.forEachIndexed { index, title ->
                                    Tab(
                                        text = {
                                            Text(
                                                text = when (index) {
                                                    TabPages.PARTNER.ordinal -> "Sócio"
                                                    else -> "Estande"
                                                }
                                            )
                                        },
                                        selected = state.ordinal == index,
                                        onClick = {
                                            state = when (index) {
                                                TabPages.PARTNER.ordinal -> {
                                                    TabPages.PARTNER
                                                }
                                                else -> {
                                                    TabPages.STORE
                                                }
                                            }
                                        },
                                        selectedContentColor = Orange,
                                        unselectedContentColor = LightGray
                                    )
                                }
                            }
                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState())
                            ) {
                                when (state) {
                                    TabPages.STORE -> {
                                        repeat(3) {
                                            key(it) {
                                                Store(this@TimelineActivity)
                                            }
                                        }
                                        AppSpace(appSizes = AppSpaceList.XXXLARGE)
                                    }
                                    TabPages.PARTNER -> {
                                        ContentPartner(
                                            modifier = Modifier.weight(1f),

                                            )
                                    }
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AppText(appTextTypes = AppTextList.SMALL, text = "VS: 1.0")
                                }
                            }

                        }

                    }
                }
            }
        }
    }
}