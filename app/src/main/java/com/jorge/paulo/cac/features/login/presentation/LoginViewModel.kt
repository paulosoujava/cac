package com.jorge.paulo.cac.features.login.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.Login -> _state.value = state.value.copy(
                login = true,
                recovery = false,
                register = false,
                label = "Login"
            )
            LoginEvent.Recovery -> _state.value = state.value.copy(
                login = false,
                recovery = true,
                register = false,
                label = "Esqueci a senha"
            )
            LoginEvent.Register -> _state.value = state.value.copy(
                login = false,
                recovery = false,
                register = true,
                label = "Cadastro"
            )
        }

    }
}