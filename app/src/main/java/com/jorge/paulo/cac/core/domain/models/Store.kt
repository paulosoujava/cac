package com.jorge.paulo.cac.core.domain.models

data class Store(
    val name: String,
    val description:String,
    val schedule: String,
    val address: Address,
    val accountable: Accountable,
    val midia: Midia,
    val contact: Contact,
    val sections: List<SectionStore>,
    val informations: List<Information>,
    val courses: List<Course>
)