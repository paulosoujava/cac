package com.jorge.paulo.cac.features.store.domain

import com.jorge.paulo.cac.core.commom.ui.components.AppIconList


enum class Sections(val type: String? = null, val icon: AppIconList? = null) {
    POST("Postar", AppIconList.INFO),
    STORE("Loja", AppIconList.INFO),
    INSTRUCTOR("Instrutor", AppIconList.SCHOOL),
    ADMINISTRATOR("Administrador", AppIconList.SHARE),
    PARTNER("Sócios", AppIconList.ACCOUNT),
    CAC("Cacs", AppIconList.QRCODE),
    NOTIFICATION("Mensagem", AppIconList.WHATS),
    COURSE("Cursos", AppIconList.EMAIL),
    CHALLENGE("Desafios", AppIconList.YOUTUBE),
    PROFILE("Profile", AppIconList.ACCOUNT),
    HOME()
}
