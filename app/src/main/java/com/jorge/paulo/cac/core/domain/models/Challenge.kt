package com.jorge.paulo.cac.core.domain.models

data class Challenge(
    val title: String,
    val description: String,
    val hasPremium: Boolean,
    val value: String = "0.0",
    val attempts: Int = 0
)
