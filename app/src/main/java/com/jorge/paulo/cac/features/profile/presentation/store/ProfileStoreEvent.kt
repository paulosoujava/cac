package com.jorge.paulo.cac.features.profile.presentation.store

sealed interface ProfileStoreEvent {
    object AlertInfo : ProfileStoreEvent
    object AlertReport : ProfileStoreEvent
}
