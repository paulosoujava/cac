package com.jorge.paulo.cac.features.login.presentation

data class LoginState(
    val login: Boolean = true,
    val register: Boolean = false,
    val recovery: Boolean = false,
    val label: String = "Login",
)
