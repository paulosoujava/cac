package com.jorge.paulo.cac.features.splash.presentation

sealed class SplashEvent{
    object Idle: SplashEvent()
    object Redirect: SplashEvent()
}
