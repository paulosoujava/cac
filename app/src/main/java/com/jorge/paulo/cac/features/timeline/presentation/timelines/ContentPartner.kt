package com.jorge.paulo.cac.features.timeline.presentation.timelines

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInfo
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.util.Permissions
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import kotlinx.coroutines.launch


@Composable
fun ContentPartner(
    modifier: Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(top = 70.dp)
            .fillMaxSize()
    ) {

        AppIcons(
            modifier = Modifier.size(30.dp),
            appIcons = AppIconList.QRCODE,
            color = White
        )
        Box(
            Modifier
                .width(250.dp)
                .padding(top = 15.dp)
        ) {
            AppText(
                appTextTypes = AppTextList.SMALL,
                maxLines = 5,
                color = LightGray,
                text = "Para o seu primeiro acesso, clique em scanear e aponte a camera ao QRCode do " +
                        "seu estande, concluia seu cadastro, após isso." +
                        "Lembramos que o scanner no primeiro momento te cadastrará e após isso ele " +
                        "registrará seus acessos ao estande, não tem necessidade de após o cadastro, registrar" +
                        "o acesso pois o mesmo se dá automaticamente!"
            )
        }


        AppDivider(
            modifier = Modifier.padding(
                top = 50.dp,
                start = 10.dp,
                end = 10.dp,
                bottom = 50.dp
            ),
            color = Black.copy(alpha = .4f)
        )
        Box(
            Modifier
                .width(250.dp)
                .padding(top = 15.dp)
        ) {
            AppText(
                modifier = Modifier.padding(start = 25.dp, end = 25.dp),
                appTextTypes = AppTextList.SMALL,
                maxLines = 5,
                color = LightGray,
                text = "Seu estande, não conhece  este app? Compartilhe com eles esta ideia."
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 15.dp)
                .size(140.dp, 40.dp)
                .border(1.dp, LightGray)
                .clickable { }
        ) {
            AppText(
                appTextTypes = AppTextList.SMALL,
                color = LightGray,
                text = "Compartilhar"
            )
            AppSpace(appSizes = AppSpaceList.SMALL)
            AppIcons(
                appIcons = AppIconList.SHARE,
                color = LightGray,
                modifier = Modifier.size(14.dp)
            )
        }
        AppSpace(appSizes = AppSpaceList.XXXLARGE)
    }
}




