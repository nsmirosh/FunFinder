package com.nickmirosh.funfinder.features.venues.domain

data class VenueReasonGroup (
    val type: String,
    val name: String,
    val items: List<VenueAndReasons>
)