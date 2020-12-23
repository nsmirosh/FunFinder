package com.nickmirosh.funfinder.features.venues.domain

data class VenueLocation(
    val distance: Int?,
    val address: String?,
    val lat: Double?,
    val lng: Double?
)