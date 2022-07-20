package com.jorge.paulo.cac.core.domain.models

enum class SellerChangeType{
    SELLER,
    CHANGE,
    SELLER_CHANGE
}

data class SellerChange(
    val name: String,
    val imageUrl: String,
    val description: String,
    val value: String,
    val type: SellerChangeType
)
