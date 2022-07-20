package com.jorge.paulo.cac.features.login.presentation


sealed interface LoginEvent{
    object Login: LoginEvent
    object Register: LoginEvent
    object Recovery: LoginEvent
}