package com.jorge.paulo.cac.core.commom.ui.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.theme.Orange


enum class AppIconList(val icon: Int) {
    INFO(R.drawable.ic_baseline_info_24),
    ACCOUNT(R.drawable.ic_baseline_account_circle_24),
    ACCOUNT_BOX(R.drawable.ic_baseline_account_box_24),
    QRCODE(R.drawable.ic_qrcode),
    WHATS(R.drawable.whatsapp),
    LINKEDIM(R.drawable.linkedin),
    YOUTUBE(R.drawable.youtube),
    SITE(R.drawable.web),
    EMAIL(R.drawable.email),
    INSTAGRAM(R.drawable.instagram),
    FACEBOOK(R.drawable.facebook),
    PHONE(R.drawable.deskphone),
    PISTOL(R.drawable.pistol),
    BACK(R.drawable.ic_baseline_keyboard_arrow_left_24),
    ARROW_RIGHT(R.drawable.ic_baseline_keyboard_arrow_right_24),
    PLACE(R.drawable.ic_baseline_place_24),
    CONTACTS(R.drawable.ic_contacts_outline),
    SCHOOL(R.drawable.school),
    REPORT(R.drawable.ic_baseline_report_24),
    CLOSE(R.drawable.ic_baseline_close_24),
    SHARE(R.drawable.ic_baseline_share_24),
    EDIT(R.drawable.ic_baseline_edit_24),
    ARROW_UP(R.drawable.ic_baseline_keyboard_arrow_down_24),
    ARROW_DOWN(R.drawable.ic_baseline_keyboard_arrow_up_24),
    DELETE(R.drawable.ic_baseline_delete_24),
    CHECK(R.drawable.ic_baseline_check_24),
    OUTLINE_EMPTY_CHECK(R.drawable.ic_baseline_check_box_outline_blank_24),
    STORE(R.drawable.ic_store),
    ADMINISTRATOR(R.drawable.ic_baseline_admin_panel_settings_24),
    PARTNER(R.drawable.ic_baseline_supervisor_account_24),
    NOTIFICATION(R.drawable.ic_baseline_circle_notifications_24),
    CHALLENGE(R.drawable.ic_baseline_all_inclusive_24),
    DASHBOARD(R.drawable.ic_baseline_dashboard_24),
    CAMERA(R.drawable.ic_baseline_photo_camera_24),
    ADD(R.drawable.ic_baseline_add_24),
}

@Composable
fun AppIcons(modifier: Modifier = Modifier, appIcons: AppIconList, color: Color = Orange) {
    Icon(
        painter = painterResource(id = appIcons.icon),
        tint = color,
        contentDescription = "Icon",
        modifier = modifier
    )
}