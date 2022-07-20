package com.jorge.paulo.cac.features.store

import androidx.lifecycle.ViewModel
import com.jorge.paulo.cac.features.store.domain.Sections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigateViewModel: ViewModel() {

    private val _event=  MutableStateFlow(StateStore())
    val event: StateFlow<StateStore> = _event

    fun onNavigate(current: Sections){
        _event.value  = event.value.copy( currentFragment = current)
    }

}