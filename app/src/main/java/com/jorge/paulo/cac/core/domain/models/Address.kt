package com.jorge.paulo.cac.core.domain.models

data class Address(
    val street: String,
    val number: String,
    val zipCode: String,
    val state: String,
    val city: String,
    val complement: String
)
