package com.jorge.paulo.cac.core.domain.models

data class Course(
    val title: String,
    val description: String,
    val startDate: String?,
    val endDate: String?,
    val hourBegin: String?,
    val hourEnd: String?,
)
