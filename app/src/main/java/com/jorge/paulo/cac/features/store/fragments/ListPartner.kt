package com.jorge.paulo.cac.features.store.fragments

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.core.commom.ui.components.AppCArdWithOptions
import com.jorge.paulo.cac.core.commom.ui.components.AppSearchInput
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.features.profile.ProfileActivity
import com.jorge.paulo.cac.features.profile.presentation.ProfileScreens
import com.jorge.paulo.cac.features.store.NavigateViewModel
import com.jorge.paulo.cac.features.store.domain.Fragments
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@Composable
fun Partner(navigate: NavigateViewModel) {
    val context = LocalContext.current
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
        scrollStrategy = ScrollStrategy.EnterAlways, // EnterAlways, EnterAlwaysCollapsed, ExitUntilCollapsed are available,
        toolbar = {
            Column {
                AppToolbar(
                    onBack = {
                        navigate.onNavigate(Fragments.HOME)
                    },
                    title = "Sócios"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    AppSearchInput(textState)
                }
            }
        }
    ) {
        LazyColumn {
            items(120) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    AppCArdWithOptions(
                        onInactive = { /*TODO*/ },
                        onActive = { /*TODO*/ }) {
                        val intent = Intent(context, ProfileActivity::class.java)
                        intent.action = ProfileScreens.CAC.screen
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}
