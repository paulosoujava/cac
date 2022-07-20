package com.jorge.paulo.cac.core.domain.models

import androidx.compose.ui.graphics.Color

data class SectionStore(
    val type: String,
    val status: Boolean, //[ativa ou desativa a secao]
    val color: Color?,
    val products: List<Product>
)
