package com.jorge.paulo.cac.features.profile.presentation.store

import androidx.lifecycle.ViewModel
import com.jorge.paulo.cac.core.commom.ui.components.AppAlertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileStoreViewModel: ViewModel() {
    private val _state = MutableStateFlow(ProfileStoreState())
    val state: StateFlow<ProfileStoreState> = _state


    fun onEvent(alertList: AppAlertList){
        when(alertList){
            AppAlertList.INFO -> _state.value = state.value.copy(alertType = AppAlertList.INFO)
            AppAlertList.REPORT -> _state.value = state.value.copy(alertType = AppAlertList.REPORT)
            AppAlertList.CONFIRMATION -> _state.value = state.value.copy(alertType = AppAlertList.CONFIRMATION)
        }
    }

    fun closeAlert(){
        _state.value = state.value.copy(alertType = null)
    }
}