package com.jorge.paulo.cac.features.store.domain

import com.jorge.paulo.cac.core.commom.ui.components.AppIconList


enum class Sections(val type: String? = null, val icon: AppIconList? = null) {
    POST("Postar", AppIconList.EDIT),
    STORE("Loja", AppIconList.STORE),
    INSTRUCTOR("Instrutor", AppIconList.PISTOL),
    ADMINISTRATOR("Administrador", AppIconList.ADMINISTRATOR),
    PARTNER("Sócios", AppIconList.PARTNER),
    CAC("Cacs", AppIconList.ACCOUNT_BOX),
    NOTIFICATION("Mensagem", AppIconList.NOTIFICATION),
    COURSE("Cursos", AppIconList.SCHOOL),
    CHALLENGE("Desafios", AppIconList.CHALLENGE),
    PROFILE("Profile", AppIconList.ACCOUNT),
    HOME()
}
