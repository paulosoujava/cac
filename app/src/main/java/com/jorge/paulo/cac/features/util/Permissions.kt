package com.jorge.paulo.cac.features.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.journeyapps.barcodescanner.ScanContract



@Composable
fun Permissions(
    onGranted: (Boolean) -> Unit
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            onGranted(granted)
        }
    )

    val scanLauncher = rememberLauncherForActivityResult(
        contract = ScanContract(),
        onResult = { result -> Log.d("LOG", "scanned code: ${result.contents}") }
    )
    LaunchedEffect(key1 = true) {
        launcher.launch(Manifest.permission.CAMERA)
    }
}