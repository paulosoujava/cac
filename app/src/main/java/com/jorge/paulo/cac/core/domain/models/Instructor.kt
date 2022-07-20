package com.jorge.paulo.cac.core.domain.models

data class Instructor(
    val name: String,
    val contact: Contact,
    val midia: Midia,
    val arms: List<Arms>,
    val sellerChange: List<SellerChange>,
    val courseITeacher: List<Course>,
    val challenge: List<Challenge>
)
