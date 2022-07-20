package com.jorge.paulo.cac.features.store

import com.jorge.paulo.cac.features.store.domain.Sections


data class StateStore(
   var currentFragment: Sections = Sections.HOME
)