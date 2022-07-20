package com.jorge.paulo.cac.features.splash.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    init {
        onEvent(SplashEvent.Idle)
    }

    private fun onEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.Redirect -> _state.value = state.value.copy(loading = false)
            SplashEvent.Idle -> {
                _state.value = state.value.copy(loading = true)
                viewModelScope.launch {
                    fetchData()
                }

            }
        }
    }

    private suspend fun fetchData() {
        delay(3000)
        onEvent(SplashEvent.Redirect)
    }
}