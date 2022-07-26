package com.jorge.paulo.cac.features.store

import com.jorge.paulo.cac.features.store.domain.Fragments


data class StateStore(
   var currentFragment: Fragments = Fragments.HOME

)