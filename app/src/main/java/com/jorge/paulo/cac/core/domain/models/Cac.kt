package com.jorge.paulo.cac.core.domain.models

data class Cac(
    val name: String,
    val photo: String,
    val midia: Midia,
    val contact: Contact,
    val certificationsImages: List<String>,
    val sellerChange: List<SellerChange>,
    val arms: List<Arms>

)
